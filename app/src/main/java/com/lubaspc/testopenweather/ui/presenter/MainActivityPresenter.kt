package com.lubaspc.testopenweather.ui.presenter

import com.lubaspc.domain.usecase.TestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityPresenter(private val testUseCase: TestUseCase) {

    fun getTest(cb: () -> Unit) = GlobalScope.launch(Dispatchers.Main) {
        withContext(Dispatchers.IO){testUseCase.getTest()}
        cb()
    }
}