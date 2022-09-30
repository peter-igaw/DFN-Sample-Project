package com.igaworks.dfn_sample_projectkotilin

import android.app.Application
import com.igaworks.v2.core.application.AbxActivityHelper
import com.igaworks.v2.core.application.AbxActivityLifecycleCallbacks

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // DFN SDK init
        AbxActivityHelper.initializeSdk(this, "your_appkey", "your_secretkey")

        // Add Activity LifeCycle (Required)
        registerActivityLifecycleCallbacks(AbxActivityLifecycleCallbacks())

    }
}