package tech.abed_murad.local.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ForecastResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Float,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: ArrayList<DayWeather>,
    @SerializedName("message")
    val message: Double
) {
    data class City(
        @SerializedName("coord")
        val coord: Coord,
        @SerializedName("country")
        val country: String,
        @SerializedName("id")
        val id: Float,
        @SerializedName("name")
        val name: String,
        @SerializedName("population")
        val population: Float,
        @SerializedName("timezone")
        val timezone: Float
    ) {
        data class Coord(
            @SerializedName("lat")
            val lat: Double,
            @SerializedName("lon")
            val lon: Double
        )
    }

    @Parcelize
    data class DayWeather(
        @SerializedName("clouds")
        val clouds: Float,
        @SerializedName("deg")
        val deg: Float,
        @SerializedName("dt")
        val dt: Float,
        @SerializedName("feels_like")
        val feelsLike: FeelsLike,
        @SerializedName("humidity")
        val humidity: Float,
        @SerializedName("pop")
        val pop: Float,
        @SerializedName("pressure")
        val pressure: Float,
        @SerializedName("rain")
        val rain: Double,
        @SerializedName("speed")
        val speed: Double,
        @SerializedName("sunrise")
        val sunrise: Float,
        @SerializedName("sunset")
        val sunset: Float,
        @SerializedName("temp")
        val temp: Temp,
        @SerializedName("weather")
        val weather: List<Weather>
    ) : Parcelable {
        @Parcelize
        data class FeelsLike(
            @SerializedName("day")
            val day: Double,
            @SerializedName("eve")
            val eve: Double,
            @SerializedName("morn")
            val morn: Double,
            @SerializedName("night")
            val night: Double
        ):Parcelable
        @Parcelize
        data class Temp(
            @SerializedName("day")
            val day: Double,
            @SerializedName("eve")
            val eve: Double,
            @SerializedName("max")
            val max: Double,
            @SerializedName("min")
            val min: Double,
            @SerializedName("morn")
            val morn: Double,
            @SerializedName("night")
            val night: Double
        ):Parcelable
        @Parcelize
        data class Weather(
            @SerializedName("description")
            val description: String,
            @SerializedName("icon")
            val icon: String,
            @SerializedName("id")
            val id: Float,
            @SerializedName("main")
            val main: String
        ):Parcelable
    }
}