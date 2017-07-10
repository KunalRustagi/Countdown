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

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kunalrustagi.countdown.FragmentEvent;
import com.example.kunalrustagi.countdown.R;
import com.example.kunalrustagi.countdown.adapters.EntertainmentAdapter;
import com.example.kunalrustagi.countdown.adapters.MoviesAdapter;
import com.example.kunalrustagi.countdown.adapters.TechMyEventsAdapter;
import com.example.kunalrustagi.countdown.api.EntertainmentAPI;
import com.example.kunalrustagi.countdown.api.EntertainmentSearchAPI;
import com.example.kunalrustagi.countdown.interfaces.OnViewClickListener;
import com.example.kunalrustagi.countdown.models.Articles;
import com.example.kunalrustagi.countdown.models.Results;
import com.example.kunalrustagi.countdown.models.Search;
import com.example.kunalrustagi.countdown.models.TechNews;
import com.example.kunalrustagi.countdown.models.Url;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Entertainment extends AppCompatActivity {

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
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);

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
        getMenuInflater().inflate(R.menu.menu_entertainment, menu);
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
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int a = getArguments().getInt(PAGE_NUMBER);
            if(a==2){
                View itemView = inflater.inflate(R.layout.activity_entertainment_news,container,false);
                RecyclerView rventertainmentnews = (RecyclerView)itemView.findViewById(R.id.rventnews);
                final ProgressBar progbar = (ProgressBar)itemView.findViewById(R.id.progbar);
                progbar.setVisibility(View.VISIBLE);
                rventertainmentnews.setLayoutManager(new LinearLayoutManager(getContext()));
                final EntertainmentAdapter entertainmentAdapter = new EntertainmentAdapter(getContext(),
                        new TechNews("", "", new ArrayList<Articles>()),
                        new OnViewClickListener() {
                            @Override
                            public void onViewClick(Articles articles) {
                                Intent newsintent = new Intent(getContext(),NewsActivity.class);
                                newsintent.putExtra("urlToImage",articles.getUrlToImage());
                                newsintent.putExtra("title",articles.getTitle());
                                newsintent.putExtra("description",articles.getDescription());
                                newsintent.putExtra("url",articles.getUrl());
                                startActivity(newsintent);
                            }
                        });
                rventertainmentnews.setAdapter(entertainmentAdapter);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://newsapi.org/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                EntertainmentAPI entertainmentAPI =retrofit.create(EntertainmentAPI.class);
                entertainmentAPI.getEntertainmentNews().enqueue(new Callback<TechNews>() {
                    @Override
                    public void onResponse(Call<TechNews> call, Response<TechNews> response) {
                        entertainmentAdapter.updateTechNews(response.body(),progbar);
                    }

                    @Override
                    public void onFailure(Call<TechNews> call, Throwable t) {

                    }
                });
                return itemView;

            }
            if(a==4){

                View itemView = inflater.inflate(R.layout.fragment_my_events,container,false);
                RecyclerView rvmyevents=(RecyclerView)itemView.findViewById(R.id.rvmyevents);
                rvmyevents.setLayoutManager(new LinearLayoutManager(getContext()));

                TechMyEventsAdapter techMyEventsAdapter=new TechMyEventsAdapter(getContext(), FragmentEvent.setArg());
                rvmyevents.setAdapter(techMyEventsAdapter);
                return itemView;
            }
            if(a==3){
                  final String api_key = "cb29858d906bc704868ff43200a96d0e";
                View itemView = inflater.inflate(R.layout.layout_movies,container,false);
                RecyclerView rventertainment = (RecyclerView)itemView.findViewById(R.id.rvmovies);
                final ProgressBar progressBar =(ProgressBar)itemView.findViewById(R.id.progbar);
                progressBar.setVisibility(View.INVISIBLE);
                final EditText etsearch=(EditText)itemView.findViewById(R.id.etquery);
                TextView go = (TextView)itemView.findViewById(R.id.gobtn);
                rventertainment.setLayoutManager(new LinearLayoutManager(getContext()));
                final MoviesAdapter moviesAdapter = new MoviesAdapter(getContext(),new Search(0,0,new ArrayList<Results>()));
                rventertainment.setAdapter(moviesAdapter);
                Retrofit retrofit1 = new Retrofit.Builder()
                                .baseUrl("https://api.themoviedb.org/3/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        EntertainmentSearchAPI searchAPI = retrofit1.create(EntertainmentSearchAPI.class);
                        searchAPI.getCompleteUrl(api_key).enqueue(new Callback<Url>() {
                            @Override
                            public void onResponse(Call<Url> call, Response<Url> response) {
                                MoviesAdapter.urlupdated(response.body());
                                Log.e("MoviesAdapter","OnResponse URL" + response.body());
                                moviesAdapter.urlupdated(response.body());

                            }

                            @Override
                            public void onFailure(Call<Url> call, Throwable t) {

                            }
                        });
              final    Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://api.themoviedb.org/3/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                final EntertainmentSearchAPI entertainmentSearchAPI = retrofit.create(EntertainmentSearchAPI.class);
                go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String query = etsearch.getText().toString();
                        etsearch.setText("");
                        progressBar.setVisibility(View.VISIBLE);
                        entertainmentSearchAPI.getResults(api_key,query).enqueue(new Callback<Search>() {
                            @Override
                            public void onResponse(Call<Search> call, Response<Search> response) {
                                moviesAdapter.updateList(response.body(),progressBar);
                                Log.e("MOVIE API","OnResponse"+response.body());

                            }

                            @Override
                            public void onFailure(Call<Search> call, Throwable t) {
                                     Log.e("MOVIE","OnFailure");
                            }
                        });
                    }
                });
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
            if(position==0){
                return FragmentEvent.newInstance(position+1,3);
            }
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "UPCOMING";
                case 1:
                    return "NEWS";
                case 2:
                    return "MOVIES";
                case 3:
                    return "MY EVENTS";
            }
            return null;
        }
    }
}
