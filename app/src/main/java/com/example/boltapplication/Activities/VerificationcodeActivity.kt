package com.example.boltapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.example.boltapplication.R

class VerificationcodeActivity : AppCompatActivity() {
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var continueBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verificationcode)
        continueBtn= findViewById(R.id.continuebtn)
        continueBtn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
//        toolbar = findViewById(R.id.toolbar_actionbar2)
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayShowTitleEnabled(false)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}