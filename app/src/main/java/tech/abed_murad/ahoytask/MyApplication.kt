package tech.abed_murad.ahoytask

import android.app.Application
import tech.abed_murad.ahoytask.local.room.WeatherDatabase
import androidx.room.Room
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.abed_murad.ahoytask.network.WeatherService


class MyApplication : Application() {
    lateinit var db: WeatherDatabase


    override fun onCreate() {
        super.onCreate()


    }


    fun weatherDatabase(): WeatherDatabase {
        val database = Room.databaseBuilder(this, WeatherDatabase::class.java, WeatherDatabase.NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
        return database
    }


    fun getWeatherService(): WeatherService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(WeatherService::class.java)
    }


}