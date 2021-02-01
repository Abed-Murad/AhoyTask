package tech.abed_murad.ahoytask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class MainFragmentModelFactory constructor(private val weatherRepository: tech.abed_murad.repository.WeatherRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainFragmentViewModel::class.java)) MainFragmentViewModel(
            this.weatherRepository
        ) as T
        else throw IllegalArgumentException("ViewModel Not Found")
    }
}
