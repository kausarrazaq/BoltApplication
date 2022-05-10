package com.example.boltapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.boltapplication.R

class RideCompletedActivity : AppCompatActivity() {
    private lateinit var finishRide : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ride_completed)
        finishRide= findViewById(R.id.finshride)
        finishRide.setOnClickListener {
            val intent= Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}