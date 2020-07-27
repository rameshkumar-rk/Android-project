package com.example.yoram;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class schemes extends AppCompatActivity {
Button ayushmanBharat,PMAY,PMJDY,PMMY,PMUY,saubhagya,swachhBharat;
Intent i;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ayushmanBharat=(Button)findViewById(R.id.ayushmanBharat);
        PMAY=(Button)findViewById(R.id.PMAY);
        PMJDY=(Button)findViewById(R.id.PMJDY);
        PMMY=(Button)findViewById(R.id.PMMY);
        PMUY=(Button)findViewById(R.id.PMUY);
        saubhagya=(Button)findViewById(R.id.saubhagya);
        swachhBharat=(Button)findViewById(R.id.swachhBharat);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        ayushmanBharat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://web.umang.gov.in/UmangVersion2/UmangVersion2.jsp#/ayushman?GLOBAL_SERVICE_ID=943";
                startWebActivity(url,getApplicationContext());
                    }
        });

        PMAY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 url = "https://web.umang.gov.in/UmangVersion2/UmangVersion2.jsp#/pmay?GLOBAL_SERVICE_ID=946";
                startWebActivity(url,getApplicationContext());
                    }
        });
        PMJDY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 url = "https://web.umang.gov.in/UmangVersion2/UmangVersion2.jsp#/pmjdy?GLOBAL_SERVICE_ID=945";
                startWebActivity(url,getApplicationContext());
                     }
        });
        PMMY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 url = "https://web.umang.gov.in/UmangVersion2/UmangVersion2.jsp#/pmmy?GLOBAL_SERVICE_ID=942";
                startWebActivity(url,getApplicationContext());
                    }
        });
        PMUY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 url = "https://web.umang.gov.in/UmangVersion2/UmangVersion2.jsp#/pmuy?GLOBAL_SERVICE_ID=947";
                startWebActivity(url,getApplicationContext());
                    }
        });
       saubhagya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 url = "https://web.umang.gov.in/UmangVersion2/UmangVersion2.jsp#/saubhagya?GLOBAL_SERVICE_ID=941";
                startWebActivity(url,getApplicationContext());
                    }
        });
       swachhBharat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 url = "https://web.umang.gov.in/UmangVersion2/UmangVersion2.jsp#/swatchBharat?GLOBAL_SERVICE_ID=944";
                 startWebActivity(url,getApplicationContext());
                    }
        });
    }
    public void startWebActivity ( String url , Context context){
        Intent i = new Intent(context,display_schemes.class);
        i.putExtra("url",url);
        startActivity(i);

    }
}
