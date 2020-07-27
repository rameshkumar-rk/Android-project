package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    Button signUp;
    EditText firstName, lastName, aadharNumber, emailId, phoneNumber, password, confirmPassword;
    ContentValues contentValues;
    SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUp = (Button)findViewById(R.id.signUp);
        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        aadharNumber = (EditText)findViewById(R.id.aadharNumber);
        emailId = (EditText)findViewById(R.id.emailID);
        phoneNumber = (EditText)findViewById(R.id.phoneNo);
        password = (EditText)findViewById(R.id.password);
        confirmPassword = (EditText)findViewById(R.id.confirmPassword);
        mydatabase = openOrCreateDatabase("yoram",MODE_PRIVATE,null);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String passwordValue = password.getText().toString();
                String confirmPasswordValue = confirmPassword.getText().toString();

                if(passwordValue.equals(confirmPasswordValue)) {
                    try {
                        contentValues = new ContentValues();
                        contentValues.put("firstName", firstName.getText().toString());
                        contentValues.put("lastName", lastName.getText().toString());
                        contentValues.put("aadharNumber", aadharNumber.getText().toString());
                        contentValues.put("phoneNumber", phoneNumber.getText().toString());
                        contentValues.put("emailId", emailId.getText().toString());

                        mydatabase.insert("userDetails", null, contentValues);

                        contentValues = new ContentValues();
                        contentValues.put("userName", emailId.getText().toString());
                        contentValues.put("password", passwordValue);
                        mydatabase.insert("login", null, contentValues);
                        Intent i = new Intent(getApplicationContext(), Login.class);
                        startActivity(i);
                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Account Already Exists",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Password does not Match",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
