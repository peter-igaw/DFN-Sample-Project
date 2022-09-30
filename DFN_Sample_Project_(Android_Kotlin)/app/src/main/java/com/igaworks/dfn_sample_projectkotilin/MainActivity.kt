package com.igaworks.dfn_sample_projectkotilin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.igaworks.v2.core.AdBrixRm

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_1 = findViewById<Button>(R.id.button)
        button_1.setOnClickListener(View.OnClickListener {

            sampleEventWithAttr()

        })

        val button_2 = findViewById<Button>(R.id.button2)
        button_2.setOnClickListener(View.OnClickListener {

            samplesEvent()

        })
    }

    fun sampleEventWithAttr(){

        val eventAttr = AdBrixRm.AttrModel()
            .setAttrs("yourStringKey", "your_value")

        AdBrixRm.event("sampleEventWithAttr", eventAttr)

    }

    fun samplesEvent(){

        AdBrixRm.event("sampleEvent")

    }


}