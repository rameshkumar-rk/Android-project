package com.example.yoram;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class railways extends AppCompatActivity {
    EditText from, to;
    TextView fareValue;
    String train_class;
    RadioGroup trainClass;
    Button getFare;
    String frm,_to,classSelected;
    int trainClass_id;
    SQLiteDatabase mydatabase;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_railways);
        from=(EditText)findViewById(R.id.fromTrain);
        to=(EditText)findViewById(R.id.toTrain);
        trainClass = (RadioGroup)findViewById(R.id.trainClass);
        mydatabase=openOrCreateDatabase("yoram",MODE_PRIVATE,null);;
        fareValue = (TextView)findViewById(R.id.fareValue);
        trainClass.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                trainClass_id= trainClass.getCheckedRadioButtonId();
            }
        });
        getFare=(Button)findViewById(R.id.getFareTrain);
        getFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(trainClass_id==R.id.twoAC){
                    classSelected="twoAC";
                }
                else if(trainClass_id==R.id.threeAC){
                    classSelected="threeAC";
                }
                else if(trainClass_id==R.id.sl){
                    classSelected="sl";
                }
                else if(trainClass_id==R.id.cc){
                    classSelected="cc";

                }

                frm=from.getText().toString();
                _to=to.getText().toString();

                cursor = mydatabase.query("train",new String[]{"fare"},"_from=? and _to=? and class=?",new String[]{frm,_to,classSelected},null,null,null);
                if(cursor.getCount()!=0){
                    cursor.moveToFirst();
                    fareValue.setText(cursor.getString(0));
                }
            }
        });

    }

}
