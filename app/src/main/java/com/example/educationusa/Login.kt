package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Sends to start page.
        val canButton = findViewById<Button>(R.id.canButton)
        canButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Sends to home page.
        val cleButton = findViewById<Button>(R.id.cleButton)
        cleButton.setOnClickListener{
            val intent2 = Intent(this, Home::class.java)
            startActivity(intent2)
        }

        //Sends to home page.
        val regButton = findViewById<Button>(R.id.regButton)
        regButton.setOnClickListener{
            val intent3 = Intent(this, Home::class.java)
            startActivity(intent3)
        }
    }
}