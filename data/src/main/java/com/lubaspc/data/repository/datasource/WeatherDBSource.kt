package com.lubaspc.data.repository.datasource

import com.lubaspc.data.repository.room.dao.WeatherDao
import com.lubaspc.data.repository.room.entities.Weather
import com.lubaspc.domain.model.Test
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*
import javax.inject.Inject

class WeatherDBSource(@Inject private val weatherDao: WeatherDao) {
    fun getTestList(): List<Test> {
        return weatherDao.getAll().map {
            it.toTest()
        }

    }

    fun insertTest(data: String) = weatherDao.insert(Weather(0, Date(), data))

}