package tech.abed_murad.ahoytask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tech.abed_murad.ahoytask.repository.WeatherRepository

@Suppress("UNCHECKED_CAST")
class MainFragmentModelFactory constructor(private val weatherRepository: WeatherRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainFragmentViewModel::class.java)) MainFragmentViewModel(
            this.weatherRepository
        ) as T
        else throw IllegalArgumentException("ViewModel Not Found")
    }
}
