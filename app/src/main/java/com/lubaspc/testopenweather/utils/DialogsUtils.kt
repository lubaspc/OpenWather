package com.lubaspc.testopenweather.utils

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Context.alert(
    title: String,
    message: String,
    cb: () -> Unit
) {
    MaterialAlertDialogBuilder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(
            "Ok"
        ) { _,_ -> cb() }
        .show()
}