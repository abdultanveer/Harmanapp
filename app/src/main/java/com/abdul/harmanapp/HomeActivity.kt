package com.abdul.harmanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    lateinit var tvHome: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home)
        tvHome = findViewById(R.id.tvHome)

        var dataReceived :String
        dataReceived = intent.extras?.getString("ip").toString()

       // tvHome.setText(dataReceived)
        tvHome.text = dataReceived
    }
}