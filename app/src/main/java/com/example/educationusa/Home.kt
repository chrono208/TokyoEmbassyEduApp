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

    private val handlerAnimation = Handler()
    private val statusAnimation = false

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Global valiables.
        val imagelist = ArrayList<String>()
        val image1 = findViewById<ImageView>(R.id.image1)


        doAsync {
            val doc = Jsoup.connect("https://educationusa.state.gov/find-event/").get()
            val allinfo = doc.getElementsByClass("panel-pane pane-fieldable-panels-pane pane-fpid-219")

            //Allinfo loop, contains nested for loops.
            for(i in allinfo) {
                val image = i.getElementsByTag("img").attr("src")
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
    }
}