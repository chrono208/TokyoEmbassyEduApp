package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Sends to login page.
        val lButton = findViewById<Button>(R.id.lButton)
        lButton.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        //Sends to register page.
        val rButton = findViewById<Button>(R.id.rButton)
        rButton.setOnClickListener{
            val intent2 = Intent(this, Register::class.java)
            startActivity(intent2)
        }

        //Sends to home page.
        val gButton = findViewById<Button>(R.id.gButton)
        gButton.setOnClickListener{
            val intent3 = Intent(this, Home::class.java)
            startActivity(intent3)
        }
    }
}