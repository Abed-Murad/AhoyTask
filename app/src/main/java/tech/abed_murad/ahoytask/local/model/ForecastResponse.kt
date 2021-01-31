package tech.abed_murad.ahoytask.local.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
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
    )

    @Parcelize
    @Entity
    data class DayWeather(
        @SerializedName("clouds")
        val clouds: Float,
        @SerializedName("deg")
        val deg: Float,
        @PrimaryKey()
        @SerializedName("dt")
        val dt: Long,
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
        val sunrise: Long,
        @SerializedName("sunset")
        val sunset: Long,
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
    }


}