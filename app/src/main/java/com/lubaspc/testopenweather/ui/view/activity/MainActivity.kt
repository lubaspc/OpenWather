package com.lubaspc.testopenweather.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lubaspc.domain.usecase.GetTest
import com.lubaspc.testopenweather.App
import com.lubaspc.testopenweather.R
import com.lubaspc.testopenweather.databinding.ActivityMainBinding
import com.lubaspc.testopenweather.ui.view.fragment.MapsFragment
import com.lubaspc.testopenweather.utils.FragmentUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var vBind: ActivityMainBinding

    @Inject
    lateinit var getTest: GetTest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        FragmentUtils.addFragment(
            supportFragmentManager.beginTransaction(),
            MapsFragment(),
            "MAP",
            vBind.flContainer
        )
        (application as App).getMainComponent().inject(this)

        runBlocking {
            withContext(Dispatchers.IO){
                getTest.invoke()
            }
        }
    }
}