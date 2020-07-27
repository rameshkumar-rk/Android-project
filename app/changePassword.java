package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class changePassword extends AppCompatActivity {

    Button changePassword;
    EditText newPassword, confirmNewPassword;
    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        changePassword = (Button)findViewById(R.id.changePassword);
        newPassword = (EditText)findViewById(R.id.newPassword);
        confirmNewPassword = (EditText)findViewById(R.id.confirmNewPassword);
        mydatabase = openOrCreateDatabase("yoram",MODE_PRIVATE,null);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPasswordValue = newPassword.getText().toString();
                String confirmNewPasswordValue = confirmNewPassword.getText().toString();
                if(newPasswordValue.equals(confirmNewPasswordValue)){
                    String userName = getIntent().getStringExtra("userName");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("password",newPasswordValue);
                    if(mydatabase.update("login",contentValues,"userName=?",new String[]{userName})!=-1){
                        Intent i =new Intent(getApplicationContext(),Login.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Try Again Later", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Password Does Not Match",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
