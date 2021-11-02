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
        var slist = ArrayList<String>()
        var dslist = ArrayList<String>()
        var delist = ArrayList<String>()

        var im1 = findViewById<ImageView>(R.id.im1)
        var dtext1 = findViewById<TextView>(R.id.dtex)
        var dtext5 = findViewById<TextView>(R.id.dtex5)
        var dtext6 = findViewById<TextView>(R.id.dtex6)
        var dtext8 = findViewById<TextView>(R.id.dtex8)

        doAsync {
            var doc = Jsoup.connect("https://educationusa.state.gov/find-event/").get()
            var allinfo = doc.getElementsByClass("views-field views-field-title")
            var sums = doc.getElementsByClass("views-field views-field-field-summary")
            var dates = doc.getElementsByClass("field-event-date")
            //System.out.println(sums)
            for(i in allinfo){
                //var im = i.getElementsByTag("img").attr("src")
                var eTitle = i.getElementsByClass("field-content")
                    .select("h3")
                    .text()
                //System.out.println(eTitle)
                //imlist.add(im)
                tlist.add(eTitle)
                for(j in sums) {
                    var eSums = j.getElementsByClass("field-content")
                        .select("p")
                        .text()
                    //System.out.println(eSums)
                    slist.add(eSums)
                }
                for(k in dates) {
                    var eDatesS = k.getElementsByClass("date-display-start")
                        .select("span")
                        .text()
                    var eDatesE = k.getElementsByClass("date-display-end")
                        .select("span")
                        .text()
                    //System.out.println(eDates)
                    dslist.add(eDatesS)
                    delist.add(eDatesE)
                }
            }



            uiThread {
                //Glide.with(this@Events).load(imlist[1]).into(im1)
                dtext1.text=tlist[0]
                dtext5.text=slist[0]
                dtext6.text=dslist[0]
                dtext8.text=dslist[0]
            }
        }

    }//On Create.



}//Class.