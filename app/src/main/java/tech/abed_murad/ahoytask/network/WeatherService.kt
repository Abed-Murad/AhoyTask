package tech.abed_murad.ahoytask.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tech.abed_murad.ahoytask.local.model.ForecastResponse

interface WeatherService {
    @GET("forecast/daily")
    fun getCurrentWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("cnt") count: String,
        @Query("appid") appid: String
    ): Call<ForecastResponse>




    companion object {
        var BaseUrl = "http://api.openweathermap.org/"
        var AppId = "2e65127e909e178d0af311a81f39948c"
        var lat = "35"
        var lon = "139"
    }
}


