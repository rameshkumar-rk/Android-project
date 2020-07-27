package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pf extends AppCompatActivity {
EditText age,retirementAge,salary,urContribution,employersContribution,currentBalance;
Button calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pf);
        age=(EditText)findViewById(R.id.presentAge);
        retirementAge=(EditText)findViewById(R.id.retirementAge);
        salary=(EditText)findViewById(R.id.basicSalary);
        urContribution=(EditText)findViewById(R.id.urContribution);
        employersContribution=(EditText)findViewById(R.id.employersContribution);
       currentBalance=(EditText)findViewById(R.id.currentBalance);
       calc=(Button)findViewById(R.id.calculate);
       calc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });


    }
}
