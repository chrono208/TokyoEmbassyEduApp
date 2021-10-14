package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Contacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        //Sends to home page.
        val hButton = findViewById<Button>(R.id.hButton)
        hButton.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        //Sends to events page.
        val eveButton = findViewById<Button>(R.id.eveButton)
        eveButton.setOnClickListener{
            val intent2 = Intent(this, Events::class.java)
            startActivity(intent2)
        }

        //Sends to faq page.
        val faqButton = findViewById<Button>(R.id.faqButton)
        faqButton.setOnClickListener{
            val intent3 = Intent(this, FAQ::class.java)
            startActivity(intent3)
        }
    }
}