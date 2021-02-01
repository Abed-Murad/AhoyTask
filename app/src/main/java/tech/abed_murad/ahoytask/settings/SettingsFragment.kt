package tech.abed_murad.ahoytask.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import tech.abed_murad.ahoytask.MyApplication
import tech.abed_murad.ahoytask.R
import tech.abed_murad.ahoytask.databinding.FragmentSettingsBinding
import tech.abed_murad.local.CONST
import tech.abed_murad.repository.WeatherRepository

class SettingsFragment : Fragment() {
    private lateinit var mViewModel: SettingsViewModel
    private lateinit var mBinding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_settings, container,
            false
        )
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val application = requireActivity().application as MyApplication
        val weatherRepository = WeatherRepository(application.remote, application.local)
        mViewModel = SettingsViewModel(weatherRepository)

        populateUI()
        initLayoutListeners()

    }

    private fun populateUI() {
        if (mViewModel.getTemperatureUnit() == CONST.KEY_METRIC) {
            mBinding.centigradeSwitch.isChecked = true
            mBinding.fahrenheitSwitch.isChecked = false
        } else {
            mBinding.fahrenheitSwitch.isChecked = true
            mBinding.centigradeSwitch.isChecked = false
        }
    }

    private fun initLayoutListeners() {
        mBinding.centigradeSwitch
            .setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    mViewModel.updateTemperatureUnit(CONST.KEY_METRIC)
                    mBinding.fahrenheitSwitch.isChecked = false
                }
            }

        mBinding.fahrenheitSwitch
            .setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    mViewModel.updateTemperatureUnit(CONST.KEY_IMPERIAL)
                    mBinding.centigradeSwitch.isChecked = false
                }
            }
    }

}