package com.lubaspc.data.repository

import com.lubaspc.data.repository.datasource.WeatherApiSource
import com.lubaspc.data.repository.datasource.WeatherDBSource
import com.lubaspc.data.repository.datasource.toTestDomain
import com.lubaspc.domain.model.Test
import com.lubaspc.domain.usecase.TestUseCase
import javax.inject.Inject


class TestRepository(
    @Inject private val weatherDBSource: WeatherDBSource,
    @Inject private val weatherApiSource: WeatherApiSource
): TestUseCase.TestSource {

    override fun getTestList(): List<Test> {
        return weatherDBSource.getTestList()
    }

    override fun getTest(): Test? {
        val test = weatherApiSource.getNewTest() ?: return null
        weatherDBSource.insertTest(test.toString())
        return test.toTestDomain()
    }

    override fun getTestLast(): Test? =
        weatherDBSource.getLastWeather()

}