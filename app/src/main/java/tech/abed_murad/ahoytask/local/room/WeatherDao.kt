package tech.abed_murad.ahoytask.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import tech.abed_murad.ahoytask.local.model.ForecastResponse.DayWeather

@Dao
interface DayWeatherDao {
    @Query("SELECT * FROM DayWeather WHERE dt = :datetime")
    fun getById(datetime: Int): DayWeather?

    @Query("SELECT * FROM DayWeather")
     fun getAll(): LiveData<List<DayWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dayWeather: DayWeather): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dayWeather: List<DayWeather>): List<Long?>?

    @Update
    fun update(dayWeather: DayWeather?)

    @Delete
    fun delete(dayWeather: DayWeather?)

    @Query("DELETE FROM dayweather")
    fun deleteAll()
}