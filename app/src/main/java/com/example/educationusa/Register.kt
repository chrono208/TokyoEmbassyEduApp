package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.example.educationusa.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var mAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //mAuth
        mAuth = FirebaseAuth.getInstance()
        binding.subButton.setOnClickListener{
            validateData()
        }
        binding.canButton.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }//Oncreate.

    private fun validateData() {
        email = binding.email.text.toString().trim()
        password = binding.pass.text.toString().trim()

        //Validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //Invalid email
            binding.email.error = "Invalid email format."
        }//If.
        else if (TextUtils.isEmpty(password)){
            //Invalid email
            binding.email.error = "Invalid email format."
        }//Else if pass.
        else if(password.length<6){
            binding.pass.error = "Password must be at least 6 characters long"
        }//Else is length
        else {
            firebaseSignUp()
        }//Else.
    }//Validate data.

    private fun firebaseSignUp(){

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val fbUser = mAuth.currentUser
                val email = fbUser!!.email
                Toast.makeText(this, "Account created with email $email", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, Home::class.java))
                finish()
            }
            .addOnFailureListener {e->
                Toast.makeText(this, "Sign up failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() //Go Back
        return super.onSupportNavigateUp()
    }//On Support.
}//App activity.