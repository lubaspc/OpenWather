package com.lubaspc.data.repository

import com.lubaspc.data.repository.datasource.WeatherApiSource
import com.lubaspc.data.repository.datasource.WeatherDBSource
import com.lubaspc.data.repository.datasource.toTest
import com.lubaspc.data.repository.datasource.toTestDomain
import com.lubaspc.data.repository.retrofit.APIOpenWeather
import com.lubaspc.data.repository.room.dao.WeatherDao
import com.lubaspc.data.repository.room.entities.Weather
import com.lubaspc.domain.model.Test
import com.lubaspc.domain.usecase.GetTest
import com.lubaspc.domain.usecase.GetTests
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class TestRepository(
    @Inject private val weatherDBSource: WeatherDBSource,
    @Inject private val weatherApiSource: WeatherApiSource
): GetTest.GetTestSource,GetTests.GetTestsSource {

    override fun getTestList(): List<Test> {
        return weatherDBSource.getTestList()
    }

    override fun getTest(): Test? {
        var test = weatherApiSource.getNewTest()
        weatherDBSource.insertTest(test.toString())
        return test?.toTestDomain()
    }
}