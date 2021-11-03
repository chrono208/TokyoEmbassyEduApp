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

        //Global Variables.
        var tlist = ArrayList<String>()
        var slist = ArrayList<String>()
        var dslist = ArrayList<String>()
        var delist = ArrayList<String>()
        var eventTypelist = ArrayList<String>()
        var eventOnlinelist = ArrayList<String>()
        var locationlist = ArrayList<String>()
        var countrylist = ArrayList<String>()
        var singleDatelist = ArrayList<String>()

        //Section1 Variables.
        var title1 = findViewById<TextView>(R.id.title1)
        var summary1 = findViewById<TextView>(R.id.summary1)
        var startDate1 = findViewById<TextView>(R.id.startDate1)
        var endDate1 = findViewById<TextView>(R.id.endDate1)
        var eType1 = findViewById<TextView>(R.id.eType1)
        var online1 = findViewById<TextView>(R.id.online1)
        var country1 = findViewById<TextView>(R.id.country1)
        var location1 = findViewById<TextView>(R.id.location1)

        //Section 2 Variables
        var title2 = findViewById<TextView>(R.id.title2)
        var summary2 = findViewById<TextView>(R.id.summary2)
        var startDate2 = findViewById<TextView>(R.id.startDate2)
        var eType2 = findViewById<TextView>(R.id.eType2)
        var online2 = findViewById<TextView>(R.id.online2)
        var country2 = findViewById<TextView>(R.id.country2)
        var location2 = findViewById<TextView>(R.id.location2)

        //Section 3 Variables
        var title3 = findViewById<TextView>(R.id.title3)
        var summary3 = findViewById<TextView>(R.id.summary3)
        var startDate3 = findViewById<TextView>(R.id.startDate3)
        var eType3 = findViewById<TextView>(R.id.eType3)
        var online3 = findViewById<TextView>(R.id.online3)
        var country3 = findViewById<TextView>(R.id.country3)
        var location3 = findViewById<TextView>(R.id.location3)

        //Section 4 Variables
        var title4 = findViewById<TextView>(R.id.title4)
        var summary4 = findViewById<TextView>(R.id.summary4)
        var startDate4 = findViewById<TextView>(R.id.startDate4)
        var eType4 = findViewById<TextView>(R.id.eType4)
        var online4 = findViewById<TextView>(R.id.online4)
        var country4 = findViewById<TextView>(R.id.country4)
        var location4 = findViewById<TextView>(R.id.location4)


        //Section 5 Variables
        var title5 = findViewById<TextView>(R.id.title5)
        var summary5 = findViewById<TextView>(R.id.summary5)
        var startDate5 = findViewById<TextView>(R.id.startDate5)
        var eType5 = findViewById<TextView>(R.id.eType5)
        var online5 = findViewById<TextView>(R.id.online5)
        var country5 = findViewById<TextView>(R.id.country5)
        var location5 = findViewById<TextView>(R.id.location5)


        //Section 6 Variables
        var title6 = findViewById<TextView>(R.id.title6)
        var summary6 = findViewById<TextView>(R.id.summary6)
        var startDate6 = findViewById<TextView>(R.id.startDate6)
        var eType6 = findViewById<TextView>(R.id.eType6)
        var online6 = findViewById<TextView>(R.id.online6)
        var country6 = findViewById<TextView>(R.id.country6)
        var location6 = findViewById<TextView>(R.id.location6)


        //Section 7 Variables
        var title7 = findViewById<TextView>(R.id.title7)
        var summary7 = findViewById<TextView>(R.id.summary7)
        var startDate7 = findViewById<TextView>(R.id.startDate7)
        var eType7 = findViewById<TextView>(R.id.eType7)
        var online7 = findViewById<TextView>(R.id.online7)
        var country7 = findViewById<TextView>(R.id.country7)
        var location7 = findViewById<TextView>(R.id.location7)


        //Section 8 Variables
        var title8 = findViewById<TextView>(R.id.title8)
        var summary8 = findViewById<TextView>(R.id.summary8)
        var startDate8 = findViewById<TextView>(R.id.startDate8)
        var eType8 = findViewById<TextView>(R.id.eType8)
        var online8 = findViewById<TextView>(R.id.online8)
        var country8 = findViewById<TextView>(R.id.country8)
        var location8 = findViewById<TextView>(R.id.location8)


        //Section 9 Variables
        var title9 = findViewById<TextView>(R.id.title9)
        var summary9 = findViewById<TextView>(R.id.summary9)
        var startDate9 = findViewById<TextView>(R.id.startDate9)
        var eType9 = findViewById<TextView>(R.id.eType9)
        var online9 = findViewById<TextView>(R.id.online9)
        var country9 = findViewById<TextView>(R.id.country9)
        var location9 = findViewById<TextView>(R.id.location9)


        //Section 10 Variables
        var title10 = findViewById<TextView>(R.id.title10)
        var summary10 = findViewById<TextView>(R.id.summary10)
        var startDate10 = findViewById<TextView>(R.id.startDate10)
        var eType10 = findViewById<TextView>(R.id.eType10)
        var online10 = findViewById<TextView>(R.id.online10)
        var country10 = findViewById<TextView>(R.id.country10)
        var location10 = findViewById<TextView>(R.id.location10)

        //Core Functionality.
        doAsync {
            //Containers to search for.
            var doc = Jsoup.connect("https://educationusa.state.gov/find-event/").get()
            var allinfo = doc.getElementsByClass("views-field views-field-title")
            var sums = doc.getElementsByClass("views-field views-field-field-summary")
            var dates = doc.getElementsByClass("field-event-date")
            var eventType = doc.getElementsByClass("views-row views-row-1 views-row-odd views-row-first")
            var singleDate = doc.getElementsByClass("date-display-single")
            var location = doc.getElementsByClass("views-field views-field-field-event-in-person-location-country")

            //Allinfo loop, contains nested for loops.
            for(i in allinfo){
                var eTitle = i.getElementsByClass("field-content")
                    .select("h3")
                    .text()
                tlist.add(eTitle)

                //Sums loop
                for(j in sums) {
                    var eSums = j.getElementsByClass("field-content")
                        .select("p")
                        .text()
                    slist.add(eSums)
                }//Sums.

                //Dates loop
                for(k in dates) {
                    var eDatesS = k.getElementsByClass("date-display-start")
                        .select("span")
                        .text()
                    var eDatesE = k.getElementsByClass("date-display-end")
                        .select("span")
                        .text()
                    dslist.add(eDatesS)
                    delist.add(eDatesE)
                }//Dates.

                //Single Dates loop
                for(k in singleDate) {
                    var eDatesS = k.getElementsByClass("date-display-single")
                        .text()
                    singleDatelist.add(eDatesS)
                }//Dates.

                //Location loop
                for(k in location) {
                    var elocation = k.getElementsByClass("views-label views-label-field-event-in-person-location-country")
                        .select("span")
                        .text()
                    var ecountry = k.getElementsByClass("field-content")
                        .select("span")
                        .text()
                    locationlist.add(elocation)
                    countrylist.add(ecountry)
                }//Location.

                //Event Type loop
                for(k in location) {
                    var eType = k.getElementsByClass("div")
                        .select("span")
                        .text()
                    var eOnline = k.getElementsByClass("div")
                        .select("span")
                        .text()
                    eventTypelist.add(eType)
                    eventOnlinelist.add(eOnline)
                }//Event Type.
            }//Allinfo.



            uiThread {

                //Panel 1.
                title1.text=tlist[0]
                summary1.text=slist[0]
                startDate1.text=dslist[0]
                endDate1.text=delist[0]
                country1.text=countrylist[0]
                location1.text=locationlist[0]
                //eType1.text=eventTypelist[0]
                //online1.text=onlinelist[0]

                //Panel 2.
                title2.text=tlist[1]
                summary2.text=slist[1]
                startDate2.text=singleDatelist[0]
                country2.text=countrylist[1]
                location2.text=locationlist[1]

                //Panel3.
                title3.text=tlist[2]
                summary3.text=slist[2]
                startDate3.text=singleDatelist[1]
                country3.text=countrylist[2]
                location3.text=locationlist[2]

                //Panel4.
                title4.text=tlist[3]
                summary4.text=slist[3]
                startDate4.text=singleDatelist[2]
                country4.text=countrylist[3]
                location4.text=locationlist[3]

                //Panel5.
                title5.text=tlist[4]
                summary5.text=slist[4]
                startDate5.text=singleDatelist[3]
                country5.text=countrylist[4]
                location5.text=locationlist[4]

                //Panel6.
                title6.text=tlist[5]
                summary6.text=slist[5]
                startDate6.text=singleDatelist[4]
                country6.text=countrylist[5]
                location6.text=locationlist[5]

                //Panel7.
                title7.text=tlist[6]
                summary7.text=slist[6]
                startDate7.text=singleDatelist[5]
                country7.text=countrylist[6]
                location7.text=locationlist[6]

                //Panel8.
                title8.text=tlist[7]
                summary8.text=slist[7]
                startDate8.text=singleDatelist[6]
                country8.text=countrylist[7]
                location8.text=locationlist[7]

                //Panel9.
                title9.text=tlist[8]
                summary9.text=slist[8]
                startDate9.text=singleDatelist[7]
                country9.text=countrylist[8]
                location9.text=locationlist[8]

                //Panel10.
                title10.text=tlist[9]
                summary10.text=slist[9]
                startDate10.text=singleDatelist[8]
                country10.text=countrylist[9]
                location10.text=locationlist[9]
            }//UiThread.
        }//Async.
    }//On Create.
}//Class.