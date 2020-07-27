package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class enterOTP extends AppCompatActivity {

    Button submitOTP;
    EditText otp;
    EditText enterOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);

        submitOTP = (Button)findViewById(R.id.submitOtp);
        submitOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String gotp = intent.getStringExtra("otp");
                 enterOTP= (EditText)findViewById(R.id.enterOtp);
                String o = enterOTP.getText().toString();
                 if(o.equals(gotp))
                 {
                     Toast.makeText(getApplicationContext(),"OTP VERIFIED",Toast.LENGTH_LONG).show();
                     Intent i = new Intent(getApplicationContext(),changePassword.class);
                     String userName = intent.getStringExtra("userName");
                     i.putExtra("userName",userName);
                     startActivity(i);

                 }
                 else{
                     Toast.makeText(getApplicationContext(),"OTP WRONG",Toast.LENGTH_LONG).show();
                 }
            }
    });
}}
