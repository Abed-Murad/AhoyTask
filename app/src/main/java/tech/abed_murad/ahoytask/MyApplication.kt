package tech.abed_murad.ahoytask

import androidx.multidex.MultiDexApplication
import com.chibatching.kotpref.Kotpref
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.abed_murad.ahoytask.di.appModule
import tech.abed_murad.ahoytask.di.databaseModule
import tech.abed_murad.local.CONST.URL_OPEN_WEATHER
import tech.abed_murad.remote.WeatherService
import tech.abed_murad.repository.WeatherRepositoryImpl

class MyApplication : MultiDexApplication() {

    private val remote: WeatherService by lazy {
        Retrofit.Builder()
            .baseUrl(URL_OPEN_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WeatherService::class.java)
    }

    // DI Modules.
    private val repositoryModule = module {
        single { WeatherRepositoryImpl(remote, get()) }
    }

    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
        initKoin() // DI
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    appModule,
                    databaseModule,
                    repositoryModule
                )
            )
        }
    }

}