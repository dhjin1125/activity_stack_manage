package com.example.activitystackexample

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activitystackexample.ExampleApplication.Companion.loggingCurrentActivity

class Activity1 : AppCompatActivity() {

    private val textView: TextView by lazy {
        findViewById(R.id.myTv)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        loggingCurrentActivity("oncreate")

        textView.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
    }


    override fun onStart() {
        super.onStart()
        loggingCurrentActivity("onStart")
    }

    override fun onPause() {
        super.onPause()
        loggingCurrentActivity("onPause")
    }

    override fun onResume() {
        super.onResume()
        loggingCurrentActivity("onResume")
    }

    override fun onStop() {
        super.onStop()
        loggingCurrentActivity("onStop")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        loggingCurrentActivity("onNewIntent")
    }

    override fun onDestroy() {
        super.onDestroy()
        loggingCurrentActivity("onDestroy")
    }
}