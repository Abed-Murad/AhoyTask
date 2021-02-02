package tech.abed_murad.repository

import androidx.lifecycle.LiveData
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.TodayResponse

interface WeatherRepository {
    fun getWeatherData(): LiveData<List<ForecastResponse.DayWeather>>
    fun fetchDataFromRemote(lat: String, lon: String): LiveData<ArrayList<ForecastResponse.DayWeather>>
    fun updateLocalDatabase(list: ArrayList<ForecastResponse.DayWeather>)
    fun getTodayWeather(): LiveData<TodayResponse>
    fun fetchDataFromRemote()
    fun updateTemperatureUnit(newUnit: String)
    fun getTemperatureUnit(): String
}