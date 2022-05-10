package com.example.boltapplication.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.boltapplication.Adapter.TripsAdapter
import com.example.boltapplication.Models.TripsModel
import com.example.boltapplication.R

class TripsActivity : AppCompatActivity() {
    private lateinit var tripsAdapter: TripsAdapter
    private val tripsList = ArrayList<TripsModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trips)
        toolbar = findViewById(R.id.toolbar_actionbar7)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.recyclerview)
        tripsAdapter = TripsAdapter(tripsList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = tripsAdapter

        var trip = TripsModel("Mother and Child Hospital","5 Aug 2020","5:39:09 pm","FINISHED","YOU CANCELLED")
        tripsList.add(trip)
        trip = TripsModel("Mother and Child","5 Aug 2020","5:39:09 pm","FINISHED","YOU CANCELLED")
        tripsList.add(trip)
        trip = TripsModel("Mother and Child Hospital","5 Aug 2020","5:39:09 pm","FINISHED","YOU CANCELLED")
        tripsList.add(trip)

        tripsAdapter.notifyDataSetChanged()

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}