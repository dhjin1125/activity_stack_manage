package com.example.activitystackexample

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activitystackexample.ExampleApplication.Companion.loggingCurrentActivity

class MainActivity : AppCompatActivity() {

    private val textView: TextView by lazy {
        findViewById(R.id.tvText)
    }

    private val checkStackActivity: TextView by lazy {
        findViewById(R.id.tvCurrentStackActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        loggingCurrentActivity("oncreate")


        textView.setOnClickListener {
            val intent = Intent(this, Activity1::class.java)
            startActivity(intent)
        }

        checkStackActivity.setOnClickListener {
            loggingCurrentActivity("Current Stack Activity : ${ExampleApplication.mActivityArr}")
        }
    }

    override fun onStart() {
        super.onStart()
        loggingCurrentActivity("onStart")
    }

    override fun onResume() {
        super.onResume()
        loggingCurrentActivity("onResume")
    }

    override fun onStop() {
        super.onStop()
        loggingCurrentActivity("onStop")
    }

    override fun onPause() {
        super.onPause()
        loggingCurrentActivity("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        loggingCurrentActivity("onDestroy")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        loggingCurrentActivity("onNewIntent")
    }
}