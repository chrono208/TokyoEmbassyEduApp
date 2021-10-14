package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Sends to home page.
        val sButton2 = findViewById<Button>(R.id.sButton)
        sButton2.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        //Sends to start page.
        val cButton = findViewById<Button>(R.id.cButton)
        cButton.setOnClickListener{
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }
    }
}