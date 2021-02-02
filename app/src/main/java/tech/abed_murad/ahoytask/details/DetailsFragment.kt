package tech.abed_murad.ahoytask.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import tech.abed_murad.ahoytask.R
import tech.abed_murad.ahoytask.databinding.FragmentDetialsBinding
import tech.abed_murad.ahoytask.util.getDay
import tech.abed_murad.ahoytask.util.getTime
import tech.abed_murad.ahoytask.util.getWeatherIcon
import tech.abed_murad.local.CONST.KEY_DAY_WEATHER
import tech.abed_murad.local.model.ForecastResponse

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

        val dayWeather = arguments?.getParcelable<ForecastResponse.DayWeather>(KEY_DAY_WEATHER)
        mBinding.today = dayWeather
        mBinding.dateDayTV.text = dayWeather!!.dt.getDay()
        mBinding.sunriseTV.text = dayWeather.sunrise.getTime()
        mBinding.sunsetTV.text = dayWeather.sunset.getTime()
        mBinding.weatherIconIV.setImageResource(dayWeather.weather[0].main.getWeatherIcon())
    }

}