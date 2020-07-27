package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class it extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner yearOfAssessment,taxPayer,group,residentialStatus;
    List<String> yr,l_taxPayer,l_group,l_residentialStatus;
    EditText salary,otherIncome,deductions;
    Button calculate;
    int sal,otherInc,ded,totIncome;
    double taxAmt;
    TextView tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);
        yearOfAssessment = (Spinner) findViewById(R.id.yearOfAssessment);
        taxPayer=(Spinner)findViewById(R.id.taxPayer);
        group=(Spinner)findViewById(R.id.group);
        residentialStatus=(Spinner)findViewById(R.id.residentialStatus);
        salary=(EditText)findViewById(R.id.salary);
        otherIncome=(EditText)findViewById(R.id.otherIncome);
        deductions=(EditText)findViewById(R.id.deduction);
        calculate=(Button)findViewById(R.id.calculate);
        tax=(TextView)findViewById(R.id.taxAmt);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sal=Integer.parseInt(salary.getText().toString());
                otherInc=Integer.parseInt(otherIncome.getText().toString());
                ded=Integer.parseInt(deductions.getText().toString());
                totIncome=sal+otherInc;
                if(ded>200000)
                    ded=200000;
                totIncome-=ded;
                if(totIncome<500000)
                    taxAmt=totIncome*0.2;
                else if(totIncome<700000)
                    taxAmt=totIncome*0.3;
                else if(totIncome<800000)
                    taxAmt=totIncome*0.4;
                else
                    taxAmt=totIncome*0.45;

                tax.setText(String.valueOf(taxAmt));

            }
        });
        yr = new ArrayList<String>();
        yr.add("2020-21");
        yr.add("2019-2020");
        yr.add("2018-2019");
        yr.add("2017-2018");
        yr.add("2016-2017");
        yr.add("2015-2016");
        yr.add("2014-2015");
        yr.add("2013-2014");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yr);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearOfAssessment.setAdapter(dataAdapter);

        l_taxPayer = new ArrayList<String>();
        l_taxPayer.add("Individual");
        l_taxPayer.add("HUF");
        l_taxPayer.add("AOPs/BOI");
        l_taxPayer.add("Domestic Company");
        l_taxPayer.add("Foreign Company");
        l_taxPayer.add("Firms");
        l_taxPayer.add("LLP");
        l_taxPayer.add("CoOperative Society");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_taxPayer);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        taxPayer.setAdapter(dataAdapter2);

        l_group = new ArrayList<String>();
        l_group.add("Male");
        l_group.add("Female");
        l_group.add("Senior Citizen");
        l_group.add("Super Senior Citizen");
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_group);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        group.setAdapter(dataAdapter3);

        l_residentialStatus = new ArrayList<String>();
        l_residentialStatus.add("Resident");
        l_residentialStatus.add("Non Resident");
        l_residentialStatus.add("Not Ordinary Resident");
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_residentialStatus);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        residentialStatus.setAdapter(dataAdapter4);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()) {
            case R.id.yearOfAssessment:
                    String yr = parent.getItemAtPosition(position).toString();
                    break;
            case R.id.taxPayer:
                    String taxPayer=parent.getItemAtPosition(position).toString();
            case R.id.group:
                String group=parent.getItemAtPosition(position).toString();
            case R.id.residentialStatus:
                String martialStatus=parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

