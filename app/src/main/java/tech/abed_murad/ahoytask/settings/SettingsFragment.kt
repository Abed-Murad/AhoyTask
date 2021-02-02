package tech.abed_murad.ahoytask.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import tech.abed_murad.ahoytask.R
import tech.abed_murad.ahoytask.databinding.FragmentSettingsBinding
import tech.abed_murad.local.CONST


class SettingsFragment : Fragment() {
    private val mViewModel: SettingsViewModel by viewModel()
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
        mBinding.centigradeSwitch.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    mViewModel.updateTemperatureUnit(CONST.KEY_METRIC)
                    mBinding.fahrenheitSwitch.isChecked = false
                } else {
                    mBinding.fahrenheitSwitch.isChecked = true
                    mViewModel.updateTemperatureUnit(CONST.KEY_IMPERIAL)
                }
            }

        mBinding.fahrenheitSwitch
            .setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    mViewModel.updateTemperatureUnit(CONST.KEY_IMPERIAL)
                    mBinding.centigradeSwitch.isChecked = false
                } else {
                    mBinding.centigradeSwitch.isChecked = true
                    mViewModel.updateTemperatureUnit(CONST.KEY_METRIC)

                }
            }
    }

}