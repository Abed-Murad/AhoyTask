package tech.abed_murad.ahoytask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import tech.abed_murad.ahoytask.databinding.FragmentMainBinding
import tech.abed_murad.ahoytask.model.DayWeather

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment(), ForecastAdapter.RecyclerOnItemClickListener {
    private lateinit var mBinding: FragmentMainBinding
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

        mBinding.buttonFirst.setOnClickListener { findNavController().navigate(R.id.action_MainFragment_to_DetailsFragment) }
        mBinding.forecastRecyclerView.adapter = ForecastAdapter(this@MainFragment)
        mBinding.forecastRecyclerView.layoutManager = LinearLayoutManager(context)
        mBinding.forecastRecyclerView.setHasFixedSize(true)
        mBinding.forecastRecyclerView.isNestedScrollingEnabled = false;



    }

    override fun onItemClick(selectedDay: DayWeather) {

        findNavController().navigate(R.id.action_MainFragment_to_DetailsFragment)
    }
}