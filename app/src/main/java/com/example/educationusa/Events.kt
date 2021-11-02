package com.example.educationusa

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jsoup.Jsoup
import kotlin.concurrent.thread
import com.squareup.picasso.Picasso
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import org.w3c.dom.Text

class Events : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        var imlist = ArrayList<String>()
        var tlist = ArrayList<String>()

        var im1 = findViewById<ImageView>(R.id.im1)
        var dtext1 = findViewById<TextView>(R.id.dtex)

        doAsync {
            var doc = Jsoup.connect("https://educationusa.state.gov/find-event/").get()
            var allinfo = doc.getElementsByClass("view-content")
            //System.out.println(allinfo)
            for(i in allinfo){
                //var im = i.getElementsByTag("img").attr("src")
                var disc = i.getElementsByClass("views-field views-field-title")
                    .select("a")
                    .text()
                System.out.println(disc)
                //imlist.add(im)
                tlist.add(disc)
            }
            uiThread {
                //Glide.with(this@Events).load(imlist[1]).into(im1)
                dtext1.text=tlist[0]
            }
        }

    }//On Create.



}//Class.