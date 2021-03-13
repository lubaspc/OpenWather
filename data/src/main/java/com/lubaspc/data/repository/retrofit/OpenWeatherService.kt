package com.lubaspc.data.repository.retrofit

import com.google.gson.JsonElement
import com.lubaspc.data.repository.retrofit.models.Test
import retrofit2.Call
import retrofit2.http.GET

interface OpenWeatherService {
    @GET("weather?q=London%2Cuk&lat=0&lon=0&callback=test&id=2172797&lang=null&units=%22metric%22%20or%20%22imperial%22&mode=xml%2C%20html")
    fun getWeather(): Call<String>
}