package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val im1 = findViewById<ImageView>(R.id.splash)
        im1.alpha = 0f
        im1.animate().setDuration(2000).alpha(1f).withEndAction{
            val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
        }
    }
}