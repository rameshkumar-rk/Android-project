package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT=2000;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SQLiteDatabase mydatabase = openOrCreateDatabase("yoram",MODE_PRIVATE,null);
                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS login (userName VARCHAR PRIMARY KEY, password VARCHAR)");
                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS userDetails (firstName VARCHAR,lastName VARCHAR,aadharNumber VARCHAR PRIMARY KEY,phoneNumber VARCHAR,emailId VARCHAR)");

                cursor = mydatabase.query("sqlite_master",new String[]{"name"},"name=?",new String[]{"login"},null,null,null);
                if(cursor.getCount()==0) {
                    mydatabase.execSQL("INSERT INTO login VALUES('mugichan','mugilan')");
                }
                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Bus (bus_id Numeric PRIMARY KEY, _from VARCHAR, _to VARCHAR, fare NUMERIC,class VARCHAR)");
                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS train (train_id Numeric PRIMARY KEY, _from VARCHAR, _to VARCHAR, fare NUMERIC,class VARCHAR)");


                cursor = mydatabase.query("sqlite_master",new String[]{"name"},"name=?",new String[]{"Bus"},null,null,null);
                if(cursor.getCount()==0) {
                    mydatabase.execSQL("INSERT INTO Bus VALUES(1001,'virudhunagar','sivakasi',22,'seated')");
                    mydatabase.execSQL("INSERT INTO Bus VALUES(1002,'virudhunagar','madurai',70,'seated')");
                }

                cursor = mydatabase.query("sqlite_master",new String[]{"name"},"name=?",new String[]{"train"},null,null,null);
                if(cursor.getCount()==0) {
                    mydatabase.execSQL("INSERT INTO train VALUES(201,'visakhapatnam','chennai',500,'cc')");
                    mydatabase.execSQL("INSERT INTO train VALUES(202,'virudhunagar','madurai',70,'cc')");
                }



                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS passport_userDetails (passport_number VARCHAR PRIMARY KEY,name VARCHAR,validity VARCHAR,mailID VARCHAR)");
                cursor = mydatabase.query("sqlite_master",new String[]{"name"},"name=?",new String[]{"passport_userDetails"},null,null,null);
                //Toast.makeText(getApplicationContext()," "+cursor.getCount(),Toast.LENGTH_LONG).show();
                if(cursor.getCount()==0) {
                    //Toast.makeText(getApplicationContext(),"inside passport user details",Toast.LENGTH_LONG).show();
                    mydatabase.execSQL("INSERT INTO passport_userDetails VALUES('301a','rameshkumar','05-08-2020','rammsec@gmail.com')");
                    mydatabase.execSQL("INSERT INTO passport_userDetails VALUES('302b','viswa','08-08-2021','rviswa00@gmail.com')");
                }

                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS passport_travelDetails (passport_number VARCHAR,_from VARCHAR,_to VARCHAR,dt_of_journey VARCHAR)");
                cursor = mydatabase.query("sqlite_master",new String[]{"name"},"name=?",new String[]{"passport_travelDetails"},null,null,null);
                if(cursor.getCount()==0) {
                    mydatabase.execSQL("INSERT INTO passport_travelDetails VALUES('301a','Madurai','America','05-08-2019')");
                    mydatabase.execSQL("INSERT INTO passport_travelDetails VALUES('302b','Chennai','Australia','08-08-2018')");
                }

                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS lpgUserDetails (serviceNumber VARCHAR PRIMARY KEY,address VARCHAR,type VARCHAR)");
                cursor = mydatabase.query("sqlite_master",new String[]{"name"},"name=?",new String[]{"lpgUserDetails"},null,null,null);
                if(cursor.getCount()==0) {
                    mydatabase.execSQL("INSERT INTO lpgUserDetails VALUES('401','116D type 2 neyveli','household')");
                    mydatabase.execSQL("INSERT INTO lpgUserDetails VALUES('402','B/E cisf complex vizag','commercial')");
                }

                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS lpgBookingDetails (serviceNumber VARCHAR,addressOfBooking VARCHAR,dateOfBooking VARCHAR,quantity NUMERIC)");
                cursor = mydatabase.query("sqlite_master",new String[]{"name"},"name=?",new String[]{"lpgBookingDetails"},null,null,null);
                if(cursor.getCount()==0) {
                    mydatabase.execSQL("INSERT INTO lpgBookingDetails VALUES('401','116D type 2 neyveli','02/09/2019',1)");
                    mydatabase.execSQL("INSERT INTO lpgBookingDetails VALUES('402','B/E cisf complex vizag','02/08/2019',5)");
                }

                mydatabase.execSQL("CREATE TABLE IF NOT EXISTS bsnl (phoneNumber VARCHAR PRIMARY KEY,name VARCHAR,tarrif VARCHAR,balance VARCHAR, expiry VARCHAR)");
                cursor = mydatabase.query("sqlite_master",new String[]{"name"},"name=?",new String[]{"bsnl"},null,null,null);
                if(cursor.getCount()==0) {
                    mydatabase.execSQL("INSERT INTO bsnl VALUES('901','yogi','monthly','120','02/08/2019')");
                    mydatabase.execSQL("INSERT INTO bsnl VALUES('902','aksa','yearly','1200','02/08/2020')");
                }

                Intent i=new Intent(MainActivity.this,
                        Login.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}