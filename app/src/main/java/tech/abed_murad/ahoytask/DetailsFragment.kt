package tech.abed_murad.ahoytask

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import tech.abed_murad.ahoytask.CONST.KEY_DAY_WEATHER
import tech.abed_murad.ahoytask.databinding.FragmentDetialsBinding
import tech.abed_murad.ahoytask.local.model.ForecastResponse.DayWeather

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailsFragment : Fragment() {
    private lateinit var mBinding: FragmentDetialsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detials, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dayWeather = arguments?.getParcelable<DayWeather>(KEY_DAY_WEATHER)
        mBinding.today = dayWeather
        mBinding.dateDayTV.text = dayWeather!!.dt.getDay()
        mBinding.sunriseTV.text = dayWeather.sunrise.getTime()
        mBinding.sunsetTV.text = dayWeather.sunset.getTime()
        mBinding.weatherIconIV.setImageResource(dayWeather.weather[0].main.getWeatherIcon())


        val db = (requireActivity().application as MyApplication).local
        val weatherDao = db.dayWeatherDao()


        val result = weatherDao.getAll().value
        Log.d("ttt", result.toString())

    }

}