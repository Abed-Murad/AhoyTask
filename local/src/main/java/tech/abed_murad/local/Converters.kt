package tech.abed_murad.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.ForecastResponse.DayWeather
import tech.abed_murad.local.model.ForecastResponse.DayWeather.Temp
import tech.abed_murad.local.model.ForecastResponse.City
import tech.abed_murad.local.model.Weather
import java.lang.reflect.Type
import java.util.*

object Converters {
    var gson: Gson = Gson()

    @TypeConverter
    fun stringToWeatherList(data: String?): List<Weather> {
        if (data == null) {
            return emptyList()
        }
        val listType: Type = object : TypeToken<List<Weather?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun weatherListToString(someObjects: List<Weather?>?): String {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun stringTodDayWeather(data: String?): List<DayWeather> {
        if (data == null) {
            return emptyList()
        }
        val listType: Type = object : TypeToken<List<DayWeather?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun dayWeatherToString(someObjects: List<DayWeather?>?): String {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun stringToCity(data: String?): ForecastResponse.City? {
        return if (data == null) {
            null
        } else gson.fromJson(data, City::class.java)
    }

    @TypeConverter
    fun CityToString(someObjects: City?): String {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun stringToTemp(data: String?): Temp? {
        return if (data == null) {
            null
        } else gson.fromJson(data, Temp::class.java)
    }

    @TypeConverter
    fun tempToString(someObjects: Temp?): String {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun longToDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToLong(value: Date?): Long? {
        return value?.time
    }
}