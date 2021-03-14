package com.lubaspc.testopenweather.utils

import android.content.res.ColorStateList
import android.text.Html
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lubaspc.testopenweather.R
import kotlin.math.roundToInt

@BindingAdapter("htmlFormat")
fun TextView.htmlFormat(string: String?){
    text = Html.fromHtml(string)
}

@BindingAdapter("textTemperatureKtoC")
fun TextView.textTemperatureKtoC(kelvin: Double?){
    text = "Temperatura: ${((kelvin ?: 273.15) - 273.15).roundToInt()}°c"
}

@BindingAdapter("fbIsEnable")
fun FloatingActionButton.fbIsEnable(enable: Boolean?){
    isEnabled =enable == true
    backgroundTintList = if ( enable != true)
        ColorStateList.valueOf(resources.getColor(R.color.grey_dark))
    else
        ColorStateList.valueOf(resources.getColor(R.color.teal_200))

}