package com.example.kunalrustagi.countdown.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kunalrustagi.countdown.R;
import com.squareup.picasso.Picasso;

public class NewsActivity extends AppCompatActivity {
    WebView wvnews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Log.e("NewsActivity","onCreate()");
        Intent i= getIntent();
        String title= i.getStringExtra("title");
        String url = i.getStringExtra("url");
        String description = i.getStringExtra("description");
        wvnews =(WebView)findViewById(R.id.wvnews);
        wvnews.loadUrl(url);


    }
}
