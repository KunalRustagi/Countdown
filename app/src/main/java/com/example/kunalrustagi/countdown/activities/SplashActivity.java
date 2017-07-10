package com.example.kunalrustagi.countdown.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.kunalrustagi.countdown.MainActivity;
import com.example.kunalrustagi.countdown.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        ((ProgressBar)findViewById(R.id.progbar)).setVisibility(View.VISIBLE);
        Handler h = new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Intent mainintent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainintent);
                finish();
            }
        };
        h.postDelayed(runnable,450);
    }
}
