package com.lubaspc.testopenweather

import android.app.Application
import com.lubaspc.testopenweather.di.compenents.DaggerMainComponent
import com.lubaspc.testopenweather.di.compenents.MainComponent
import com.lubaspc.testopenweather.di.modules.MainModule
import com.lubaspc.testopenweather.ui.view.activity.MainActivity

class App : Application() {

    private lateinit var mainComponent: MainComponent
    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainComponent
            .builder()
            .mainModule(MainModule(this))
            .build()
    }

    fun getMainComponent() = mainComponent
}