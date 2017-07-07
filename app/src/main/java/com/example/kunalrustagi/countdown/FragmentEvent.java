package com.example.kunalrustagi.countdown;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kunalrustagi.countdown.activities.Tech;
import com.example.kunalrustagi.countdown.adapters.TechEventsAdapter;
import com.example.kunalrustagi.countdown.models.TechEvent;
import com.example.kunalrustagi.countdown.models.TechEvents;

import java.util.ArrayList;

import static com.example.kunalrustagi.countdown.activities.Tech.events;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEvent#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEvent extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static ArrayList<TechEvents>tech; private static int a;private static ArrayList<TechEvents>techfinal = new ArrayList<>();
    private static ArrayList<TechEvents>techfinal1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentEvent() {
        // Required empty public constructor
    }
    public static void getArg(ArrayList<TechEvents>techno,int n){
        tech=techno; tech.addAll(techfinal);
        techfinal=techno;
      //  for(int i = 1;i<techno.size();i++){

     //   }
        a=n;
    }
    public static  ArrayList<TechEvents> setArg(){
        if(a==1){
            return tech;
        }
        return new ArrayList<TechEvents>();
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
  //   * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEvent.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEvent newInstance(int param1) {
        FragmentEvent fragment = new FragmentEvent();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
      //  args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<TechEvents> events;ArrayList<TechEvents>myevents=new ArrayList<TechEvents>();
        View itemView = inflater.inflate(R.layout.fragment_tech_events,container,false);
        RecyclerView rvevents=(RecyclerView)itemView.findViewById(R.id.rvevents);
        events=new ArrayList<TechEvents>();
        events.add(new TechEvents("India Hacks","IndiaHacks is the biggest confluence of developers across domains and interests under a single platform.It's your chance to demonstrate your programming skills, while competing with the best developers in the world.","https://hackerearth.global.ssl.fastly.net/static/hackerearth/images/indiahacks/2017/share_image.jpg","https://www.hackerearth.com/indiahacks-2017/","30-09-2017"));
        events.add(new TechEvents("Smart India Hackathon","Smart India Hackathon 2017 is a pan India 36 hour nonstop digital programming competition. The participating teams will simultaneously compete from across 33 locations in India to offer digital yet sustainable innovative solutions to solve real time challenges faced by the nation. It will harness the creativity of millions of bright young minds like you.","https://dkzstslcvgwbc.cloudfront.net/sites/default/files/pages/cover_image/sih2017-home.jpg",
                "https://innovate.mygov.in/sih2017/","28-07-2017"));
        events.add(new TechEvents("Interview Prep Bootcamp","Tone up your programming and interviewing skills with the fast-paced course, designed to help students in preparing for interviews in software companies. Lectures on all important topics as Operating Systems, DBMS and System Design, resume building to get shortlisted in one go, mock interviews with industry experts to make students get acclimatized to the rigorous selection process of companies like Amazon, Google etc.",
                "https://pbs.twimg.com/profile_images/749503540184350720/WUQ7-NHv.jpg","https://codingblocks.com/bootcamps/interviewprep.html","22-07-2017"));
        events.add(new TechEvents("Competetitive Coding Bootcamp","Hone your Competittive Programming skills with our 1-week bootcamp on Competititive Coding. The aim of competitive programming is to write source code of computer programs which are able to solve given problems. A vast majority of problems appearing in programming contests are mathematical or logical in nature. Typical such tasks belong to one of the following categories: combinatorics, number theory, graph theory, geometry, string analysis and data structures. Such problems are also asked in exams like Google APAC, coding contests and competititons like ACM-ICPC.",
                "https://pbs.twimg.com/profile_images/749503540184350720/WUQ7-NHv.jpg","https://codingblocks.com/bootcamps/competitiveprogramming.html",
                "15-07-2017" ));
        rvevents.setLayoutManager(new LinearLayoutManager(getContext()));
        TechEventsAdapter techEventsAdapter = new TechEventsAdapter(getContext(),events,myevents);
        rvevents.setAdapter(techEventsAdapter);
        return itemView;
    }

}
