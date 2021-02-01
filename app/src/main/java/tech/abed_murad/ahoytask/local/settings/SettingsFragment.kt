package tech.abed_murad.ahoytask.local.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chibatching.kotpref.livedata.asLiveData
import tech.abed_murad.ahoytask.CONST
import tech.abed_murad.ahoytask.R
import tech.abed_murad.ahoytask.databinding.FragmentSettingsBinding
import tech.abed_murad.ahoytask.local.model.GlobalUserInfo


class SettingsFragment : Fragment() {
    private lateinit var viewModel: SettingsViewModel
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
        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)


        requireActivity().findViewById<RadioGroup>(R.id.radioGroup)
            .setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
                Log.d("ttt", "$checkedId")
            })
                if (GlobalUserInfo.temperatureUnit == CONST.KEY_METRIC) {
                    mBinding.centigradeSwitch.isChecked = true
                    mBinding.fahrenheitSwitch.isChecked = false
                } else {
                    mBinding.fahrenheitSwitch.isChecked = true
                    mBinding.centigradeSwitch.isChecked = false
                }




        mBinding.centigradeSwitch
            .setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    GlobalUserInfo.temperatureUnit = CONST.KEY_METRIC
                    mBinding.fahrenheitSwitch.isChecked = false
                }
            }

        mBinding.fahrenheitSwitch
            .setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    GlobalUserInfo.temperatureUnit = CONST.KEY_IMPERIAL
                    mBinding.centigradeSwitch.isChecked = false
                }
            }

    }

}