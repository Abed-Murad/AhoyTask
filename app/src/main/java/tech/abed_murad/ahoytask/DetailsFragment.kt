package tech.abed_murad.ahoytask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_detials.*
import tech.abed_murad.ahoytask.databinding.FragmentDetialsBinding
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

        val dayWeather = arguments?.getParcelable<tech.abed_murad.local.model.ForecastResponse.DayWeather>("dayWeatherArg")
        weatherDescriptionTV.text = dayWeather!!.weather[0].description
    }

}