@file:Suppress("NAME_SHADOWING")
package com.example.educationusa
import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract
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

        //Global valiables.
        val tlist = ArrayList<String>()
        val slist = ArrayList<String>()
        val dslist = ArrayList<String>()
        val delist = ArrayList<String>()
        val eventTypelist = ArrayList<String>()
        val eventOnlinelist = ArrayList<String>()
        val locationlist = ArrayList<String>()
        val countrylist = ArrayList<String>()
        val singleDatelist = ArrayList<String>()
        val imagelist = ArrayList<String>()

        //Section1 valiables.
        val banner = findViewById<ImageView>(R.id.banner1)
        val title1 = findViewById<TextView>(R.id.title1)
        val summary1 = findViewById<TextView>(R.id.summary1)
        val startDate1 = findViewById<TextView>(R.id.startDate1)
        val endDate1 = findViewById<TextView>(R.id.endDate1)
        //val eType1 = findViewById<TextView>(R.id.eType1)
        //val online1 = findViewById<TextView>(R.id.online1)
        val country1 = findViewById<TextView>(R.id.country1)
        val location1 = findViewById<TextView>(R.id.location1)

        //Section 2 valiables
        val title2 = findViewById<TextView>(R.id.title2)
        val summary2 = findViewById<TextView>(R.id.summary2)
        val startDate2 = findViewById<TextView>(R.id.startDate2)
        //val eType2 = findViewById<TextView>(R.id.eType2)
        //val online2 = findViewById<TextView>(R.id.online2)
        val country2 = findViewById<TextView>(R.id.country2)
        val location2 = findViewById<TextView>(R.id.location2)

        //Section 3 valiables
        val title3 = findViewById<TextView>(R.id.title3)
        val summary3 = findViewById<TextView>(R.id.summary3)
        val startDate3 = findViewById<TextView>(R.id.startDate3)
        //val eType3 = findViewById<TextView>(R.id.eType3)
        //val online3 = findViewById<TextView>(R.id.online3)
        val country3 = findViewById<TextView>(R.id.country3)
        val location3 = findViewById<TextView>(R.id.location3)

        //Section 4 valiables
        val title4 = findViewById<TextView>(R.id.title4)
        val summary4 = findViewById<TextView>(R.id.summary4)
        val startDate4 = findViewById<TextView>(R.id.startDate4)
        //val eType4 = findViewById<TextView>(R.id.eType4)
        //val online4 = findViewById<TextView>(R.id.online4)
        val country4 = findViewById<TextView>(R.id.country4)
        val location4 = findViewById<TextView>(R.id.location4)


        //Section 5 valiables
        val title5 = findViewById<TextView>(R.id.title5)
        val summary5 = findViewById<TextView>(R.id.summary5)
        val startDate5 = findViewById<TextView>(R.id.startDate5)
        //val eType5 = findViewById<TextView>(R.id.eType5)
        //val online5 = findViewById<TextView>(R.id.online5)
        val country5 = findViewById<TextView>(R.id.country5)
        val location5 = findViewById<TextView>(R.id.location5)


        //Section 6 valiables
        val title6 = findViewById<TextView>(R.id.title6)
        val summary6 = findViewById<TextView>(R.id.summary6)
        val startDate6 = findViewById<TextView>(R.id.startDate6)
        //val eType6 = findViewById<TextView>(R.id.eType6)
        //val online6 = findViewById<TextView>(R.id.online6)
        val country6 = findViewById<TextView>(R.id.country6)
        val location6 = findViewById<TextView>(R.id.location6)


        //Section 7 valiables
        val title7 = findViewById<TextView>(R.id.title7)
        val summary7 = findViewById<TextView>(R.id.summary7)
        val startDate7 = findViewById<TextView>(R.id.startDate7)
        //val eType7 = findViewById<TextView>(R.id.eType7)
        //val online7 = findViewById<TextView>(R.id.online7)
        val country7 = findViewById<TextView>(R.id.country7)
        val location7 = findViewById<TextView>(R.id.location7)


        //Section 8 valiables
        val title8 = findViewById<TextView>(R.id.title8)
        val summary8 = findViewById<TextView>(R.id.summary8)
        val startDate8 = findViewById<TextView>(R.id.startDate8)
        //val eType8 = findViewById<TextView>(R.id.eType8)
        //val online8 = findViewById<TextView>(R.id.online8)
        val country8 = findViewById<TextView>(R.id.country8)
        val location8 = findViewById<TextView>(R.id.location8)


        //Section 9 valiables
        val title9 = findViewById<TextView>(R.id.title9)
        val summary9 = findViewById<TextView>(R.id.summary9)
        val startDate9 = findViewById<TextView>(R.id.startDate9)
        //val eType9 = findViewById<TextView>(R.id.eType9)
        //val online9 = findViewById<TextView>(R.id.online9)
        val country9 = findViewById<TextView>(R.id.country9)
        val location9 = findViewById<TextView>(R.id.location9)


        //Section 10 valiables
        val title10 = findViewById<TextView>(R.id.title10)
        val summary10 = findViewById<TextView>(R.id.summary10)
        val startDate10 = findViewById<TextView>(R.id.startDate10)
        //val eType10 = findViewById<TextView>(R.id.eType10)
        //val online10 = findViewById<TextView>(R.id.online10)
        val country10 = findViewById<TextView>(R.id.country10)
        val location10 = findViewById<TextView>(R.id.location10)

        //Core Functionality.
        doAsync {
            //Containers to search for.
            val doc = Jsoup.connect("https://educationusa.state.gov/find-event/").get()
            val allinfo = doc.getElementsByClass("views-field views-field-title")
            val sums = doc.getElementsByClass("views-field views-field-field-summary")
            val dates = doc.getElementsByClass("field-event-date")
            //val eventType = doc.getElementsByClass("views-row views-row-1 views-row-odd views-row-first")
            val singleDate = doc.getElementsByClass("date-display-single")
            val location = doc.getElementsByClass("views-field views-field-field-event-in-person-location-country")
            val banners = doc.getElementsByClass("panel-pane pane-fieldable-panels-pane pane-fpid-219")

            //Allinfo loop, contains nested for loops.
            for(i in allinfo){
                val eTitle = i.getElementsByClass("field-content")
                    .select("h3")
                    .text()
                tlist.add(eTitle)

                //Image banner.
                for(i in banners) {
                    val image = i.getElementsByTag("img").attr("src")
                    imagelist.add(image)
                }//Allinfo.

                //Sums loop
                for(j in sums) {
                    val eSums = j.getElementsByClass("field-content")
                        .select("p")
                        .text()
                    slist.add(eSums)
                }//Sums.

                //Dates loop
                for(k in dates) {
                    val eDatesS = k.getElementsByClass("date-display-start")
                        .select("span")
                        .text()
                    val eDatesE = k.getElementsByClass("date-display-end")
                        .select("span")
                        .text()
                    dslist.add(eDatesS)
                    delist.add(eDatesE)
                }//Dates.

                //Single Dates loop
                for(k in singleDate) {
                    val eDatesS = k.getElementsByClass("date-display-single")
                        .text()
                    singleDatelist.add(eDatesS)
                }//Dates.

                //Location loop
                for(k in location) {
                    val elocation = k.getElementsByClass("views-label views-label-field-event-in-person-location-country")
                        .select("span")
                        .text()
                    val ecountry = k.getElementsByClass("field-content")
                        .select("span")
                        .text()
                    locationlist.add(elocation)
                    countrylist.add(ecountry)
                }//Location.

                //Event Type loop
                for(k in location) {
                    val eType = k.getElementsByClass("div")
                        .select("span")
                        .text()
                    val eOnline = k.getElementsByClass("div")
                        .select("span")
                        .text()
                    eventTypelist.add(eType)
                    eventOnlinelist.add(eOnline)
                }//Event Type.
            }//Allinfo.



            uiThread {

                //Banner
                Glide.with(this@Events).load(imagelist[0]).into(banner)

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