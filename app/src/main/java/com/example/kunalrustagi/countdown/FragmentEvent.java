package com.example.kunalrustagi.countdown;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kunalrustagi.countdown.activities.DetailsActivity;
import com.example.kunalrustagi.countdown.adapters.TechEventsAdapter;
import com.example.kunalrustagi.countdown.interfaces.OnButtonClickListener;
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


    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;


    public FragmentEvent() {
        // Required empty public constructor
    }
    public static void getArg(ArrayList<TechEvents>techno,int n){
        tech=techno; tech.addAll(techfinal);
        techfinal=techno;

        a=n;
    }
    public static  ArrayList<TechEvents> setArg(){
        if(a==1){
            return tech;
        }
        return new ArrayList<TechEvents>();
    }

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
                    "http://blog.codingblocks.com/img/logo.png", "https://codingblocks.com/bootcamps/interviewprep.html", "22-07-2017"));
            events.add(new TechEvents("Competetitive Coding Bootcamp", "Hone your Competittive Programming skills with our 1-week bootcamp on Competititive Coding. The aim of competitive programming is to write source code of computer programs which are able to solve given problems. A vast majority of problems appearing in programming contests are mathematical or logical in nature. Typical such tasks belong to one of the following categories: combinatorics, number theory, graph theory, geometry, string analysis and data structures. Such problems are also asked in exams like Google APAC, coding contests and competititons like ACM-ICPC.",
                    "http://blog.codingblocks.com/img/logo.png", "https://codingblocks.com/bootcamps/competitiveprogramming.html",
                    "15-07-2017"));
            events.add(new TechEvents("Digital India Hackathon","ACM India is hosting a one-day Digital India event in conjunction with VLDB 2016 and Persistent Systems Ltd. We are very excited by the opportunities presented by the ambitious Digital India program launched by Hon. PM Narendra Modi. It is a grandeur vision of uniting a large nation like India via high-speed digital highways. 1.2 billion Indians will be connected together and will have access to open information. Data takes the center stage in this vision due to the sheer size of India’s population. With ~1 billion Aadhar cards, 200+ million Jan-Dhan Yojna accounts, the magnitude of India-scale data is humongous. Such large data processing will need specialized big data and analytics expertise.",
                    "http://digitalindiahack.org/assets/images/logo.png","https://www.hackerearth.com/sprints/digital-india-hackathon/","21-07-2017"));
            events.add(new TechEvents("WWDC 2017","Get the in-depth technical details you need to build the next generation of apps using newly announced Apple technologies.Learn more about implementing new technologies into your code with expert advice from Apple engineers in a collaborative group setting.",
                    "http://pngimg.com/uploads/apple_logo/apple_logo_PNG19670.png","https://developer.apple.com/wwdc/","05-06-2017"));
            events.add(new TechEvents("OnePlus 5 India Launch","The OnePlus 5 aspires to be the next flagship killer, with top-of-the-line innards, premium cameras and redefined design language that is largely crafted on the blueprints of Apple's iPhone 7 Plus. Now that the smartphone is just about to be officially launched in India, and its features and specifications are made public, it’s time to compare the flagship device with its predecessor to determine whether the hype surrounding the device is good enough reason for you to buy it as an upgrade.","http://oneplus3t.com/wp-content/uploads/2017/06/OnePlus-logo-banner.png","https://oneplusstore.in/launch2017","22-06-2017"));
            events.add(new TechEvents("4th Annual International Data Science Summit","DETAILS\n" +
                    "NASSCOM and Data Science Foundation (http://datasciencefoundation.org/) - a non-profit entity dedicated to the cause of Data Scientists are organizing the 4th Annual Summit on Data Science at Kolkata, India on 11th August 2017 at Kolkata. \n" +
                    "\n" +
                    "Previous years the events witnessed speakers and audience coming from corporate, academia and research fraternities across India likeKPMG, Airtel, Flipkart, Business Brio, TCS, Cognizant Unilever, Mjunction, Ideal Analytics, TCG, SAS, Microsoft, Reliance Jio, Woolworths etc. and Academic Institutes like Indian Statistical Institute, IIT, Institute of Bioinformatics etc.",
                    "https://cdn.explara.com/59008b5fd726b.png","https://in.explara.com/e/4th-data-science-summit","11-08-2017"));
            events.add(new TechEvents("DataHack Summit 2017","STEP INTO THE FUTURE OF ANALYTICS & MACHINE LEARNING\n" +
                    "\n" +
                    "DataHack Summit is a conference by Analytics Vidhya to bring together the finest data scientists from across the country. Join us from 9 – 11 November in Bengaluru and see live action in Advanced Analytics, Artificial Intelligence, Machine Learning & Deep Learning. This is a unique opportunity to listen to amazing speakers, network and mingle and attend rigorous workshops. \n" +
                    "\n" +
                    "DataHack Summit 2017 will talk about new developments in the field of analytics and machine learning. It’s a 3-days gathering of chief data scientists, advanced professionals, researchers, analysts, technology evangelists, data science experts data hackers and practitioners. \n" +
                    "\n","https://cdn.explara.com/cyber20170708154706.png","https://in.explara.com/e/datahack-summit-2017","09-11-2017"));
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
            events.add(new TechEvents("Indian Pharma Expo & Business Excellence Awards 2017","Indian Pharma Expo (IPE) will provide an opportunity for the participating companies to display their products & services to the gamut of visitors, globally from pharma and healthcare industries. The 3-day pharmaceutical and medical expo from 3rd of August 2017 to 5th of August 2017 at Hall No.- 7 F,G,H, Pragati Maidan, New Delhi will bring together eminent personalities from various sectors of pharma, non-pharma and healthcare industries. IPE is one stop juncture to all those who are planning to expand their business through various channels of franchise and distribution; as well as wholesalers and hospital purchase personnels who seek to buy bulk products on concessional rates.",
                    "https://storage.googleapis.com/ehimages/2017/6/16/img_3c2f8a90bd6be39509482f5d46ee51ff_1497597504016_processed_original.png",
                    "https://www.eventshigh.com/detail/Delhi/787e355c4ee9e9c4a9fc0a58924e1080-indian-pharma-expo-business-excellence?src=ecbox",
                    "03-08-2017"));
            events.add(new TechEvents("Young Entrepreneur Awards","NO DETAILS AVAILABLE","https://scontent.xx.fbcdn.net/v/t1.0-0/c166.0.200.200/p200x200/18199004_1268755349909612_7576012717755900434_n.png?oh=539723e2ce4377e4204e158cb7c817f6&oe=59CF9D78","" +
                    "https://allevents.in/new%20delhi/young-entrepreneur-awards/1212035838924526","15-07-2017"));
            events.add(new TechEvents("Enterprise Risk Management","Today’s business world is constantly changing — its unpredictable, volatile, and seems to become more complex every day. By its very nature, it is fraught with risk. Enterprise risk management is a comprehensive, systematic approach for helping the organisation to identify, measure, prioritise and respond to the risks challenging its most critical objectives and related projects, initiatives and day-to-day operating practices.",
                    "https://storage.googleapis.com/ehimages/2017/6/29/img_46a512aa5fea1e0bf960c9cf2174e442_1498717275578_processed_original.jpg",
                    "https://www.eventshigh.com/detail/Delhi/5522b7a21468b9e23d19e240e7fb1a77-enterprise-risk-management-by-princeton?src=ecbox",
                    "21-07-2017"));


        }
        else if(mParam2==3){
            events.add(new TechEvents("Standup Comedy Show ft. Sapan Verma","Sapan Verma is one of India's youngest professional comedians, having done over 300 shows in the last three years. He has not only performed all across India but also in Barcelona, Singapore and China. As one of the founding members of India's busiest comedy company East India Comedy, Sapan has regularly performed at various auditoriums, college festivals, and corporate events.\n" +
                    "\n","https://storage.googleapis.com/ehimages/2017/7/6/img_ff354120dda2dce3a66f7e41456e0f77_1499323688205_processed_original.png",
                    "https://www.eventshigh.com/detail/Delhi/17bcbf3f7a13dbba00ff434c90bd7798?src=rtad","10-07-2017"));
            events.add(new TechEvents("Wait there's mor! - With Anshu Mor","Anshu Mor: He is stylish, he is funny and he is the sophisticated guy from Gurgaon who left a plush job to become a comedian. Recently acknowledged as the rising star of Indian comedy by a leading newspaper, he has entertained you with his clean comedy about his family and life in 40s. Now he is back with his SOLO special which is guaranteed to be Mor entertaining, Mor insightful, Mor hilarious and Mor whacky than anything he has done before. If you think you have seen everything in stand-up comedy, Wait.there's MOR!)",
                    "https://storage.googleapis.com/ehimages/2017/7/3/img_2a33f776a9ed23cfa50b3d26f953b68a_1499078202906_original.jpg",
                    "https://www.eventshigh.com/detail/Delhi/89b899c6b4d19d522687b1827014cd4b?stc=rtad","16-07-2017"));
            events.add(new TechEvents("Legends of Sufi 2017 - A Series of Sufi Concerts","Legends of Sufi is a series of Sufi concerts and it comprises six Sufi concerts back to back from July to December. They are starting the grand series with the multi talented Sartaj of Sufi music Satinder Sartaaj.A soulful evening with the Sufi sensation Satinder Sartaaj who has given hits like Sai, Jalsa and many more. Be ready for a power packed evening as Satinder Sartaaj is ready to win your hearts. It's an evening full of soulful Sufi renditions, nothing you would want to miss.",
                    "https://in.bmscdn.com/events/showcasesynopsis/ET00057855.jpg","https://in.bookmyshow.com/national-capital-region-ncr/events/legends-of-sufi-2017-a-series-of-sufi-concerts-satinder-sartaaj-live-in-concert/ET00057855",
                    "09-07-2017"));
            events.add(new TechEvents("Laffberry Open Mic Night","Open Mic is a trial show, which basically means good, bad and worst jokes, this is a place where a comedian is born to learn this art form, You will find some experienced comedians, semi new and very new comedians, in short all spices in one plate, in totality there will be around 13 performances.",
                    "https://in.bmscdn.com/events/showcasesynopsis/ET00059399.jpg","https://in.bookmyshow.com/national-capital-region-ncr/events/laffberry-open-mic-night/ET00059399",
                    "15-07-2017"));
            events.add(new TechEvents("Beyond Bollywood","ARTISTS\n" + "Mohit Mathur, Ana Ilmi\n"+"Come experience a vibrant, energetic and visually gorgeous showcasing of the incredible dance culture India has to offer. Follow Shaily and Raghav's dance journey through India as they strive to find their true selves, turning their dreams into reality beyond the mainstream, Beyond Bollywood.",
                    "https://in.bmscdn.com/events/showcasesynopsis/ET00049387.jpg","https://in.bookmyshow.com/national-capital-region-ncr/events/beyond-bollywood/ET00049387","11-07-2017"));
            events.add(new TechEvents("Artistic Photo walk of Humayun’s Tomb","We all know about the architectural wonder which celebrates a husband’s love for his wife- the Taj Mahal. However, Haji Begum, Humayun’s wife had built a tomb in honor of her love and respect for her husband. This structure is celebrated as the Humayun’s Tomb and also happens to be a World Heritage Site, as declared by UNESCO back in 1993.The imposing and beautiful “Cousin of Taj Mahal” built by the wife of Emperor Humayun, Haji Begum, to commemorate her love and respect for her beloved husband, has always attracted millions to its heart. Declared as a World Heritage Site in 1993 by UNESCO, Humayun’s Tomb has lots to offer, whether be history, architecture, beauty or love! A trip to Humayun’s Tomb will be as memorable as any other trip, with an exception that you will be a changed person after your trip to Humayun’s Tomb. The magnificent monument has its capability to satisfy your photography needs as well. Make yourself feel like you are a native for our tour leader will continuously astonish with the stories associated with the monument as well as the Mughals which had a significant role in the history of Delhi itself.", "https://storage.googleapis.com/ehimages/2017/6/23/img_d378d9eae8adc4245af294f1ac8b7a67_1498201455861_original.jpg"
                    ,"https://www.eventshigh.com/detail/Delhi/842576ef35c85e019a89649bbbf0d9f6-artistic-photo-walk-of-humayun%E2%80%99s?src=ecbox"
                    ,"10-07-2017"));
        }
        rvevents.setLayoutManager(new LinearLayoutManager(getContext()));
        TechEventsAdapter techEventsAdapter = new TechEventsAdapter(getContext(), events, myevents, new OnButtonClickListener() {
            @Override
            public void onButtonClick(TechEvents tech) {
                Log.e("FRAGMENTEVENT","onButtonClick :");
                Intent eventdetails = new Intent(getContext(), DetailsActivity.class);
                eventdetails.putExtra("urlToImage",tech.getUrlToImage());
                eventdetails.putExtra("description",tech.getDescription());
                eventdetails.putExtra("url",tech.getUrl());
                eventdetails.putExtra("date",tech.getDate());
                eventdetails.putExtra("title",tech.getTitle());
                startActivity(eventdetails);
            }
        });
                rvevents.setAdapter(techEventsAdapter);
        return itemView;
    }

}
