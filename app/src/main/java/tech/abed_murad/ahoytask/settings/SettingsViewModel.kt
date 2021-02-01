package tech.abed_murad.ahoytask.settings

import androidx.lifecycle.ViewModel
import tech.abed_murad.repository.WeatherRepository

class SettingsViewModel(var weatherRepository: WeatherRepository) : ViewModel() {

    fun updateTemperatureUnit(newUnit: String) {
        weatherRepository.updateTemperatureUnit(newUnit)
    }

    fun getTemperatureUnit(): String {
        return weatherRepository.getTemperatureUnit()
    }

}