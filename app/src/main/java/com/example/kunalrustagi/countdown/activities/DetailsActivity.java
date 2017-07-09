package com.example.kunalrustagi.countdown.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kunalrustagi.countdown.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
       Intent i= getIntent();
        String title= i.getStringExtra("title");
        String urlToImage = i.getStringExtra("urlToImage");
        String description = i.getStringExtra("description");
        String date = i.getStringExtra("date");
        String url = i.getStringExtra("url");
        Picasso.with(this).load(urlToImage).into((ImageView)findViewById(R.id.img));
        ((TextView)findViewById(R.id.textdate)).setText(date);
        ((TextView)findViewById(R.id.textdescription)).setText(description);
        ((TextView)findViewById(R.id.tvurl)).setText(url);
        ((TextView)findViewById(R.id.texttitle)).setText(title);


    }
}
