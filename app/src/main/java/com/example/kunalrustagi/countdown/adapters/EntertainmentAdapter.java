package com.example.kunalrustagi.countdown.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kunalrustagi.countdown.R;
import com.example.kunalrustagi.countdown.interfaces.OnViewClickListener;
import com.example.kunalrustagi.countdown.models.Articles;
import com.example.kunalrustagi.countdown.models.TechNews;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kunalrustagi on 09/07/17.
 */

public class EntertainmentAdapter extends RecyclerView.Adapter<EntertainmentAdapter.EntertainmentHolder> {
    Context context;ArrayList<Articles> articles; OnViewClickListener ovcl;

    public EntertainmentAdapter(Context context, TechNews news, OnViewClickListener ovcl) {
        this.context = context;
        this.articles = news.getArticles();
        this.ovcl = ovcl;
    }
    public void updateTechNews(TechNews news, ProgressBar progbar){
        this.articles=news.getArticles();
        progbar.setVisibility(View.INVISIBLE);
        progbar.setVisibility(View.GONE);
        notifyDataSetChanged();
    }

    @Override
    public EntertainmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new EntertainmentHolder(inflater.inflate(R.layout.list_item_technews,parent,false));
    }

    @Override
    public void onBindViewHolder(final EntertainmentHolder holder, int position) {
        final Articles thisarticle = articles.get(position);
        holder.tvtext.setText(thisarticle.getTitle());
        Picasso.with(context).load(thisarticle.getUrlToImage()).into(holder.img);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ovcl.onViewClick(thisarticle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class EntertainmentHolder extends RecyclerView.ViewHolder{
        TextView tvtext;ImageView img;View rootView;
        EntertainmentHolder(View itemView){
            super(itemView);
            tvtext=(TextView)itemView.findViewById(R.id.tvtext);
            img=(ImageView)itemView.findViewById(R.id.img);
            rootView=itemView;
        }
    }
}
