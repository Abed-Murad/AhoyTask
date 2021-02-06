package tech.abed_murad.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.TodayResponse

interface WeatherRepository {
    fun getWeatherData(): LiveData<List<ForecastResponse.DayWeather>>
    fun fetchDataFromRemote(lat: String, lon: String): Flow<ForecastResponse>
    fun updateLocalDatabase(list: ArrayList<ForecastResponse.DayWeather>)
    fun getTodayWeather(): Flow<TodayResponse>
    fun fetchDataFromRemote()
    fun updateTemperatureUnit(newUnit: String)
    fun getTemperatureUnit(): String
}