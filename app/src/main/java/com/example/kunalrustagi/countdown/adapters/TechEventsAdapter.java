package com.example.kunalrustagi.countdown.adapters;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kunalrustagi.countdown.FragmentEvent;
import com.example.kunalrustagi.countdown.R;
import com.example.kunalrustagi.countdown.models.Articles;
import com.example.kunalrustagi.countdown.models.TechEvents;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kunalrustagi on 07/07/17.
 */

public class TechEventsAdapter extends RecyclerView.Adapter<TechEventsAdapter.TechEventHolder> {
    Context context;ArrayList<TechEvents> techevents;public ArrayList<TechEvents>myevents;

    public TechEventsAdapter(Context context, ArrayList<TechEvents> techevents,ArrayList<TechEvents>myevents) {
        this.context = context;
        this.techevents = techevents;
        this.myevents=myevents;
    }

    @Override
    public TechEventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new TechEventsAdapter.TechEventHolder(inflater.inflate(R.layout.list_item_techevents,parent,false));
    }

    @Override
    public void onBindViewHolder(final TechEventHolder holder, int position) {
        final TechEvents thisevent = techevents.get(position);
     //   Log.e("TA","onBind: "+thisevent);
        holder.tvtext.setText(thisevent.getTitle());
        Picasso.with(context).load(thisevent.getUrlToImage()).into(holder.img);
        holder.flbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myevents.add(thisevent);
                FragmentEvent.getArg(myevents,1);
                Log.e("TEA","onClick" + myevents);
                notifyDataSetChanged();
                Toast.makeText(context,"Event Added",Toast.LENGTH_SHORT).show();
                holder.flbtn.setVisibility(View.GONE);
            }
        });
    }
    public ArrayList<TechEvents> myEvents(){
        Log.e("myEven","Array after Clicking " + myevents);
        return myevents;
    }

    @Override
    public int getItemCount() {
        return techevents.size();
    }

    class TechEventHolder extends RecyclerView.ViewHolder{
        TextView tvtext;ImageView img;FloatingActionButton flbtn;
        TechEventHolder(View itemView){
            super(itemView);
            tvtext=(TextView)itemView.findViewById(R.id.tvtext);
            img=(ImageView)itemView.findViewById(R.id.img);
            flbtn=(FloatingActionButton)itemView.findViewById(R.id.flbtn);

        }
    }
}
