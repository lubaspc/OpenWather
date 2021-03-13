package com.lubaspc.testopenweather.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.lubaspc.testopenweather.R
import com.lubaspc.testopenweather.databinding.ActivityMainBinding
import com.lubaspc.testopenweather.ui.view.fragment.MapsFragment
import com.lubaspc.testopenweather.utils.FragmentUtils

class MainActivity : AppCompatActivity() {
    private lateinit var vBind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        FragmentUtils.addFragment(
            supportFragmentManager.beginTransaction(),
            MapsFragment(),
            "MAP",
            vBind.flContainer
        )
    }
}