package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.educationusa.databinding.ActivityProfile2Binding
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivityProfile2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfile2Binding.inflate(layoutInflater)
        //setContentView(R.layout.activity_profile2)
        setContentView(binding.root)


        mAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.logButton.setOnClickListener {
            mAuth.signOut()
            checkUser()
        }
        binding.homeButton.setOnClickListener{
            startActivity(Intent(this, Home::class.java))
            finish()
        }
        /*
        val hb = findViewById<Button>(R.id.homeButton)
            hb.setOnClickListener{
            val intent = Intent (this, Home::class.java)
                startActivity(intent)
        }*/
    }//On Create


    private fun checkUser() {
        val fbUser = mAuth.currentUser
        if(fbUser != null) {
            val email = fbUser.email
            binding.emailTv.text = email
        }//If.
        else {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }//Check user.
}