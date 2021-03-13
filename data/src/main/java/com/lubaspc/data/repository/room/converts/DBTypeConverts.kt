package com.lubaspc.data.repository.room.converts

import androidx.room.TypeConverter
import java.util.*

class DBTypeConverts {
    @TypeConverter
    fun fromTimestamp(value: Long): Date? {
        return Date(value)
    }

    @TypeConverter
    fun fromDate(date: Date): Long? {
        return date.time
    }
}