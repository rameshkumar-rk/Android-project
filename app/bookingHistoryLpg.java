package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

public class bookingHistoryLpg extends AppCompatActivity {
Button getBookingHistory;
EditText serviceNumber;
String t_serviceNumber;
Cursor cursor;
TextView resultData;
    SQLiteDatabase mydatabase ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history_lpg);
        serviceNumber=(EditText)findViewById(R.id.serviceNumber);
        resultData=(TextView)findViewById(R.id.resultData);
        getBookingHistory=(Button)findViewById(R.id.getBookingHistory);
        mydatabase = openOrCreateDatabase("yoram",MODE_PRIVATE,null);
        getBookingHistory.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
             t_serviceNumber=serviceNumber.getText().toString();
                cursor = mydatabase.query("lpgBookingDetails",new String[]{"serviceNumber","addressOfBooking","dateOfBooking","quantity"},"serviceNumber=?",new String[]{t_serviceNumber},null,null,null);
                String resultDataValue = "";
                if(cursor.getCount()!=0){
                    int n = cursor.getCount();
                    resultDataValue +="ServiceNumber , Address , Date , Quantity "+"\n";
                    //Toast.makeText(getApplicationContext(),"inside if"+cursor.getCount(),Toast.LENGTH_LONG).show();
                    cursor.moveToFirst();
                    for (int i=0;i<n;i++){
                        //Toast.makeText(getApplicationContext(),"inside while",Toast.LENGTH_LONG).show();
                        resultDataValue += cursor.getString(0) + " , " + cursor.getString(1) + " , " + cursor.getString(2) + " , " + cursor.getString(3) + "\n";
                        cursor.moveToNext();
                    }
                    cursor.close();
                    resultData.setText(resultDataValue);
                }
            }
        });
    }
}
