package com.lubaspc.testopenweather.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lubaspc.domain.model.Test
import com.lubaspc.domain.usecase.TestUseCase
import com.lubaspc.testopenweather.App
import com.lubaspc.testopenweather.R
import com.lubaspc.testopenweather.databinding.ActivityMainBinding
import com.lubaspc.testopenweather.ui.presenter.MainActivityPresenter
import com.lubaspc.testopenweather.ui.view.dialog.WeatherDialog
import com.lubaspc.testopenweather.ui.view.fragment.ListFragment
import com.lubaspc.testopenweather.ui.view.fragment.MapsFragment
import com.lubaspc.testopenweather.utils.addFragment
import com.lubaspc.testopenweather.utils.replaceFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ListFragment.ListFragmentHandle
    , MapsFragment.MapFragmentHandle {

    private val TAG_MAP = "TAG_MAP"
    private val TAG_LIST = "TAG_LIST"

    private lateinit var vBind: ActivityMainBinding
    @Inject
    lateinit var testUseCase: TestUseCase

    private lateinit var mapFragment: MapsFragment
    private lateinit var listFragment: ListFragment

    private lateinit var presenter: MainActivityPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vBind.showProgress = true
        (application as App).getMainComponent().inject(this)

        mapFragment = MapsFragment(testUseCase)
        listFragment = ListFragment(testUseCase)
        presenter = MainActivityPresenter(testUseCase)

        vBind.flContainer.addFragment(
            supportFragmentManager.beginTransaction(),
            mapFragment,
            TAG_MAP)
        setupButtons()
    }

    private fun setupButtons() {
        vBind.fbMap.setOnClickListener {
            vBind.showProgress = true
            vBind.flContainer.replaceFragment(
                supportFragmentManager.beginTransaction(),
                mapFragment,
                TAG_MAP
            )
        }
        vBind.fbList.setOnClickListener {
            vBind.showProgress = true
            vBind.flContainer.replaceFragment(
                supportFragmentManager.beginTransaction(),
                listFragment,
                TAG_LIST
            )
        }
    }

    override fun clickItem(test: Test) {
        val dialog = WeatherDialog()
        dialog.show(supportFragmentManager, "DIALOG_ITEM")
    }

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