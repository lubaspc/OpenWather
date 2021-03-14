package com.lubaspc.testopenweather.utils

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.init(
    ctx: Context,
    layout: RecyclerView.LayoutManager = LinearLayoutManager(ctx)
) {
    this.itemAnimator = DefaultItemAnimator()
    this.layoutManager = layout
}