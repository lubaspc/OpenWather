package com.lubaspc.testopenweather.di.modules

import android.content.Context
import androidx.room.Room
import com.lubaspc.data.repository.TestRepository
import com.lubaspc.data.repository.datasource.WeatherApiSource
import com.lubaspc.data.repository.datasource.WeatherDBSource
import com.lubaspc.data.repository.retrofit.APIOpenWeather
import com.lubaspc.data.repository.room.DBRoom
import com.lubaspc.domain.usecase.TestUseCase
import com.lubaspc.testopenweather.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MainModule(private val app: App) {
    private var db :DBRoom =
        Room.databaseBuilder(app, DBRoom::class.java, "weather-db")
            .build()

    @Provides
    @Singleton
    fun provideApplicationContext(): Context? = app
//
//    @Provides
//    @Singleton
//    fun provideGson(): Gson? {
//        return Gson()
//    }

    @Provides
    @Singleton
    fun provideTestUseCase(testRepository: TestRepository) = TestUseCase(testRepository)


    @Provides
    @Singleton
    fun provideWeatherDBSource() = WeatherDBSource(db.noteDao())


    @Provides
    @Singleton
    fun provideWeatherApiSource() = WeatherApiSource(APIOpenWeather)


    @Provides
    @Singleton
    fun provideTestRepository(
        weatherApiSource: WeatherApiSource,
        weatherDBSource: WeatherDBSource
    ) = TestRepository(weatherDBSource, weatherApiSource)


}