package tech.abed_murad.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import tech.abed_murad.local.model.ForecastResponse

@Dao
interface DayWeatherDao {
    @Query("SELECT * FROM DayWeather WHERE dt = :datetime")
    fun getById(datetime: Int): ForecastResponse.DayWeather?

    @Query("SELECT * FROM DayWeather")
     fun getAll(): LiveData<List<ForecastResponse.DayWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dayWeather: ForecastResponse.DayWeather): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dayWeather: List<ForecastResponse.DayWeather>): List<Long?>?

    @Update
    fun update(dayWeather: ForecastResponse.DayWeather?)

    @Delete
    fun delete(dayWeather: ForecastResponse.DayWeather?)

    @Query("DELETE FROM DayWeather")
    fun deleteAll()
}