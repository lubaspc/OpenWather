package com.lubaspc.data.repository.datasource

import com.lubaspc.data.repository.retrofit.APIOpenWeather
import com.lubaspc.data.repository.room.entities.Weather
import com.lubaspc.domain.model.Test
import java.util.*
import javax.inject.Inject

class WeatherApiSource(@Inject private val api: APIOpenWeather) {

    fun getNewTest() = api.getWeather()
}