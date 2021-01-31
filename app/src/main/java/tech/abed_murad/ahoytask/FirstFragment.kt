package tech.abed_murad.ahoytask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import tech.abed_murad.ahoytask.databinding.FragmentFirstBinding
import tech.abed_murad.ahoytask.model.DayWeather

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), ForecastAdapter.RecyclerOnItemClickListener {
    private lateinit var mBinding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        mBinding.forecastRecyclerView.adapter = ForecastAdapter(this@FirstFragment)
        mBinding.forecastRecyclerView.layoutManager = LinearLayoutManager(context)
        mBinding.forecastRecyclerView.setHasFixedSize(true)
        mBinding.forecastRecyclerView.isNestedScrollingEnabled = false;



    }

    override fun onItemClick(selectedDay: DayWeather) {
        Toast.makeText(context, "${selectedDay.today} is the chosen one", Toast.LENGTH_SHORT)
            .show()
    }
}