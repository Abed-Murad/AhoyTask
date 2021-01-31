package tech.abed_murad.ahoytask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.abed_murad.ahoytask.databinding.FragmentMainBinding
import tech.abed_murad.ahoytask.local.model.ForecastResponse
import tech.abed_murad.ahoytask.network.WeatherService
import tech.abed_murad.ahoytask.local.model.ForecastResponse.DayWeather


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


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

        val call = weatherService.getCurrentWeatherData(
            "31.388520",
            "34.702372",
            "10",
            "c9da7f4769c845195c654aa2c0d3f16b"
        )

        val db = (requireActivity().application as MyApplication).instance
        val weatherDao = db.dayWeatherDao()


        call.enqueue(object : Callback<ForecastResponse> {
            override fun onResponse(
                call: Call<ForecastResponse>,
                response: Response<ForecastResponse>
            ) {
                if (response.code() == 200) {
                    mBinding.forecastRecyclerView.adapter =
                        ForecastAdapter(this@MainFragment, response.body()!!.list)
                    mBinding.forecastRecyclerView.layoutManager = LinearLayoutManager(context)
                    mBinding.forecastRecyclerView.setHasFixedSize(true)
                    mBinding.forecastRecyclerView.isNestedScrollingEnabled = false
                    mBinding.forecastRecyclerView.visibility = View.VISIBLE
                    mBinding.progressBar.visibility = View.GONE
                    weatherDao.insertAll(response.body()!!.list)
                }
            }

            override fun onFailure(
                call: Call<ForecastResponse>,
                t: Throwable
            ) {
                mBinding.progressBar.visibility = View.GONE
                Toast.makeText(
                    activity,
                    "Something went wong, Please try again later!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })



        mBinding.headerLayout.setOnClickListener{

        }


    }

    override fun onItemClick(selectedDay: DayWeather) {
        val bundle = Bundle()
        bundle.putParcelable("dayWeatherArg", selectedDay)
        findNavController().navigate(R.id.action_MainFragment_to_DetailsFragment, bundle)
    }
}