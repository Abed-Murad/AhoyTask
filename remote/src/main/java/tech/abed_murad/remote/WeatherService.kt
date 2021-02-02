package tech.abed_murad.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tech.abed_murad.local.model.ForecastResponse
import tech.abed_murad.local.model.TodayResponse


interface WeatherService {
    @GET("forecast/daily")
    fun getWeatherForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("cnt") count: String,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Call<ForecastResponse>


    @GET("weather")
    fun getWeatherToday(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Call<TodayResponse>
}


