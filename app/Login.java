package com.example.yoram;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button signIn, signUp, forgetPassword;
    SQLiteDatabase mydatabase;
    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn = (Button)findViewById(R.id.signIn);
        signUp = (Button)findViewById(R.id.signUp);
        forgetPassword = (Button)findViewById(R.id.forgetPassword);

        userName = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameValue = userName.getText().toString();
                String passwordValue = password.getText().toString();
                boolean flag = false;
                Cursor cursor =  mydatabase.query("login",new String[]{"password"},"userName=?",new String[]{userNameValue},null,null,null);
                cursor.moveToFirst();
                if(cursor.getCount()!=0){

                    if(cursor.getString(0).equals(passwordValue)){
                        //Toast.makeText(getApplicationContext(),"Successfullly loged in",Toast.LENGTH_LONG).show();
                        flag = true;
                        Intent i = new Intent(getApplicationContext(),menu_page.class);
                        startActivity(i);
                    }
                }
                if(!flag){
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),signUp.class);
                startActivity(i);
            }
        });
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),forgetPassword.class);
                startActivity(i);
            }
        });
        mydatabase = openOrCreateDatabase("yoram",MODE_PRIVATE,null);

    }

}
