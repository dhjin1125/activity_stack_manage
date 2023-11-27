package com.example.activitystackexample

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class ExampleApplication : Application(), Application.ActivityLifecycleCallbacks {

    companion object {
        fun loggingCurrentActivity(log: String) {
            Log.d("ExampleApplication", "$activity $log")
        }

        @SuppressLint("StaticFieldLeak")
        var activity: Activity? = null

        var mActivityArr: ArrayList<Activity> = ArrayList()
    }


    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
    }

    private fun isActivityExistInStack(activity: Activity): Boolean {
        for (checkActivity in mActivityArr) {
            if (checkActivity === activity) {
                return true
            }
        }
        return false
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        // 현재 스택에 존재하지 않을 경우 add 시켜준다.
        ExampleApplication.activity = activity

        if (!isActivityExistInStack(activity)) {
            mActivityArr.add(activity)
        }
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
        ExampleApplication.activity = activity

        // 현재 액티비티 위치
        Log.d("TargetActivity", activity.javaClass.simpleName)

        loggingCurrentActivity(mActivityArr.toString())
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        if (isActivityExistInStack(activity)) {
            mActivityArr.remove(activity)
        }
    }
}