package tech.abed_murad.ahoytask

import android.app.Application
import androidx.room.Room
import com.chibatching.kotpref.Kotpref
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.abed_murad.local.WeatherDatabase
import tech.abed_murad.local.model.CONST.URL_OPEN_WEATHER
import tech.abed_murad.remote.WeatherService


class MyApplication : Application() {
    val local: WeatherDatabase by lazy {
        Room.databaseBuilder(this, WeatherDatabase::class.java, WeatherDatabase.NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    val remote: WeatherService by lazy {
        Retrofit.Builder()
            .baseUrl(URL_OPEN_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WeatherService::class.java)
    }


    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
    }

}