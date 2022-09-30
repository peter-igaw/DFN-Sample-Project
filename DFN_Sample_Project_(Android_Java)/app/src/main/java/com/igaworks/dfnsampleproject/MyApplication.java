package com.igaworks.dfnsampleproject;

import android.app.Application;

import com.igaworks.v2.core.application.AbxActivityHelper;
import com.igaworks.v2.core.application.AbxActivityLifecycleCallbacks;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // DFN SDK init
        AbxActivityHelper.initializeSdk(this, "your_appkey", "your_secretkey");

        // Add Activity LifeCycle (Required)
        registerActivityLifecycleCallbacks(new AbxActivityLifecycleCallbacks());

    }
}
