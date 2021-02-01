package tech.abed_murad.ahoytask.local.model


import com.google.gson.annotations.SerializedName

data class TodayResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("cod")
    val cod: Float,
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("dt")
    val dt: Float,
    @SerializedName("id")
    val id: Float,
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String,
    @SerializedName("timezone")
    val timezone: Float,
    @SerializedName("visibility")
    val visibility: Float,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
) {
    data class Clouds(
        @SerializedName("all")
        val all: Float
    )

    data class Main(
        @SerializedName("feels_like")
        val feelsLike: Double,
        @SerializedName("humidity")
        val humidity: Float,
        @SerializedName("pressure")
        val pressure: Float,
        @SerializedName("temp")
        val temp: Double,
        @SerializedName("temp_max")
        val tempMax: Double,
        @SerializedName("temp_min")
        val tempMin: Float
    )

    data class Wind(
        @SerializedName("deg")
        val deg: Float,
        @SerializedName("speed")
        val speed: Double
    )
}