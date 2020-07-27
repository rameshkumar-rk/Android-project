package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class bookLpg extends AppCompatActivity {
    DatePickerDialog picker;
    Button pickDate;
    TextView dateOfBooking;
EditText serviceNumber,address,quantity;
 Button book;
 SQLiteDatabase mydatabase ;
String t_serviceNumber,t_address,t_dateOfBooking;
int t_quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lpg);
        serviceNumber=(EditText)findViewById(R.id.serviceNumber);
        address=(EditText)findViewById(R.id.address);
        quantity=(EditText)findViewById(R.id.quantity);
        dateOfBooking=(TextView) findViewById(R.id.dateOfBooking);
        pickDate = (Button)findViewById(R.id.pickDate);
        mydatabase = openOrCreateDatabase("yoram",MODE_PRIVATE,null);
        book=(Button)findViewById(R.id.book);
        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(bookLpg.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                t_dateOfBooking = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                dateOfBooking.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t_serviceNumber=serviceNumber.getText().toString();
                t_address=address.getText().toString();
                t_dateOfBooking=dateOfBooking.getText().toString();
                t_quantity=Integer.parseInt(quantity.getText().toString());
                ContentValues contentValues = new ContentValues();
                contentValues.put("serviceNumber",t_serviceNumber);
                contentValues.put("addressOfBooking",t_address);
                contentValues.put("dateOfBooking",t_dateOfBooking);
                contentValues.put("quantity",t_quantity);
                mydatabase.insert("lpgBookingDetails",null,contentValues);
                //mydatabase.execSQL("INSERT INTO lpgBookingDetails VALUES(t_serviceNumber,t_address,t_dateOfBooking,t_quantity)");
                Intent i =new Intent(getApplicationContext(),lpg.class);
                startActivity(i);
            }
        });
    }
}
