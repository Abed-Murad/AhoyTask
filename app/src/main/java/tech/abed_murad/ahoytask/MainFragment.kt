package tech.abed_murad.ahoytask

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import tech.abed_murad.ahoytask.databinding.FragmentMainBinding
import tech.abed_murad.ahoytask.local.model.ForecastResponse.DayWeather
import tech.abed_murad.ahoytask.repository.WeatherRepository
import tech.abed_murad.ahoytask.viewmodel.MainFragmentViewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment(), ForecastAdapter.RecyclerOnItemClickListener {


    private lateinit var mBinding: FragmentMainBinding


    lateinit var mViewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val application = requireActivity().application as MyApplication
        val weatherRepository =
            WeatherRepository(application.getWeatherService(), application.weatherDatabase())

        mViewModel = MainFragmentViewModel(weatherRepository)
        mBinding.viewModel = mViewModel



        mViewModel.getForecastWeather("REMOVEMEMEMWME", "REMOVEMEMEMWME")
            .observe(viewLifecycleOwner, Observer { forecastList ->
                mBinding.forecastRecyclerView.adapter =
                    ForecastAdapter(this@MainFragment, forecastList)
                mBinding.forecastRecyclerView.layoutManager = LinearLayoutManager(context)
                mBinding.forecastRecyclerView.setHasFixedSize(true)
                mBinding.forecastRecyclerView.isNestedScrollingEnabled = false
                mBinding.forecastRecyclerView.visibility = View.VISIBLE
                mBinding.progressBar.visibility = View.GONE
//            weatherDao.insertAll(response.body()!!.list)
            })


        mViewModel.getTodayWeather("REMOVEMEMEMWME", "REMOVEMEMEMWME")
            .observe(viewLifecycleOwner, Observer { todayWeather ->
                mBinding.today = todayWeather
                mBinding.weatherIconIV.setImageResource(todayWeather.weather[0].main.getImageIcon())
            })
    }


//        mBinding.progressBar.visibility = View.GONE
//        Toast.makeText(
//            activity,
//            "Something went wong, Please try again later!",
//            Toast.LENGTH_SHORT
//        ).show()
//


    override fun onItemClick(selectedDay: DayWeather) {
        val bundle = Bundle()
        bundle.putParcelable("dayWeatherArg", selectedDay)
        findNavController().navigate(R.id.action_MainFragment_to_DetailsFragment, bundle)
    }


}

