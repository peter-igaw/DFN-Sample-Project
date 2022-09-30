package com.igaworks.dfnsampleproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.igaworks.v2.core.AdBrixRm;

public class DeeplinkActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // This method must call for when app is re-start
        onNewIntent(DeeplinkActivity.this.getIntent());

    }

    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);

        // This method must call for when intent has changed.
        setIntent(intent);

        AdBrixRm.deeplinkEvent(DeeplinkActivity.this);

        // Do View Landing from here

    }
}
