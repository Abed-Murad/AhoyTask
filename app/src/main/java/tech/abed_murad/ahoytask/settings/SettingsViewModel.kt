package tech.abed_murad.ahoytask.settings

import androidx.lifecycle.ViewModel
import tech.abed_murad.repository.WeatherRepositoryImpl

class SettingsViewModel(var weatherRepository: WeatherRepositoryImpl) : ViewModel() {

    fun updateTemperatureUnit(newUnit: String) {
        weatherRepository.updateTemperatureUnit(newUnit)
    }

    fun getTemperatureUnit(): String {
        return weatherRepository.getTemperatureUnit()
    }

}