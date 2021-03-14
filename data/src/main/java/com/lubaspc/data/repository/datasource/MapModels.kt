package com.lubaspc.data.repository.datasource

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.lubaspc.data.repository.room.entities.Weather
import com.lubaspc.domain.model.Test
import java.util.*

fun Weather.toTest(): Test =
    Gson().fromJson<Test>(this.modelString, Test::class.java).apply {
        createdAt = this@toTest.createdAt
    }

fun com.lubaspc.data.repository.retrofit.models.Test.toTestDomain(): Test =
    Gson().fromJson<Test>(this.toString(), Test::class.java).apply {
        createdAt = Date()
    }