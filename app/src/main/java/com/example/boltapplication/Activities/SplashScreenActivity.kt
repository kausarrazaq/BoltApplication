package com.example.boltapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.boltapplication.R

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var splashScreen: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreenactivity)
        splashScreen= findViewById(R.id.splashscreen)
        Handler().postDelayed({
            val intent = Intent(this, LoginwithphoneActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}