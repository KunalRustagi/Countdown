package com.example.kunalrustagi.countdown.activities;

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

import com.example.kunalrustagi.countdown.FragmentEvent;
import com.example.kunalrustagi.countdown.R;
import com.example.kunalrustagi.countdown.adapters.TechMyEventsAdapter;
import com.example.kunalrustagi.countdown.adapters.TechNewsAdapter;
import com.example.kunalrustagi.countdown.api.BusinessAPI;
import com.example.kunalrustagi.countdown.interfaces.OnViewClickListener;
import com.example.kunalrustagi.countdown.models.Articles;
import com.example.kunalrustagi.countdown.models.TechNews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Business extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_business, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {

        private static final String PAGE_NUMBER  = "section_number";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(PAGE_NUMBER , sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int a = getArguments().getInt(PAGE_NUMBER);
            if(a==2){
                View itemView = inflater.inflate(R.layout.fragment_tech,container,false);
                RecyclerView rvtech = (RecyclerView)itemView.findViewById(R.id.rvtechnews);
                final ProgressBar progbar = (ProgressBar)itemView.findViewById(R.id.progbar);
                progbar.setVisibility(View.VISIBLE);
                rvtech.setLayoutManager(new LinearLayoutManager(getContext()));
                final TechNewsAdapter techNewsAdapter = new TechNewsAdapter(getContext(),           //Why cant MainActivity.this be used here
                        new TechNews("", "", new ArrayList<Articles>()), new OnViewClickListener() {
                    @Override
                    public void onViewClick(Articles articles) {
                        Intent newsintent = new Intent(getContext(),NewsActivity.class);
                        newsintent.putExtra("url",articles.getUrl());
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
                BusinessAPI techAPI = retrofit.create(BusinessAPI.class);
                techAPI.getTechNews().enqueue(new Callback<TechNews>() {
                    @Override
                    public void onResponse(Call<TechNews> call, Response<TechNews> response) {
                        Log.e("Business","onResponse"+response.body());
                        techNewsAdapter.updateTechNews(response.body(),progbar);
                    }

                    @Override
                    public void onFailure(Call<TechNews> call, Throwable t) {
                        Log.e("Business","onFailure");

                    }
                });
                return itemView;
        }
        if(a==3){
            View itemView = inflater.inflate(R.layout.fragment_my_events,container,false);
            RecyclerView rvmyevents=(RecyclerView)itemView.findViewById(R.id.rvmyevents);
            rvmyevents.setLayoutManager(new LinearLayoutManager(getContext()));

            TechMyEventsAdapter techMyEventsAdapter=new TechMyEventsAdapter(getContext(), FragmentEvent.setArg());
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

            if(position==0){
                return FragmentEvent.newInstance(position+1,2);
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
                    return "NEWS";
                case 2:
                    return "MY EVENTS";
            }
            return null;
        }
    }
}
