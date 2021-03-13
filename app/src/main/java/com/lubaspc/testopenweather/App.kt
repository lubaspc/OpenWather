package com.lubaspc.testopenweather

import android.app.Application
import com.lubaspc.testopenweather.di.compenents.DaggerMainComponent
import com.lubaspc.testopenweather.di.compenents.MainComponent

class App : Application() {

    private lateinit var mainComponent: MainComponent
    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainComponent.create()
    }

    fun getMainComponent() = mainComponent
}