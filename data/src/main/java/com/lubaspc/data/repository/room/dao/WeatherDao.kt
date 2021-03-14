package com.lubaspc.data.repository.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lubaspc.data.repository.room.entities.Weather
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Query("select * from weather")
    fun getAll(): List<Weather>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weather: Weather)

    @Query("SELECT * FROM weather ORDER BY id DESC LIMIT 1")
    fun getLast(): Weather?
}