package com.clml.clmaplication.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.clml.clmaplication.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapa) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val jm = LatLng(-15.886985695441298, -47.81825085896464)
        mMap.addMarker(MarkerOptions().position(jm).title("Jardins Mangueiral"))

        val end1 = LatLng(-15.773173349054312, -47.88651460671904)
        mMap.addMarker(MarkerOptions().position(end1).title("Asa norte"))

        val end2 = LatLng(-15.823437337671104, -47.92284138782269)
        mMap.addMarker(MarkerOptions().position(end2).title("Asa Sul"))

        mMap.setOnMarkerClickListener { marker ->
            if (marker.isInfoWindowShown) {
                 marker.hideInfoWindow()
            } else {
                marker.showInfoWindow()
            }
            true
        }

        val zoomLevel = 10.0.toFloat()
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jm, zoomLevel))



    }
}