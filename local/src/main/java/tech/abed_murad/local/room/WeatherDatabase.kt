package tech.abed_murad.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tech.abed_murad.local.model.ForecastResponse.DayWeather

@Database(entities = [DayWeather::class], version = 1)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun dayWeatherDao(): DayWeatherDao

    companion object {
        const val DB_NAME = "weather_database"
    }
}
