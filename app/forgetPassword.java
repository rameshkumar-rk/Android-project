package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgetPassword extends AppCompatActivity {

    Button getOTP;
    EditText emailID;
    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        getOTP = (Button)findViewById(R.id.getOTP);
        emailID = (EditText)findViewById(R.id.emailID);

        getOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase mydatabase = openOrCreateDatabase("yoram",MODE_PRIVATE,null);
                Cursor cursor = mydatabase.query("userDetails",new String[]{"phoneNumber"},"emailId=?",new String[]{emailID.getText().toString()},null,null,null);
                cursor.moveToFirst();
                boolean flag = false;
                if(cursor.getCount()!=0){
                    String phoneNumber = cursor.getString(0).toString();
                    Toast.makeText(getApplicationContext(),phoneNumber,Toast.LENGTH_LONG).show();
                    int otp = (int)Math.floor(Math.random()*1000000);
                    SmsManager smgr = SmsManager.getDefault();
                    Toast.makeText(getApplicationContext(),""+otp,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),enterOTP.class);
                    i.putExtra("otp",""+otp);
                    i.putExtra("userName",emailID.getText().toString());
                    startActivity(i);
                    //smgr.sendTextMessage(phoneNumber,null,""+otp,null,null);
                    flag = true;

                }
                if(!flag){
                    Toast.makeText(getApplicationContext(),"No Account Found",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
