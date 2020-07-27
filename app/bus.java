package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class bus extends AppCompatActivity {
EditText from, to;
TextView fareValue,fare;
String bus_class;
RadioGroup busClass;
Button getFare;
String frm,_to,classSelected;
int busClass_id;
SQLiteDatabase mydatabase;
Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        from=(EditText)findViewById(R.id.from);
        to=(EditText)findViewById(R.id.to);
        busClass = (RadioGroup)findViewById(R.id.busClass);
        fare=(TextView)findViewById(R.id.fare);
        fareValue = (TextView)findViewById(R.id.fareValue);
        mydatabase=openOrCreateDatabase("yoram",MODE_PRIVATE,null);;
        busClass.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                busClass_id= busClass.getCheckedRadioButtonId();
            }
        });
        getFare=(Button)findViewById(R.id.getFare);
        getFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(busClass_id==R.id.sleeperNonAC){
                    classSelected="sleeper non ac";
                }
                else if(busClass_id==R.id.semiSleeperAC){
                    classSelected="semi sleeper ac";
                }
                else if(busClass_id==R.id.seated){
                    classSelected="seated";
                }
                else if(busClass_id==R.id.sleeperAC2){
                    classSelected="sleeper ac 2";

                }
                else if(busClass_id==R.id.semiSleeperNonAC){
                    classSelected="sleeper non ac";
                }

                frm=from.getText().toString();
                _to=to.getText().toString();

                cursor = mydatabase.query("Bus",new String[]{"fare"},"_from=? and _to=? and class=?",new String[]{frm,_to,classSelected},null,null,null);

                if(cursor.getCount()!=0){
                    cursor.moveToFirst();
                    fareValue.setText(cursor.getString(0));

                }
            }
        });




    }
}
