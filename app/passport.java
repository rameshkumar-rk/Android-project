package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class passport extends AppCompatActivity {
Button apply,query;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);
        apply=(Button)findViewById(R.id.apply);
        query=(Button)findViewById(R.id.query);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=new Intent(getApplicationContext(),applyPassport.class);
                startActivity(i);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=new Intent(getApplicationContext(),queryPassport.class);
                startActivity(i);
            }
        });
    }
}
