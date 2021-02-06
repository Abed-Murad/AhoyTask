package tech.abed_murad.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tech.abed_murad.local.GlobalUserInfo
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.TodayResponse
import tech.abed_murad.local.room.WeatherDatabase
import tech.abed_murad.remote.WeatherService


class WeatherRepositoryImpl(
    private val remote: WeatherService,
    private val local: WeatherDatabase
) : WeatherRepository {

    lateinit var myFlow: Flow<ForecastResponse>

    override fun getWeatherData(): LiveData<List<ForecastResponse.DayWeather>> {
        return local.dayWeatherDao().getAll()
    }

    override fun fetchDataFromRemote(
        lat: String,
        lon: String
    ): Flow<ForecastResponse> {

        return flow {
            val forecastResponse = remote.getWeatherForecast(
                lat, lon,
                GlobalUserInfo.forecast_days_count,
                GlobalUserInfo.temperatureUnit,
                GlobalUserInfo.api_key
            )
//            updateLocalDatabase(forecastResponse.list)
            emit(forecastResponse)
        }
    }

    override fun updateLocalDatabase(list: ArrayList<ForecastResponse.DayWeather>) {
        local.dayWeatherDao().deleteAll()
        local.dayWeatherDao().insertAll(list)
    }

    override fun getTodayWeather(): Flow<TodayResponse> {
        return flow {
            val todayResponse = remote.getWeatherToday(
                GlobalUserInfo.lat, GlobalUserInfo.lon,
                GlobalUserInfo.temperatureUnit, GlobalUserInfo.api_key
            )
            emit(todayResponse)
        }

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