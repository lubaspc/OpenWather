package com.lubaspc.testopenweather.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lubaspc.domain.model.Test
import com.lubaspc.domain.usecase.TestUseCase
import com.lubaspc.testopenweather.App
import com.lubaspc.testopenweather.R
import com.lubaspc.testopenweather.databinding.ActivityMainBinding
import com.lubaspc.testopenweather.ui.presenter.MainActivityPresenter
import com.lubaspc.testopenweather.ui.view.dialog.WeatherDialog
import com.lubaspc.testopenweather.ui.view.fragment.ListFragment
import com.lubaspc.testopenweather.ui.view.fragment.MapsFragment
import com.lubaspc.testopenweather.utils.FragmentEnum
import com.lubaspc.testopenweather.utils.addFragment
import com.lubaspc.testopenweather.utils.replaceFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ListFragment.ListFragmentHandle
    , MapsFragment.MapFragmentHandle {


    @Inject
    lateinit var testUseCase: TestUseCase

    private lateinit var presenter: MainActivityPresenter

    private lateinit var vBind: ActivityMainBinding

    private lateinit var mapFragment: MapsFragment
    private lateinit var listFragment: ListFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vBind.showProgress = true
        (application as App).getMainComponent().inject(this)

        mapFragment = MapsFragment(testUseCase)
        listFragment = ListFragment(testUseCase)
        presenter = MainActivityPresenter(testUseCase)

        vBind.fragment = FragmentEnum.MAPS
        vBind.flContainer.addFragment(
            supportFragmentManager.beginTransaction(),
            mapFragment,
            FragmentEnum.MAPS.name)
        setupButtons()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(Bundle())
    }

    private fun setupButtons() {
        vBind.fbMap.setOnClickListener {
            vBind.fragment = FragmentEnum.MAPS
            changeFragment(mapFragment,FragmentEnum.MAPS.name)
        }
        vBind.fbList.setOnClickListener {
            vBind.fragment = FragmentEnum.LIST
            changeFragment(listFragment,FragmentEnum.LIST.name)
        }
    }

    private fun changeFragment(fragment: Fragment,tag:String){
        vBind.showProgress = true
        vBind.flContainer.replaceFragment(
            supportFragmentManager.beginTransaction(),
            fragment,
            tag
        )
    }

    override fun clickItem(test: Test) =
        WeatherDialog(test).show(supportFragmentManager, "DIALOG_ITEM")


    override fun refreshPosition(cb: () -> Unit) {
        vBind.fbReload.setOnClickListener {
            vBind.showProgress = true
            presenter.getTest {
                cb()
                vBind.showProgress = false
            }
        }
    }

    override fun hideProgress() {
        vBind.showProgress = false
    }




}