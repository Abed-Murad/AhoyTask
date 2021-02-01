package tech.abed_murad.ahoytask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import tech.abed_murad.ahoytask.local.model.ForecastResponse
import tech.abed_murad.ahoytask.local.model.TodayResponse
import tech.abed_murad.ahoytask.repository.WeatherRepository

class MainFragmentViewModel(var weatherRepository: WeatherRepository) : ViewModel() {

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