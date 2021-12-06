@file:Suppress("NAME_SHADOWING")
package com.example.educationusa
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup

class Events : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        //Global valiables.
        val tlist = ArrayList<String>()
        val slist = ArrayList<String>()
        val eventTypelist = ArrayList<String>()
        val imagelist = ArrayList<String>()
        val imagelist1 = ArrayList<String>()

        //Section1 valiables.
        val banner = findViewById<ImageView>(R.id.banner1)
        val title1 = findViewById<TextView>(R.id.title1)
        val summary1 = findViewById<TextView>(R.id.summary1)
        val eType1 = findViewById<TextView>(R.id.eType1)
        //val im1 = findViewById<ImageView>(R.id.im1)

        //Section 2 valiables
        val title2 = findViewById<TextView>(R.id.title2)
        val summary2 = findViewById<TextView>(R.id.summary2)
        val eType2 = findViewById<TextView>(R.id.eType2)
        //val im2 = findViewById<ImageView>(R.id.im2)

        //Section 3 valiables
        val title3 = findViewById<TextView>(R.id.title3)
        val summary3 = findViewById<TextView>(R.id.summary3)
        val eType3 = findViewById<TextView>(R.id.eType3)
        //val im3 = findViewById<ImageView>(R.id.im3)

        //Section 4 valiables
        val title4 = findViewById<TextView>(R.id.title4)
        val summary4 = findViewById<TextView>(R.id.summary4)
        val eType4 = findViewById<TextView>(R.id.eType4)
        //val im4 = findViewById<ImageView>(R.id.im4)


        //Section 5 valiables
        val title5 = findViewById<TextView>(R.id.title5)
        val summary5 = findViewById<TextView>(R.id.summary5)
        val eType5 = findViewById<TextView>(R.id.eType5)
        //val im5 = findViewById<ImageView>(R.id.im5)


        //Section 6 valiables
        val title6 = findViewById<TextView>(R.id.title6)
        val summary6 = findViewById<TextView>(R.id.summary6)
        val eType6 = findViewById<TextView>(R.id.eType6)
        //val im6 = findViewById<ImageView>(R.id.im6)


        //Section 7 valiables
        val title7 = findViewById<TextView>(R.id.title7)
        val summary7 = findViewById<TextView>(R.id.summary7)
        val eType7 = findViewById<TextView>(R.id.eType7)
        //val im7 = findViewById<ImageView>(R.id.im7)


        //Section 8 valiables
        val title8 = findViewById<TextView>(R.id.title8)
        val summary8 = findViewById<TextView>(R.id.summary8)
        val eType8 = findViewById<TextView>(R.id.eType8)
        //val im8 = findViewById<ImageView>(R.id.im8)


        //Section 9 valiables
        val title9 = findViewById<TextView>(R.id.title9)
        val summary9 = findViewById<TextView>(R.id.summary9)
        val eType9 = findViewById<TextView>(R.id.eType9)
        //val im9 = findViewById<ImageView>(R.id.im9)


        //Section 10 valiables
        val title10 = findViewById<TextView>(R.id.title10)
        val summary10 = findViewById<TextView>(R.id.summary10)
        val eType10 = findViewById<TextView>(R.id.eType10)
        //val im10 = findViewById<ImageView>(R.id.im10)

        //Core Functionality.
        doAsync {
            //Containers to search for.
            val doc = Jsoup.connect("https://educationusa.state.gov/find-event/").get()
            val doc1 = Jsoup.connect("https://americancenterjapan.com/event/").get()
            val allinfo = doc1.getElementsByClass("clearfix")
            //System.out.println(allinfo1)
            val banners = doc.getElementsByClass("panel-pane pane-fieldable-panels-pane pane-fpid-219")

            //Allinfo loop, contains nested for loops.
            for(i in allinfo){
                val eTitle = i.getElementsByClass("eve-entry-box-i tn")
                    .select("h4").select("a")
                    .text()
                tlist.add(eTitle)

                val eType1 = i.getElementsByClass("eve-entry-box-i tn")
                    .select("p").select("span")
                    .text()
                eventTypelist.add(eType1)

                val eSums = i.getElementsByClass("eve-entry-box-i tn")
                    .select("p")
                    .text()
                slist.add(eSums)

                val image = i.getElementsByTag("img").attr("src")
                imagelist1.add(image)

                //Image banner.
                for(i in banners) {
                    val image = i.getElementsByTag("img").attr("src")
                    imagelist.add(image)
                }//Allinfo.
            }//Allinfo1.



            uiThread {

                //Banner
                Glide.with(this@Events).load(imagelist[0]).into(banner)
              /*Glide.with(this@Events).load(imagelist1[4]).override(200,200).centerCrop().into(im1)
                Glide.with(this@Events).load(imagelist1[5]).into(im2)
                Glide.with(this@Events).load(imagelist1[6]).into(im3)
                Glide.with(this@Events).load(imagelist1[7]).into(im4)
                Glide.with(this@Events).load(imagelist1[8]).into(im5)
                Glide.with(this@Events).load(imagelist1[9]).into(im6)
                Glide.with(this@Events).load(imagelist1[10]).into(im7)
                Glide.with(this@Events).load(imagelist1[11]).into(im8)
                Glide.with(this@Events).load(imagelist1[12]).into(im9)
                Glide.with(this@Events).load(imagelist1[13]).into(im10)*/

                //Panel 1.
                title1.text=tlist[4]
                summary1.text=slist[4]
                eType1.text=eventTypelist[4]

                //Panel 2.
                title2.text=tlist[5]
                summary2.text=slist[5]
                eType2.text=eventTypelist[5]

                //Panel3.
                title3.text=tlist[6]
                summary3.text=slist[6]
                eType3.text=eventTypelist[6]

                //Panel4.
                title4.text=tlist[7]
                summary4.text=slist[7]
                eType4.text=eventTypelist[7]

                //Panel5.
                title5.text=tlist[8]
                summary5.text=slist[8]
                eType5.text=eventTypelist[8]

                //Panel6.
                title6.text=tlist[9]
                summary6.text=slist[9]
                eType6.text=eventTypelist[9]

                //Panel7.
                title7.text=tlist[10]
                summary7.text=slist[10]
                eType7.text=eventTypelist[10]

                //Panel8.
                title8.text=tlist[11]
                summary8.text=slist[11]
                eType8.text=eventTypelist[11]

                //Panel9.
                title9.text=tlist[12]
                summary9.text=slist[12]
                eType9.text=eventTypelist[12]

                //Panel10.
                title10.text=tlist[13]
                summary10.text=slist[13]
                eType10.text=eventTypelist[13]
            }//UiThread.
        }//Async.
    }//On Create.
}//Class.