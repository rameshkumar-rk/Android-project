package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
public class lpg extends AppCompatActivity {
    Button book,bookingHistory;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lpg);
        book=(Button)findViewById(R.id.book);
        bookingHistory=(Button)findViewById(R.id.bookingHistory);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=new Intent(getApplicationContext(),bookLpg.class);
                startActivity(i);
            }
        });
        bookingHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=new Intent(getApplicationContext(),bookingHistoryLpg.class);
                startActivity(i);
            }
        });
    }
}
