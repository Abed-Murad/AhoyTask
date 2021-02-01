package tech.abed_murad.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tech.abed_murad.local.model.ForecastResponse.DayWeather

@Database(entities = [DayWeather::class], version = 1)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun dayWeatherDao(): DayWeatherDao

    companion object {
        const val NAME = "weather_database"
        private var instance: WeatherDatabase? = null
        fun getInstance(application: Application?): WeatherDatabase? {
            if (instance != null) {
                instance =
                    Room.databaseBuilder(application!!, WeatherDatabase::class.java, NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            return instance
        }
    }
}
