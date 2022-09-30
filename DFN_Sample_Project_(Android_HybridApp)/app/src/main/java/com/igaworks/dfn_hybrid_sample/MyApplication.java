package com.igaworks.dfn_hybrid_sample;

import android.app.Application;

import com.igaworks.v2.core.application.AbxActivityHelper;
import com.igaworks.v2.core.application.AbxActivityLifecycleCallbacks;

public class MyApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        // Dfinery SDK init
        AbxActivityHelper.initializeSdk(getApplicationContext(), "W8qZ4hp63kSr9jv3GYk0lw", "kpVCEQcjwkauHVD2s3GD9Q");

        // Register ActivityLifeCycle
        registerActivityLifecycleCallbacks(new AbxActivityLifecycleCallbacks());

    }

}
