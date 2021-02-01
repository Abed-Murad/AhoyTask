package tech.abed_murad.ahoytask.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import tech.abed_murad.ahoytask.local.model.*
import java.lang.reflect.Type
import java.util.*

 class Converters {
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
    fun stringTodDayWeather(data: String?): List<ForecastResponse.DayWeather> {
        if (data == null) {
            return emptyList()
        }
        val listType: Type = object : TypeToken<List<ForecastResponse.DayWeather?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun dayWeatherToString(someObjects: List<ForecastResponse.DayWeather?>?): String {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun stringToCity(data: String?): ForecastResponse.City? {
        return if (data == null) {
            null
        } else gson.fromJson(data, ForecastResponse.City::class.java)
    }

    @TypeConverter
    fun CityToString(someObjects: ForecastResponse.City?): String {
        return gson.toJson(someObjects)
    }

     @TypeConverter
    fun stringtoFeelsLike(data: String?): ForecastResponse.DayWeather.FeelsLike? {
        return if (data == null) {
            null
        } else gson.fromJson(data, ForecastResponse.DayWeather.FeelsLike::class.java)
    }

    @TypeConverter
    fun feelsLikeToString(someObjects: ForecastResponse.DayWeather.FeelsLike?): String {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun stringToTemp(data: String?): ForecastResponse.DayWeather.Temp? {
        return if (data == null) {
            null
        } else gson.fromJson(data, ForecastResponse.DayWeather.Temp::class.java)
    }

    @TypeConverter
    fun tempToString(someObjects: ForecastResponse.DayWeather.Temp?): String {
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