package com.example.kunalrustagi.countdown.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kunalrustagi.countdown.interfaces.OnButtonClickListener;
import com.example.kunalrustagi.countdown.R;
import com.example.kunalrustagi.countdown.interfaces.OnViewClickListener;
import com.example.kunalrustagi.countdown.models.Articles;
import com.example.kunalrustagi.countdown.models.TechNews;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kunalrustagi on 07/07/17.
 */

public class TechNewsAdapter extends RecyclerView.Adapter<TechNewsAdapter.TechHolder>{
    Context context;ArrayList<Articles> articles; OnViewClickListener ovcl;
    public TechNewsAdapter(Context context,TechNews news,OnViewClickListener ovcl){
        this.context=context;
        this.articles=news.getArticles();
        this.ovcl=ovcl;
    }
    public void updateTechNews(TechNews news){
        this.articles=news.getArticles();
        notifyDataSetChanged();
    }
    @Override
    public TechHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new TechHolder(inflater.inflate(R.layout.list_item_technews,parent,false));
    }

    @Override
    public void onBindViewHolder(final TechHolder holder, int position) {
        final Articles thisarticle = articles.get(position);
        holder.tvtext.setText(thisarticle.getTitle());
        Picasso.with(context).load(thisarticle.getUrlToImage()).into(holder.img);
        Log.e("NewsAdap","View Id" + holder.rootView);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("NewsAdap","OnClick" + holder.rootView);
       //         Log.e("TechNews","onViewClick :");
                ovcl.onViewClick(thisarticle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class TechHolder extends RecyclerView.ViewHolder{
        TextView tvtext;ImageView img;View rootView;
        TechHolder(View itemView){
            super(itemView);
            tvtext=(TextView)itemView.findViewById(R.id.tvtext);
            img=(ImageView)itemView.findViewById(R.id.img);
            rootView=itemView;
        }
    }
}
