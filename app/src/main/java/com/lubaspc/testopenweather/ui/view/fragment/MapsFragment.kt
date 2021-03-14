package com.lubaspc.testopenweather.ui.view.fragment

import android.content.Context
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.lubaspc.domain.model.Test
import com.lubaspc.domain.usecase.TestUseCase
import com.lubaspc.testopenweather.R
import com.lubaspc.testopenweather.ui.presenter.MapFragmentPresenter
import com.lubaspc.testopenweather.ui.view.activity.MainActivity

class MapsFragment(private val testUseCase: TestUseCase) : Fragment() {
    private lateinit var handle: MapFragmentHandle
    private lateinit var marker: Marker
    private lateinit var presenter: MapFragmentPresenter
    private lateinit var map: GoogleMap
    private lateinit var test: Test

    override fun onAttach(context: Context) {
        super.onAttach(context)
        handle = context as MainActivity
        presenter = MapFragmentPresenter(testUseCase)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_maps, container, false)

    private fun moveMarker() {
        presenter.getLatLng {latLng,test ->
            if (latLng == null || test == null) return@getLatLng
            this.test = test
            marker = map.addMarker(MarkerOptions().position(latLng).title(test.name))
            map.moveCamera(CameraUpdateFactory.newLatLng(latLng))
            handle.hideProgress()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        moveMarker()
        handle.refreshPosition {
            moveMarker()
        }
        map.setOnMarkerClickListener {
            handle.clickItem(this.test)
            false
        }
    }

    interface MapFragmentHandle{
        fun refreshPosition(cb: () -> Unit)
        fun hideProgress()
        fun clickItem(test: Test)
    }
}