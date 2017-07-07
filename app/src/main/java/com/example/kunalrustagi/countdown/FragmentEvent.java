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
    private int mParam1;
    private int mParam2;


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
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEvent.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEvent newInstance(int param1,int param2) {
        FragmentEvent fragment = new FragmentEvent();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2,param2);
      //  args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<TechEvents> events;ArrayList<TechEvents>myevents=new ArrayList<TechEvents>();
        View itemView = inflater.inflate(R.layout.fragment_tech_events,container,false);
        RecyclerView rvevents=(RecyclerView)itemView.findViewById(R.id.rvevents);events = new ArrayList<TechEvents>();
        if(mParam2==1) {

            events.add(new TechEvents("India Hacks", "IndiaHacks is the biggest confluence of developers across domains and interests under a single platform.It's your chance to demonstrate your programming skills, while competing with the best developers in the world.", "https://hackerearth.global.ssl.fastly.net/static/hackerearth/images/indiahacks/2017/share_image.jpg", "https://www.hackerearth.com/indiahacks-2017/", "30-09-2017"));
            events.add(new TechEvents("Smart India Hackathon", "Smart India Hackathon 2017 is a pan India 36 hour nonstop digital programming competition. The participating teams will simultaneously compete from across 33 locations in India to offer digital yet sustainable innovative solutions to solve real time challenges faced by the nation. It will harness the creativity of millions of bright young minds like you.", "https://dkzstslcvgwbc.cloudfront.net/sites/default/files/pages/cover_image/sih2017-home.jpg",
                    "https://innovate.mygov.in/sih2017/", "28-07-2017"));
            events.add(new TechEvents("Interview Prep Bootcamp", "Tone up your programming and interviewing skills with the fast-paced course, designed to help students in preparing for interviews in software companies. Lectures on all important topics as Operating Systems, DBMS and System Design, resume building to get shortlisted in one go, mock interviews with industry experts to make students get acclimatized to the rigorous selection process of companies like Amazon, Google etc.",
                    "https://pbs.twimg.com/profile_images/749503540184350720/WUQ7-NHv.jpg", "https://codingblocks.com/bootcamps/interviewprep.html", "22-07-2017"));
            events.add(new TechEvents("Competetitive Coding Bootcamp", "Hone your Competittive Programming skills with our 1-week bootcamp on Competititive Coding. The aim of competitive programming is to write source code of computer programs which are able to solve given problems. A vast majority of problems appearing in programming contests are mathematical or logical in nature. Typical such tasks belong to one of the following categories: combinatorics, number theory, graph theory, geometry, string analysis and data structures. Such problems are also asked in exams like Google APAC, coding contests and competititons like ACM-ICPC.",
                    "https://pbs.twimg.com/profile_images/749503540184350720/WUQ7-NHv.jpg", "https://codingblocks.com/bootcamps/competitiveprogramming.html",
                    "15-07-2017"));
        }
        else if(mParam2==2){
            events.add(new TechEvents("Impact of GST on Startups | Startup Saturday","The startup boom in India has begun full flow. We rank third globally with over 4,200 startups and the number is set to increase to 10,000 by 2020. The sector employs over 85,000 professionals and is proving to be an important growth engine for India’s economy and society. With around three startups being born every day in the country, one just has to ask – how will the new tax laws under goods and services tax (GST) affect a sector that is probably the next best thing since the internet boom of the 90s?",
                    "https://www.lawctopus.com/wp-content/uploads/2017/04/gst-essay.jpeg","https://www.eventshigh.com/detail/Delhi/43054048597c4c137e75bb3924f33b9e-impact-of-gst-on-startups?src=ecbox",
                    "12-08-2017"));
            events.add(new TechEvents("Startup Founders & Investors 4.0","","https://emages.eventshigh.com/2017/2/16/img_5fdc1728536653e3fec5be5a8f0d35e7_1487236043722_processed_original.jpg",
                    "https://www.eventshigh.com/detail/Delhi/92f9c2d9c5475ed9c1f99829d49d9e47-startup-founders-investors-4-0?src=ecbox","02-09-2017"));
            events.add(new TechEvents("Entrepreneur India 2017","It is a platform for entrepreneurs to discover and unleash breakthrough Ideas, Innovations and Insights needed to realize their power to disrupt the social, economic and tech ecosystem.In its 7th Annual edition, Entrepreneur 2017 aims to bring together inspiring entrepreneurs and investors for creating new opportunities for investment, build new partnerships and collaboration avenues and highlight entrepreneurship as means to address some of the most intractable society challenges.",
                    "https://storage.googleapis.com/ehimages/2017/5/22/img_b66530463383941820307df8c1372572_1495429716710_processed_original.png","http://www.meraevents.com/event/entrepreneur-india-2017",
                    "18-07-2017"));


        }
        rvevents.setLayoutManager(new LinearLayoutManager(getContext()));
        TechEventsAdapter techEventsAdapter = new TechEventsAdapter(getContext(),events,myevents);
        rvevents.setAdapter(techEventsAdapter);
        return itemView;
    }

}
