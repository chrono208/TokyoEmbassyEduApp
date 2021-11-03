package com.example.educationusa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup

class FAQ : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        val titleList = ArrayList<String>()
        val questionList = ArrayList<String>()
        val answerList = ArrayList<String>()

        val title1 = findViewById<TextView>(R.id.title1)
        val question1 = findViewById<TextView>(R.id.question1)
        val answer1 = findViewById<TextView>(R.id.answer1)

        doAsync {
            //Containers to search for.
            val doc = Jsoup.connect("https://educationusa.state.gov/experience-studying-usa/us-educational-system/frequently-asked-questions-faqs/").get()
            val allinfo = doc.getElementsByClass("panel-col-top full-width panel-panel")
            val questions = doc.getElementsByClass("panel-pane pane-entity-field pane-node-field-body")
            val answers = doc.getElementsByClass("panel-pane pane-entity-field pane-node-field-body")

            //Allinfo loop, contains nested for loops.
            for(i in allinfo) {
                val title = i.getElementsByClass("panel-pane pane-node-title")
                    .select("h1")
                    .text()
                titleList.add(title)

                //Question grabber.
                for(k in questions) {
                    val question = k.getElementsByClass("field-body text-area")
                        .select("strong")
                        .eq(1)
                        .text()
                    questionList.add(question)
                }//Questions.

                //Answer grabber.
                for(k in answers) {
                    val answer = k.getElementsByClass("field-body text-area")
                        .select("p")
                        .eq(1)
                        .text()
                    answerList.add(answer)
                }//Questions.
            }//Allinfo.

            uiThread {
                //Panel 1.
                title1.text=titleList[0]
                question1.text=questionList[0]
                answer1.text=answerList[0]
            }//UiThread.
        }//Async.

        //Sends to home page.
        val hButton = findViewById<Button>(R.id.hButton)
        hButton.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }//To Home.

        //Sends to faq page.
        val eveButton = findViewById<Button>(R.id.eveButton)
        eveButton.setOnClickListener{
            val intent2 = Intent(this, Events::class.java)
            startActivity(intent2)
        }//To Faq.

        //Sends to contacts page.
        val conButton = findViewById<Button>(R.id.conButton)
        conButton.setOnClickListener{
            val intent3 = Intent(this, Contacts::class.java)
            startActivity(intent3)
        }//To Contacts.
    }//OnCreate.
}//FAQ.