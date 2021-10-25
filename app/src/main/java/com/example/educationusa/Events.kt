package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup

class Events : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        var titleList = ArrayList<String>()
        var dateList = ArrayList<String>()
        var typeList = ArrayList<String>()
        var locationList = ArrayList<String>()
        var audienceList = ArrayList<String>()
        var discList = ArrayList<String>()
        var dtext1 = findViewById<TextView>(R.id.dtex)
        var dtext2 = findViewById<TextView>(R.id.dtex2)
        var dtext3 = findViewById<TextView>(R.id.dtex3)
        var dtext4 = findViewById<TextView>(R.id.dtex4)
        var dtext5 = findViewById<TextView>(R.id.dtex5)
        var dtext6 = findViewById<TextView>(R.id.dtex6)

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


    doAsync {
        var doc = Jsoup.connect("https://educationusa.state.gov/find-event").get()
        var div1 = doc.getElementsByClass("views-field views-field-title")
        //var div2 = doc.getElementsByClass("views-row views-row-2 views-row-even")
       //var div3 = doc.getElementsByClass("views-row views-row-3 views-row-odd")
        //var div4 = doc.getElementsByClass("views-row views-row-4 views-row-even")
        //var div5 = doc.getElementsByClass("views-row views-row-5 views-row-odd")
        //var div6 = doc.getElementsByClass("views-row views-row-6 views-row-even")
       // var div7 = doc.getElementsByClass("views-row views-row-7 views-row-odd")
       // var div8 = doc.getElementsByClass("views-row views-row-8 views-row-even")
       // var div9 = doc.getElementsByClass("views-row views-row-9 views-row-odd")
       // var div10 = doc.getElementsByClass("views-row views-row-10 views-row-even views-row-last")

        for (i in div1){
            var eventTitle = i.getElementsByClass("field-content").text()
            var eventDate = i.getElementsByClass("field-event-date").text()
            var eventType = i.getElementsByClass("").text()
            var eventLocation = i.getElementsByClass("views-field views-field-field-event-in-person-location-country").text()
            var eventAudience = i.getElementsByClass("views-field views-field-field-audience").text()
            var eventDisc = i.getElementsByClass("views-field views-field-field-summary").text()

            titleList.add(eventTitle)
            dateList.add(eventDate)
            typeList.add(eventType)
            locationList.add(eventLocation)
            audienceList.add(eventAudience)
            discList.add(eventDisc)
            System.out.println(titleList)
        }//For.

        uiThread {
            dtext1.text = titleList[0]
            dtext2.text = dateList[1]
            dtext3.text = typeList[2]
            dtext4.text = locationList[3]
            dtext5.text = audienceList[4]
            dtext6.text = discList[5]
        }//UI Thread.
    }//DoAsync.
    }//On Create.
}//Class.