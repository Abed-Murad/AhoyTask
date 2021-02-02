package tech.abed_murad.ahoytask.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tech.abed_murad.ahoytask.main.MainFragmentViewModel
import tech.abed_murad.ahoytask.settings.SettingsViewModel
import tech.abed_murad.local.room.WeatherDatabase

val appModule = module {
    viewModel { MainFragmentViewModel(get()) }
    viewModel { SettingsViewModel(get()) }
}

val databaseModule = module {
    factory { WeatherDatabase.getInstance(get()) }
}
