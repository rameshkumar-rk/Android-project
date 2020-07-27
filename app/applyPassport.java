package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;


import android.os.Bundle;

public class applyPassport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_passport);


        String url = "https://onlinepassportapplications.in/?gclid=EAIaIQobChMIzcrc19_75AIVxzUrCh3OlwK2EAAYASAAEgIuzfD_BwE";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
