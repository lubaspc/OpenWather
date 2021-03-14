package com.lubaspc.testopenweather.utils

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.init(ctx: Context) {
    this.itemAnimator = DefaultItemAnimator()
    this.layoutManager = LinearLayoutManager(ctx)
}

fun RecyclerView.init(layout: RecyclerView.LayoutManager) {
    this.itemAnimator = DefaultItemAnimator()
    this.layoutManager = layout
}