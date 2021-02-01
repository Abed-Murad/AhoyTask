package tech.abed_murad.ahoytask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chibatching.kotpref.livedata.asLiveData
import tech.abed_murad.ahoytask.CONST.KEY_DAY_WEATHER
import tech.abed_murad.ahoytask.databinding.FragmentMainBinding
import tech.abed_murad.ahoytask.repository.WeatherRepository
import tech.abed_murad.ahoytask.viewmodel.MainFragmentViewModel
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.GlobalUserInfo


class MainFragment : Fragment(), ForecastAdapter.RecyclerOnItemClickListener {

    private lateinit var mBinding: FragmentMainBinding

    lateinit var mViewModel: MainFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main, container,
            false
        )
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val application = requireActivity().application as MyApplication
        val weatherRepository = WeatherRepository(application.remote, application.local)

        mViewModel = MainFragmentViewModel(weatherRepository)
        mBinding.viewModel = mViewModel

        GlobalUserInfo.asLiveData(GlobalUserInfo::lat)
            .observe(viewLifecycleOwner, Observer<String> {
                updateUI()
            })

        GlobalUserInfo.asLiveData(GlobalUserInfo::temperatureUnit)
            .observe(viewLifecycleOwner, Observer<String> { unit ->
                mViewModel.updateLocalDatabase()
            })


    }

    private fun updateUI() {
        updateForecastUI()
        updateTodayWeatherUI()
    }

    private fun updateTodayWeatherUI() {
        mViewModel.getTodayWeather()
            .observe(viewLifecycleOwner, Observer { todayWeather ->
                mBinding.today = todayWeather
                mBinding.weatherIconIV
                    .setImageResource(todayWeather.weather[0].main.getWeatherIcon())
                mBinding.headerProgressBar.visibility = View.GONE
                mBinding.detailWeatherCard.visibility = View.VISIBLE
                if (todayWeather.dt.toLong() > GlobalUserInfo.currentDayTimeStamp) {
                    GlobalUserInfo.currentDayTimeStamp = todayWeather.dt.toLong()
                    mViewModel.updateLocalDatabase()
                }
            })
    }

    private fun updateForecastUI() {

        mViewModel.getForecastWeather()
            .observe(viewLifecycleOwner, Observer { forecastList ->

                val list = forecastList as ArrayList


                mBinding.forecastRecyclerView.adapter =
                    ForecastAdapter(this@MainFragment, list)
                mBinding.forecastRecyclerView.layoutManager = LinearLayoutManager(context)
                mBinding.forecastRecyclerView.setHasFixedSize(true)
                mBinding.forecastRecyclerView.isNestedScrollingEnabled = false
                mBinding.forecastRecyclerView.visibility = View.VISIBLE
                mBinding.progressBar.visibility = View.GONE
            })
    }

    override fun onItemClick(selectedDay: ForecastResponse.DayWeather) {
        val bundle = Bundle()
        bundle.putParcelable(KEY_DAY_WEATHER, selectedDay)
        findNavController().navigate(R.id.action_MainFragment_to_DetailsFragment, bundle)
    }


}

