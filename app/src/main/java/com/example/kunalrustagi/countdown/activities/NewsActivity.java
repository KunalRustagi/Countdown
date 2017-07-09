package com.example.kunalrustagi.countdown.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kunalrustagi.countdown.R;
import com.squareup.picasso.Picasso;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Log.e("NewsActivity","onCreate()");
        Intent i= getIntent();
        String title= i.getStringExtra("title");
        String urlToImage = i.getStringExtra("urlToImage");
        String description = i.getStringExtra("description");
        Picasso.with(this).load(urlToImage).into((ImageView)findViewById(R.id.tvimg));
        ((TextView)findViewById(R.id.tvdescription)).setText(description);
        ((TextView)findViewById(R.id.tvtitle)).setText(title);

    }
}
