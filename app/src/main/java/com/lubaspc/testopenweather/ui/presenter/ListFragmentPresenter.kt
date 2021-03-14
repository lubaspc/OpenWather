package com.lubaspc.testopenweather.ui.presenter

import com.lubaspc.domain.model.Test
import com.lubaspc.domain.usecase.TestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListFragmentPresenter( private val testUseCase: TestUseCase){

    fun getTests(cb: (List<Test>) -> Unit) = GlobalScope.launch(Dispatchers.Main) {
        val tests = withContext(Dispatchers.IO){testUseCase.getTests()}
        cb(tests)
    }
}