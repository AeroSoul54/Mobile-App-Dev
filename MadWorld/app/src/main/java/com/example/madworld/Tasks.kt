package com.example.madworld

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class Tasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        //initialize the buttons
        //attach event listeners for each button
        //handle the event
        findViewById<Button>(R.id.button_task).setOnClickListener { googleButton() }
        findViewById<Button>(R.id.button_task1).setOnClickListener { ytButton() }
        findViewById<Button>(R.id.button_task2).setOnClickListener { mapButton() }
        findViewById<Button>(R.id.button_task3).setOnClickListener { tfsButton() }
        findViewById<Button>(R.id.button_task4).setOnClickListener { tfsbutton2() }
    }

    // NO DIAL FUNCTION, NO OPEN CONTACTS FUNCTION AND NO EMAIL FUNCTION
    //Task 1 - Go To the Default search engine and automatic google search
    private fun googleButton() {
        val url = "http://www.google.com"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    //Task 2 - Go to a shameless plug on a YT Channel
    private fun ytButton() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data =
            Uri.parse("https://www.youtube.com/channel/UC61SLs8bJSEWQUgYXLTrCYA?view_as=subscriber")
        intent.setPackage("com.google.android.youtube")
        startActivity(intent)
    }

    //Task 3 - Go to the Google Maps App
    private fun mapButton() {
        val gmmIntentUri = Uri.parse("geo:0,0?q=")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)

    }

    //Task 4 - Open Youtube
    private fun tfsButton() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setPackage("com.google.android.youtube")
        val manager = packageManager
        val info = manager.queryIntentActivities(intent, 0)
        if (info.size > 0) {
            startActivity(intent)
        } else {
            //Intent failed due to missing lines of code
            //GRACEFUL HANDLING ON AN ERROR IS THIS ENTIRE TOAST CODE
            val toast = Toast.makeText(
                applicationContext,
                "The code is missing values, thus not opening the actual Youtube App Installed on the phone",
                Toast.LENGTH_LONG
            )
            toast.show()
        }
    }

    //Task 5 - No Application Installed
    private fun tfsbutton2() {
        if(isMessengerInstalled()){
            val intent4 = packageManager.getLaunchIntentForPackage("com.viber.voip")
            startActivity(intent4)
        } else {
            //Intent failed due to not having the application installed
            //GRACEFUL HANDLING ON AN ERROR IS THIS ENTIRE TOAST CODE
            val toast = Toast.makeText(
                applicationContext,
                "Error: Messenger is not installed",
                Toast.LENGTH_LONG
            )
            toast.show()
        }
    }

    private fun isMessengerInstalled(): Boolean {
        return try {
            applicationContext.packageManager.getApplicationInfo("com.viber.voip", 0)
            true
        } catch (e: PackageManager.NameNotFoundException){
            false
        }
    }
}

