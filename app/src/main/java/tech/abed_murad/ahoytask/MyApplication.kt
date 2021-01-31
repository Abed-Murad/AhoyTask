package tech.abed_murad.ahoytask

import android.app.Application
import tech.abed_murad.ahoytask.local.room.WeatherDatabase
import androidx.room.Room


class MyApplication : Application() {
    lateinit var instance: WeatherDatabase
    override fun onCreate() {
        super.onCreate()
        instance = Room.databaseBuilder(this, WeatherDatabase::class.java, WeatherDatabase.NAME)
//            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


}