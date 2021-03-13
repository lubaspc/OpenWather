package com.lubaspc.data.repository.retrofit

import android.util.Log
import com.google.gson.GsonBuilder
import com.lubaspc.data.repository.retrofit.models.Test
import com.lubaspc.data.repository.retrofit.models.Weather
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object APIOpenWeather {
    private const val BASE_URL = "https://community-open-weather-map.p.rapidapi.com/"
    private const val TAG = "API_OPEN_WEATHER"
    private val apiService: OpenWeatherService

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClietBuilder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("x-rapidapi-key", "d3fe3a34c5mshf70e1bb90c464a8p1ba4aajsn4233972e8a9c")
                    .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                    .build()
                chain.proceed(newRequest)
            }

        // Prepare Gson instance

        // Prepare Gson instance
        val gson = GsonBuilder().create()

        //Prepare retrofit instance

        //Prepare retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClietBuilder.build())
            .build()

        apiService = retrofit.create(OpenWeatherService::class.java)
    }


    fun getWeather(): Test? = apiService.getWeather().execute().body()
}