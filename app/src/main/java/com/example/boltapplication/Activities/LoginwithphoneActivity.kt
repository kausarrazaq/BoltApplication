package com.example.boltapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.example.boltapplication.R

class LoginwithphoneActivity : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginwithphone)
//        toolbar = findViewById(R.id.toolbar_actionbar1)
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayShowTitleEnabled(false)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nextButton = findViewById(R.id.nextbtn)
        nextButton.setOnClickListener {
            val intent = Intent(this,VerificationcodeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
