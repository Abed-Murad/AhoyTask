package tech.abed_murad.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.abed_murad.local.GlobalUserInfo
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.TodayResponse
import tech.abed_murad.local.room.WeatherDatabase
import tech.abed_murad.remote.WeatherService


class WeatherRepositoryImpl(
    private val remote: WeatherService,
    private val local: WeatherDatabase
) : WeatherRepository {

    override fun getWeatherData(): LiveData<List<ForecastResponse.DayWeather>> {
        return local.dayWeatherDao().getAll()
    }

    override fun fetchDataFromRemote(
        lat: String,
        lon: String
    ): LiveData<ArrayList<ForecastResponse.DayWeather>> {

        val forecastCall = remote.getWeatherForecast(
            lat, lon,
            GlobalUserInfo.forecast_days_count,
            GlobalUserInfo.temperatureUnit,
            GlobalUserInfo.api_key
        )


        var forecastList: MutableLiveData<ArrayList<ForecastResponse.DayWeather>> =
            MutableLiveData()
        forecastCall.enqueue(object : Callback<ForecastResponse> {

            override fun onResponse(
                call: Call<ForecastResponse>,
                response: Response<ForecastResponse>
            ) {
                if (response.code() == 200) {
                    forecastList.value = response.body()!!.list
                    updateLocalDatabase(response.body()!!.list)
                }
            }

            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                Log.d("ttt", t.message)
            }
        })

        return forecastList


    }

    override fun updateLocalDatabase(list: ArrayList<ForecastResponse.DayWeather>) {
        local.dayWeatherDao().deleteAll()
        local.dayWeatherDao().insertAll(list)
    }

    override fun getTodayWeather(): LiveData<TodayResponse> {

        val todayCall = remote.getWeatherToday(
            GlobalUserInfo.lat,
            GlobalUserInfo.lon,
            GlobalUserInfo.temperatureUnit,
            GlobalUserInfo.api_key
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
                Log.d("ttt", t.message)
            }
        })
        return dayWeatherResponse
    }

    override fun fetchDataFromRemote() {
        fetchDataFromRemote(GlobalUserInfo.lat, GlobalUserInfo.lon)
    }

    override fun updateTemperatureUnit(newUnit: String) {
        GlobalUserInfo.temperatureUnit = newUnit
    }

    override fun getTemperatureUnit(): String {
        return GlobalUserInfo.temperatureUnit
    }

}