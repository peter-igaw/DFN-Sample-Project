package com.igaworks.dfnsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.igaworks.v2.core.AdBrixRm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountCreatedStart();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountCreatedComplete();
            }
        });

    }


    void accountCreatedStart(){

        AdBrixRm.event("accountCreatedStart");

    }

    void accountCreatedComplete(){

        AdBrixRm.event("accountCreatedComplete");

    }
}