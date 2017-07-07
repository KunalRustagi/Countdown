package com.example.kunalrustagi.countdown.activities;

import android.content.Context;
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

import android.widget.TextView;

import com.example.kunalrustagi.countdown.R;
import com.example.kunalrustagi.countdown.adapters.TechEventsAdapter;
import com.example.kunalrustagi.countdown.adapters.TechMyEventsAdapter;
import com.example.kunalrustagi.countdown.adapters.TechNewsAdapter;
import com.example.kunalrustagi.countdown.api.TechAPI;
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

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager; public static ArrayList<TechEvents>events;public static ArrayList<TechEvents>event;


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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String PAGE_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(PAGE_NUMBER, sectionNumber);
            Log.e("In Frag Constuctor","Position " + sectionNumber);
            if(sectionNumber==3){
//                 if(event.size()>0) {
//                     args.putString("title", event.get(0).getTitle());
//                     args.putString("description", event.get(0).getDescription());
//                     args.putString("urlToImage", event.get(0).getUrlToImage());
//                     args.putString("date", event.get(0).getDate());
//                     args.putString("url", event.get(0).getUrl());
//                     event.clear();
                args.putSerializable("arraylist",(Serializable) event);
                Log.e("Bundle", "Serializable " +event );
//                 }
            }
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            int a = getArguments().getInt(PAGE_NUMBER);ArrayList<TechEvents>myevents=new ArrayList<TechEvents>();
            if(a==2){
                View itemView = inflater.inflate(R.layout.fragment_tech,container,false);
                RecyclerView rvtech = (RecyclerView)itemView.findViewById(R.id.rvtechnews);
                rvtech.setLayoutManager(new LinearLayoutManager(getContext()));
                final TechNewsAdapter techNewsAdapter = new TechNewsAdapter(getContext(),           //Why cant MainActivity.this be used here
                        new TechNews("","",new ArrayList<Articles>()));                             //Non-static cannot be referenced from a static context
                rvtech.setAdapter(techNewsAdapter);                                                 //How come it is static
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://newsapi.org/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                TechAPI techAPI = retrofit.create(TechAPI.class);
                techAPI.getTechNews().enqueue(new Callback<TechNews>() {
                    @Override
                    public void onResponse(Call<TechNews> call, Response<TechNews> response) {
                        Log.e("TECH","onResponse");
                        techNewsAdapter.updateTechNews(response.body());
                    }

                    @Override
                    public void onFailure(Call<TechNews> call, Throwable t) {
                        Log.d("TECH","onFailure");

                    }
                });
                Retrofit retrofit1 = new Retrofit.Builder()
                        .baseUrl("https://newsapi.org/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                TechAPI techAPI1 = retrofit1.create(TechAPI.class);
                techAPI1.getTechNews().enqueue(new Callback<TechNews>() {
                    @Override
                    public void onResponse(Call<TechNews> call, Response<TechNews> response) {
                       Log.e("TECH","onResponse");
                        techNewsAdapter.updateTechNews(response.body());
                    }

                    @Override
                    public void onFailure(Call<TechNews> call, Throwable t) {
                        Log.d("TECH","onFailure");

                    }
                });

                return itemView;

            }
            if(a==1){
              //  Log.e("Events","a=1");
                View itemView = inflater.inflate(R.layout.fragment_tech_events,container,false);
                RecyclerView rvevents=(RecyclerView)itemView.findViewById(R.id.rvevents);
                events=new ArrayList<TechEvents>();
                events.add(new TechEvents("India Hacks","IndiaHacks is the biggest confluence of developers across domains and interests under a single platform.It's your chance to demonstrate your programming skills, while competing with the best developers in the world.","https://hackerearth.global.ssl.fastly.net/static/hackerearth/images/indiahacks/2017/share_image.jpg","https://www.hackerearth.com/indiahacks-2017/","30-09-2017"));
                rvevents.setLayoutManager(new LinearLayoutManager(getContext()));
                TechEventsAdapter techEventsAdapter = new TechEventsAdapter(getContext(),events,myevents);
                rvevents.setAdapter(techEventsAdapter);
                event=techEventsAdapter.myEvents();
                Log.e("a=1","event " + event);
                return itemView;
            }
            if(a==3){
                Log.d("TECH","myevents :" + myevents);
                View itemView = inflater.inflate(R.layout.fragment_my_events,container,false);
                RecyclerView rvmyevents=(RecyclerView)itemView.findViewById(R.id.rvmyevents);
                rvmyevents.setLayoutManager(new LinearLayoutManager(getContext()));
//                ArrayList<TechEvents> tech = new ArrayList<TechEvents>();TechEvents techEvents;
//                if(getArguments().getString("title")!=null) {
//                    Log.e("Not Null","inNot null "+getArguments().getString("urlToImage"));
//                    techEvents = new TechEvents(getArguments().getString("title"), getArguments().getString("description"), getArguments().getString("urlToImage"), getArguments().getString("url"), getArguments().getString("date"));
//                    tech.add(techEvents);
//                    TechMyEventsAdapter techMyEventsAdapter=new TechMyEventsAdapter(getContext(),tech);
//                    rvmyevents.setAdapter(techMyEventsAdapter);
     //           }
                ArrayList<TechEvents> tech=(ArrayList<TechEvents>)getArguments().getSerializable("arraylist");
                Log.e("a=3","tech " + tech);
                TechMyEventsAdapter techMyEventsAdapter=new TechMyEventsAdapter(getContext(),tech);
                rvmyevents.setAdapter(techMyEventsAdapter);
               // techMyEventsAdapter.updateList((ArrayList<TechEvents>)getArguments().getSerializable("arraylist"));
                return itemView;
            }
            return inflater.inflate(R.layout.fragment_my_events,container,false);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Log.e("FragAdap","Fragment No :" + position+1);
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
