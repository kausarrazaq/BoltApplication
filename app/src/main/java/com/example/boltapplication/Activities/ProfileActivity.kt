package com.example.boltapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import com.example.boltapplication.R

class ProfileActivity : AppCompatActivity() {
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var editProfile :ImageView
    private lateinit var help: ImageView
    private lateinit var trips: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        toolbar = findViewById(R.id.toolbar_actionbar6)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        editProfile= findViewById(R.id.editprofile)
        help= findViewById(R.id.help)
        trips= findViewById(R.id.trips)
        editProfile.setOnClickListener {
            val intent= Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
        help.setOnClickListener {
            val intent= Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
        trips.setOnClickListener {
            val intent= Intent(this, TripsActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}