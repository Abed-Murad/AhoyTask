package tech.abed_murad.ahoytask

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import tech.abed_murad.repository.WeatherRepository
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.TodayResponse

class MainFragmentViewModel(var weatherRepository: tech.abed_murad.repository.WeatherRepository) : ViewModel() {

    fun getForecastWeather():
            LiveData<List<ForecastResponse.DayWeather>> {
        return weatherRepository.getWeatherData()
    }


    fun getTodayWeather(): LiveData<TodayResponse> {
        return weatherRepository.getTodayWeather()
    }

    fun updateLocalDatabase() {
        weatherRepository.fetchDataFromRemote()
    }


}