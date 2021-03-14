package com.lubaspc.testopenweather.ui.view.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.lubaspc.domain.model.Test
import com.lubaspc.testopenweather.R
import com.lubaspc.testopenweather.databinding.DialogWeatherBinding
import com.lubaspc.testopenweather.ui.presenter.DialogWeatherPresenter
import java.text.DateFormat

class WeatherDialog(private val test: Test) : DialogFragment(){

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val vBind = DialogWeatherBinding.bind(
            activity!!.layoutInflater.inflate(
                R.layout.dialog_weather,
                null
            )
        )
        builder.setView(vBind.root)
        vBind.testHtml = DialogWeatherPresenter().formatTest(test)
        return builder.apply {
            setNegativeButton("Cerrar"){dialog,_->
                dialog.cancel()
            }
        }.create()
    }
}