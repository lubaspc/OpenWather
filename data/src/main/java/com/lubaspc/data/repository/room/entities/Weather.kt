package com.lubaspc.data.repository.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "weather")
data class Weather(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var createdAt: Date,
    var modelString: String
)