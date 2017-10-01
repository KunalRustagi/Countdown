package com.example.kunalrustagi.countdown.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kunalrustagi.countdown.R;
import com.example.kunalrustagi.countdown.models.TechEvents;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kunalrustagi on 07/07/17.
 */

public class TechMyEventsAdapter extends RecyclerView.Adapter<TechMyEventsAdapter.TechMyEventHolder>{
    private Context context;private ArrayList<TechEvents>myevents;

    public TechMyEventsAdapter(Context context, ArrayList<TechEvents> myevents) {
        this.context = context;
        this.myevents = myevents;
    }


    @Override
    public TechMyEventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new TechMyEventsAdapter.TechMyEventHolder(inflater.inflate(R.layout.list_item_myevents,parent,false));
    }

    @Override
    public void onBindViewHolder(TechMyEventHolder holder, int position) {
           TechEvents myevent = myevents.get(position);
        holder.tvtitle.setText(myevent.getTitle());
        holder.tvdate.setText(myevent.getDate());
        Picasso.with(context).load(myevent.getUrlToImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return myevents.size();
    }

    class TechMyEventHolder extends RecyclerView.ViewHolder{
        TextView tvtitle,tvdate;ImageView img;
        public TechMyEventHolder(View itemView) {
            super(itemView);
            tvdate=(TextView)itemView.findViewById(R.id.tvdate);
            tvtitle=(TextView)itemView.findViewById(R.id.tvtitle);
            img=(ImageView)itemView.findViewById(R.id.img);
        }
    }
}
