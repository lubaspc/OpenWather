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
) : TestUseCase.TestSource {

    override fun getTestList(): List<Test> =
        weatherDBSource.getTestList()


    override fun getTest(): Test? =
        weatherApiSource.getNewTest().apply {
            weatherDBSource.insertTest(this.toString())
        }?.toTestDomain()

    override fun getTestLast(): Test? =
        weatherDBSource.getLastWeather()

}