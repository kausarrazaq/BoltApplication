package com.example.boltapplication.Activities

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.boltapplication.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.material.navigation.NavigationView

class RideStartedActivity : AppCompatActivity() , OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private lateinit var finishRide : Button
    private lateinit var lastLocation: Location
    private lateinit var map: GoogleMap
    private lateinit var drawarIcon:ImageView
    lateinit var toogle: ActionBarDrawerToggle
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var navigationView: NavigationView
    private lateinit var viewProfileText: TextView
    private lateinit var backArrow: ImageView
    companion object {
        const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ride_started)
        navigationView = findViewById(R.id.sidebar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerlayout)

        val header = navigationView.getHeaderView(0)
        viewProfileText=header.findViewById(R.id.viewprofile)
        backArrow=header.findViewById(R.id.backarrow2)
        backArrow.setOnClickListener {
            drawerLayout.closeDrawers()
        }
        viewProfileText.setOnClickListener {
            val intent=Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }


        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.ic_Home -> {
                    drawerLayout.closeDrawers()
                }
                R.id.ic_Payments -> {
                    val intent = Intent(baseContext, PaymentsActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                }
                R.id.ic_Trips -> {
                    startActivity(Intent(baseContext, TripsActivity::class.java))
                    drawerLayout.closeDrawers()
                }
                R.id.ic_About -> {
                    startActivity(Intent(baseContext, AboutActivity::class.java))
                    drawerLayout.closeDrawers()
                }


            }
            true
        }
        drawarIcon = findViewById(R.id.sidebaricon)
        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        drawarIcon.setOnClickListener {
            if (!drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.openDrawer(
                GravityCompat.START
            )
            else drawerLayout.closeDrawer(GravityCompat.END)
        }

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map2) as SupportMapFragment
        mapFragment.getMapAsync(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        finishRide = findViewById(R.id.finishride)
        finishRide.setOnClickListener {
            val intent= Intent(this, TakephotoActivity::class.java)
            startActivity(intent)
        }

    }
    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                RideStartedActivity.LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }

        map.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(currentLatLng)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }
    }
    private fun placeMarkerOnMap(location: LatLng) {
        // 1
        val markerOptions = MarkerOptions().position(location)
        // 2
        map.addMarker(markerOptions)
        markerOptions.icon(
            BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(resources, R.drawable.meicon)))

    }
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        map.uiSettings.isZoomControlsEnabled = true
        map.setOnMarkerClickListener(this)

        setUpMap()
    }


    override fun onMarkerClick(p0: Marker): Boolean = false
}

