package tech.abed_murad.ahoytask.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tech.abed_murad.ahoytask.model.ForecastResponse

interface WeatherService {
    @GET("forecast/daily")
    fun getCurrentWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("cnt") count: String,
        @Query("appid") appid: String
    ): Call<ForecastResponse>

}