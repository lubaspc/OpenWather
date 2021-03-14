package com.lubaspc.testopenweather.utils

import android.text.Html
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import kotlin.math.roundToInt

@BindingAdapter("htmlFormat")
fun TextView.htmlFormat(string: String?){
    this.text = Html.fromHtml(string)
}

@BindingAdapter("textTemperatureKtoC")
fun TextView.textTemperatureKtoC(kelvin: Double?){
    this.text = "Temperatura: ${((kelvin ?: 273.15) - 273.15).roundToInt()}°c"
}