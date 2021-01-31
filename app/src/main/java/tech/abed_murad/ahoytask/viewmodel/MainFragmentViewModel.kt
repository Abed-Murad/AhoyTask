package tech.abed_murad.ahoytask.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import tech.abed_murad.ahoytask.local.model.ForecastResponse
import tech.abed_murad.ahoytask.local.model.TodayResponse
import tech.abed_murad.ahoytask.repository.WeatherRepository

 class MainFragmentViewModel(var weatherRepository: WeatherRepository) : ViewModel() {

    fun getForecastWeather(lat: String, lon: String):
            LiveData<ArrayList<ForecastResponse.DayWeather>> {
        return weatherRepository.getForecastWeather(lat, lon)
    }


    fun getTodayWeather(lat: String, lon: String): LiveData<TodayResponse> {
     return   weatherRepository.getTodayWeather(lat, lon)
    }


}