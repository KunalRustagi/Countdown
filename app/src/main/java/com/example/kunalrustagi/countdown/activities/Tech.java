package com.example.kunalrustagi.countdown.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ProgressBar;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.example.kunalrustagi.countdown.FragmentEvent;
import com.example.kunalrustagi.countdown.R;
import com.example.kunalrustagi.countdown.adapters.TechEventsAdapter;
import com.example.kunalrustagi.countdown.adapters.TechMyEventsAdapter;
import com.example.kunalrustagi.countdown.adapters.TechNewsAdapter;
import com.example.kunalrustagi.countdown.api.BusinessAPI;
import com.example.kunalrustagi.countdown.api.TechAPI;
import com.example.kunalrustagi.countdown.interfaces.OnViewClickListener;
import com.example.kunalrustagi.countdown.models.Articles;
import com.example.kunalrustagi.countdown.models.TechEvent;
import com.example.kunalrustagi.countdown.models.TechEvents;
import com.example.kunalrustagi.countdown.models.TechNews;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Tech extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setPageTransformer(true, new FlipHorizontalTransformer());

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tech, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {

        private static final String PAGE_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(PAGE_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            int a = getArguments().getInt(PAGE_NUMBER);

            if(a==2){
                final View itemView = inflater.inflate(R.layout.fragment_tech,container,false);
                RecyclerView rvtech = (RecyclerView)itemView.findViewById(R.id.rvtechnews);
                rvtech.setLayoutManager(new LinearLayoutManager(getContext()));
                final TechNewsAdapter techNewsAdapter = new TechNewsAdapter(getContext(),           //Why cant MainActivity.this be used here
                        new TechNews("", "", new ArrayList<Articles>()), new OnViewClickListener() {
                    @Override
                    public void onViewClick(Articles articles) {
                        Intent newsintent = new Intent(getContext(),NewsActivity.class);
                        newsintent.putExtra("urlToImage",articles.getUrlToImage());
                        newsintent.putExtra("title",articles.getTitle());
                        newsintent.putExtra("description",articles.getDescription());
                        startActivity(newsintent);

                    }
                });                             //Non-static cannot be referenced from a static context
                rvtech.setAdapter(techNewsAdapter);                                                 //How come it is static
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://newsapi.org/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                TechAPI techAPI = retrofit.create(TechAPI.class);
                techAPI.getTechNews().enqueue(new Callback<TechNews>() {
                    @Override
                    public void onResponse(Call<TechNews> call, Response<TechNews> response) {
                        Log.e("OnResponse","TechNews " + response.body());
                        techNewsAdapter.updateTechNews(response.body(),(ProgressBar) itemView.findViewById(R.id.progbar));
                    }

                    @Override
                    public void onFailure(Call<TechNews> call, Throwable t) {


                    }
                });
                return itemView;
            }

            if(a==3){

                View itemView = inflater.inflate(R.layout.fragment_my_events,container,false);
                RecyclerView rvmyevents=(RecyclerView)itemView.findViewById(R.id.rvmyevents);
                rvmyevents.setLayoutManager(new LinearLayoutManager(getContext()));
                
                TechMyEventsAdapter techMyEventsAdapter=new TechMyEventsAdapter(getContext(),FragmentEvent.setArg());
                rvmyevents.setAdapter(techMyEventsAdapter);
                return itemView;
            }
            return inflater.inflate(R.layout.fragment_my_events,container,false);
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position==0){
                return FragmentEvent.newInstance(position+1,1);
            }

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "UPCOMING";
                case 1:
                    return "TECH NEWS";
                case 2:
                    return "MY EVENTS";
            }
            return null;
        }
    }
}
