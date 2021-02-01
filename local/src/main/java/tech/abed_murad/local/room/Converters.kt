package tech.abed_murad.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.Weather
import java.lang.reflect.Type

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
    fun stringToFeelsLike(data: String?): ForecastResponse.DayWeather.FeelsLike? {
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

}