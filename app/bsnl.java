package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bsnl extends AppCompatActivity {
Button viewBalance,viewTarrif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsnl);
    viewBalance=(Button)findViewById(R.id.viewBalance);
    viewTarrif=(Button)findViewById(R.id.viewTariif);
    viewBalance.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
    viewTarrif.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
    }
}
