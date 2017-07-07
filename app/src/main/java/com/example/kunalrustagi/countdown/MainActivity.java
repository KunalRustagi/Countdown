package com.example.kunalrustagi.countdown;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.kunalrustagi.countdown.activities.Tech;

public class MainActivity extends AppCompatActivity {
   LinearLayout tech,business,entertainment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tech =(LinearLayout)findViewById(R.id.tech);
        business=(LinearLayout)findViewById(R.id.business);
        entertainment=(LinearLayout)findViewById(R.id.entertainment);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cid = v.getId();
                switch (cid){
                    case R.id.tech :
                        Intent techIntent = new Intent(MainActivity.this,Tech.class);
                        startActivity(techIntent);
                        break;
                    case R.id.business:
                        Intent busIntent = new Intent(MainActivity.this,Tech.class); //bUSINESS ACTIVITY
                        startActivity(busIntent);
                        break;
                    case R.id.entertainment:
                        Intent entIntent = new Intent(MainActivity.this,Tech.class); //ENTERTAINMENT ACTIVITY
                        startActivity(entIntent);
                        break;
                }
            }
        };
        tech.setOnClickListener(clickListener);
        business.setOnClickListener(clickListener);
        entertainment.setOnClickListener(clickListener);

    }
}