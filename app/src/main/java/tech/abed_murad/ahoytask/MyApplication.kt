package tech.abed_murad.ahoytask

import androidx.multidex.MultiDexApplication
import androidx.room.Room
import com.chibatching.kotpref.Kotpref
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.abed_murad.local.room.WeatherDatabase
import tech.abed_murad.local.CONST.URL_OPEN_WEATHER
import tech.abed_murad.remote.WeatherService


class MyApplication : MultiDexApplication() {
    val local: WeatherDatabase by lazy {
        Room.databaseBuilder(this, WeatherDatabase::class.java, WeatherDatabase.DB_NAME)
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