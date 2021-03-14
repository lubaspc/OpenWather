package com.lubaspc.testopenweather.ui.presenter

import com.google.android.gms.maps.model.LatLng
import com.lubaspc.domain.model.Test
import com.lubaspc.domain.usecase.TestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MapFragmentPresenter( private val testUseCase: TestUseCase) {

    fun getLatLng(cb: (LatLng?,test:Test?) -> Unit) = GlobalScope.launch(Dispatchers.Main) {
        var test = withContext(Dispatchers.IO){testUseCase.getTestLast()}
        if (test == null)
            test = withContext(Dispatchers.IO){testUseCase.getTest()}

        if (test == null){
            cb(null,null)
            return@launch
        }
        cb(LatLng(test.coord.lat,test.coord.lon),test)
    }
}