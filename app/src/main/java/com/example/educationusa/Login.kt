package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.educationusa.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    //private lateinit var actionBar: ActionBar
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_login)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance();
        checkUser()

        binding.regButton.setOnClickListener(){
            startActivity(Intent(this,Register::class.java))
        }
        binding.logButton.setOnClickListener(){
            validateData()
        }

        val canButton = findViewById<Button>(R.id.canButton)
        canButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }//Oncreate.

    private fun validateData(){
        //Get data
        email = binding.email.text.toString().trim()
        password = binding.pass.text.toString().trim()
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.email.error = "Invalid email format"
        }//If.
        else if (TextUtils.isEmpty(password)){
            binding.pass.error = "Please enter password"
        }
        else {
            firebaseLogin()
        }
    }//Validate data.

    private fun firebaseLogin(){
        mAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                //Login Success

                //Get user info.
                val fbUser = mAuth.currentUser
                val email = fbUser!!.email
                Toast.makeText(this, "Logged in as $email", Toast.LENGTH_SHORT).show()

                //Open home
                startActivity(Intent(this, Profile::class.java))
                finish()
            }
            .addOnFailureListener{ e->

                Toast.makeText(this, "Login failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }//Firebase login.

    private fun checkUser() {
        //Check is user is signed in.
        val currentUser = mAuth.currentUser
        if(currentUser != null){
            startActivity(Intent(this, Profile::class.java))
            finish()
        }//If.
    }//CheckUser.
}