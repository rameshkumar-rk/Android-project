package com.example.yoram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.content.Intent;

public class menu_page extends AppCompatActivity {
    Button it,pf,lpg,passport,bus,railway,bsnl,chatbot,schemes;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        it = (Button) findViewById(R.id.it);
        pf = (Button) findViewById(R.id.pf);
         lpg= (Button) findViewById(R.id.lpg);
          passport= (Button) findViewById(R.id.passport);
         bus = (Button) findViewById(R.id.bus);
         railway = (Button) findViewById(R.id.railway);
          bsnl= (Button) findViewById(R.id.bsnl);
          chatbot = (Button) findViewById(R.id.chatBot);
          schemes = (Button) findViewById(R.id.scheme);

          it.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  i=new Intent(getApplicationContext(),it.class);
                  startActivity(i);
              }
          });

        pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),pf.class);
                startActivity(i);
            }
        });
        lpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),lpg.class);
                startActivity(i);
            }
        });
        passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),passport.class);
                startActivity(i);
            }
        });
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),bus.class);
                startActivity(i);
            }
        });
        railway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),railways.class);
                startActivity(i);
            }
        });

        bsnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),bsnl.class);
                startActivity(i);
            }
        });
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),chatBot.class);
                startActivity(i);
            }
        });

        schemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(getApplicationContext(),schemes.class);
                startActivity(i);
            }
        });








/*
        button = (Button) findViewById(R.id.exploree);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), button);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent i;
                        if(item.getTitle().equals("IT")){
                             i=new Intent(getApplicationContext(),it.class);
                             startActivity(i);
                            }
                        else if(item.getTitle().equals("PF")){
                            i=new Intent(getApplicationContext(),pf.class);
                            startActivity(i);
                        }
                        else if(item.getTitle().equals("LPG")){
                            i=new Intent(getApplicationContext(),lpg.class);
                            startActivity(i);
                        }
                        else if(item.getTitle().equals("Passport")){
                            i=new Intent(getApplicationContext(),passport.class);
                            startActivity(i);
                        }
                        else if(item.getTitle().equals("Bus")){
                            i=new Intent(getApplicationContext(),bus.class);
                            startActivity(i);
                        }
                        else if(item.getTitle().equals("Railways")){
                            i=new Intent(getApplicationContext(),railways.class);
                            startActivity(i);
                        }
                        else if(item.getTitle().equals("Bsnl")){
                            i=new Intent(getApplicationContext(),bsnl.class);
                            startActivity(i);
                        }
                        else if(item.getTitle().equals("CHATBOT")){
                            i=new Intent(getApplicationContext(),chatBot.class);
                            startActivity(i);
                        }
                        return true;
                    }
                });
                popup.show();


            }
        });
*/

    }
}