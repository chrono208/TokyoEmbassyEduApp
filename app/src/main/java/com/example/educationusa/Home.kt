package com.example.educationusa

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Global valiables.
        val imagelist = ArrayList<String>()
        val image1 = findViewById<ImageView>(R.id.image1)


        doAsync {
            val doc = Jsoup.connect("https://americancenterjapan.com/event/").get()
            val allinfo = doc.getElementsByClass("clearfix")
            //System.out.println(allinfo)

            //Allinfo loop, contains nested for loops.
            for(i in allinfo) {
                val image = i.getElementsByTag("img")
                    .attr("src")
                //System.out.println(image)
                imagelist.add(image)

            }//Allinfo.
            uiThread {
                Glide.with(this@Home).load(imagelist[0]).into(image1)
            }//UiThread.
        }//Async.


        //Sends to events page.
        val eveButton = findViewById<Button>(R.id.eveButton)
        eveButton.setOnClickListener{
            val intent = Intent(this, Events::class.java)
            startActivity(intent)
        }//To Events.

        //Sends to faq page.
        val faqButton = findViewById<Button>(R.id.faqButton)
        faqButton.setOnClickListener{
            val intent2 = Intent(this, FAQ::class.java)
            startActivity(intent2)
        }//To FAQ.

        //Sends to contacts page.
        val conButton = findViewById<Button>(R.id.conButton)
        conButton.setOnClickListener{
            val intent3 = Intent(this, Contacts::class.java)
            startActivity(intent3)
        }//To Contacts.

        //Sends to profile page.
        val profileBtn = findViewById<Button>(R.id.profileBtn)
        profileBtn.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }//To Profile.
    }
}