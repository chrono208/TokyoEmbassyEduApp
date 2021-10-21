package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Events : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        //Sends to home page.
        val hButton = findViewById<Button>(R.id.hButton)
        hButton.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        //Sends to faq page.
        val faqButton = findViewById<Button>(R.id.faqButton)
        faqButton.setOnClickListener{
            val intent2 = Intent(this, FAQ::class.java)
            startActivity(intent2)
        }

        //Sends to contacts page.
        val conButton = findViewById<Button>(R.id.conButton)
        conButton.setOnClickListener{
            val intent3 = Intent(this, Contacts::class.java)
            startActivity(intent3)
        }



    }//On Create


}//Class