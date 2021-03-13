package com.lubaspc.data.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lubaspc.data.repository.room.converts.DBTypeConverts
import com.lubaspc.data.repository.room.dao.WeatherDao
import com.lubaspc.data.repository.room.entities.Weather

@Database(
    entities = [Weather::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DBTypeConverts::class)
abstract class DBRoom : RoomDatabase() {
    abstract fun noteDao(): WeatherDao
}

