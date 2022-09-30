package com.igaworks.dfn_sample_projectkotilin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.igaworks.v2.core.AdBrixRm

class DeeplinkActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This method must call for when app is re-start
        onNewIntent(this.intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        // This method must call for when intent has changed.
        setIntent(intent)

        AdBrixRm.deeplinkEvent(this)

        // Do View Landing from here


    }
}