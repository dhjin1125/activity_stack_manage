package com.example.activitystackexample

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activitystackexample.ExampleApplication.Companion.loggingCurrentActivity

class Activity2 : AppCompatActivity() {

    private val textView: TextView by lazy {
        findViewById(R.id.tvMain)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loggingCurrentActivity("oncreate")
        setContentView(R.layout.activity_2)

        textView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            /**
             * 수행 시, A->B->C->D->A로 가는 경우 BCD는 삭제 되고 기존의 A가 재사용 된다. 주소가 같음.
             */
            // 이때만 newIntent가 실행되네?
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)

            /**
             * 단독으로 수행 시, A->B->C->D->A로 가는 경우 ABCD는 삭제 되고 새로운 A가 생성된다. 주소가 다름.
             */
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

            /**
             * 새로운 테스크에 새로운 인스턴스 생성 Activity 주소가 다르다.
             */
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

            /**
             * onNewIntent를 탈지, onCreate를 탈지는 Intent Flag에 따라 다르다.
             */
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
}