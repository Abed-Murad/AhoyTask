package tech.abed_murad.ahoytask.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.abed_murad.ahoytask.local.model.ForecastResponse
import tech.abed_murad.ahoytask.local.model.ForecastResponse.DayWeather
import tech.abed_murad.ahoytask.local.model.TodayResponse
import tech.abed_murad.ahoytask.local.room.WeatherDatabase
import tech.abed_murad.ahoytask.network.WeatherService

class WeatherRepository(
    private val remote: WeatherService,
    private val local: WeatherDatabase
) {


    fun insertWeatherData() {
        val weatherDao = local.dayWeatherDao()

    }


    fun getWeatherData() {

    }

    fun getForecastWeather(lat: String, lon: String): LiveData<ArrayList<DayWeather>> {

        val forecastCall = remote.getWeatherForecast(
            "31.388520",
            "34.702372",
            "10",
            "metric",
            "c9da7f4769c845195c654aa2c0d3f16b"
        )


        var forecastList: MutableLiveData<ArrayList<DayWeather>> = MutableLiveData()
        forecastCall.enqueue(object : Callback<ForecastResponse> {

            override fun onResponse(
                call: Call<ForecastResponse>,
                response: Response<ForecastResponse>
            ) {
                if (response.code() == 200) {
                    forecastList.value = response.body()!!.list
                }
            }

            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {

            }
        })

        return forecastList


    }


    fun getTemperatureUnit(): String {
        TODO()
    }


    fun getTodayWeather(lat: String, lon: String): LiveData<TodayResponse> {

        val todayCall = remote.getWeatherToday(
            "31.388520",
            "34.702372",
            "metric",
            "c9da7f4769c845195c654aa2c0d3f16b"
        )

        var dayWeatherResponse: MutableLiveData<TodayResponse> = MutableLiveData()
        todayCall.enqueue(object : Callback<TodayResponse> {
            override fun onResponse(
                call: Call<TodayResponse>,
                response: Response<TodayResponse>
            ) {
                if (response.code() == 200) {
                    dayWeatherResponse.value = response.body()!!
                    return
                }
            }

            override fun onFailure(
                call: Call<TodayResponse>,
                t: Throwable
            ) {
                dayWeatherResponse = MutableLiveData()

            }
        })

        return dayWeatherResponse
    }


}