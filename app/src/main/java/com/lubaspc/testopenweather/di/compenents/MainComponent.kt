package com.lubaspc.testopenweather.di.compenents

import com.lubaspc.testopenweather.di.modules.MainModule
import com.lubaspc.testopenweather.ui.presenter.ListFragmentPresenter
import com.lubaspc.testopenweather.ui.presenter.MapFragmentPresenter
import com.lubaspc.testopenweather.ui.view.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}