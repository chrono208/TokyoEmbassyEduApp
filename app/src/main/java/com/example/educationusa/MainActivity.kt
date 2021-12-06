package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private var backPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Sends to login page.
        val lButton = findViewById<Button>(R.id.lButton)
        lButton.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }//To Login.

        //Sends to register page.
        val rButton = findViewById<Button>(R.id.rButton)
        rButton.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }//To Register.

        //Sends to home page.
        val gButton = findViewById<Button>(R.id.gButton)
        gButton.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }//To Home.

        //Sends to profile page.
        val profileBtn = findViewById<Button>(R.id.profileBtn)
        profileBtn.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }//To Profile.
    }//On Create

    override fun onBackPressed() {
        if (backPressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
        } else{
            Toast.makeText(applicationContext, "Press back again to exit the app.", Toast.LENGTH_SHORT).show()
        }
        backPressed = System.currentTimeMillis()
    }
}