package com.example.madworld

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Tasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

//initialize the buttons
        //attach event listeners for each button
        //handle the event
        findViewById<Button>(R.id.button_task).setOnClickListener { gotoYTButton() }
    }
        private fun gotoYTButton() {
            val url = "http://www.google.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
