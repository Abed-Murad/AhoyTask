package tech.abed_murad.ahoytask.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.TodayResponse
import tech.abed_murad.repository.WeatherRepositoryImpl

class MainFragmentViewModel(var weatherRepository: WeatherRepositoryImpl) : ViewModel() {

    fun getForecastWeather():
            LiveData<List<ForecastResponse.DayWeather>> {
        return weatherRepository.getWeatherData()
    }


    fun getTodayWeather(): LiveData<TodayResponse> {
        return weatherRepository.getTodayWeather().asLiveData()
    }

    fun updateLocalDatabase() {
        weatherRepository.fetchDataFromRemote()
    }


}