package com.example.kunalrustagi.countdown.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.kunalrustagi.countdown.R;
import com.example.kunalrustagi.countdown.models.Results;
import com.example.kunalrustagi.countdown.models.Search;
import com.example.kunalrustagi.countdown.models.Url;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kunalrustagi on 10/07/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {
    private Context context;private ArrayList<Results>results;static Url urls;static String baseUrl;

    public MoviesAdapter(Context context, Search search) {
        this.context = context;
        this.results = search.getResults();

    }
    public void updateList(Search search, ProgressBar progbar){
        this.results=search.getResults();
        progbar.setVisibility(View.INVISIBLE);
        progbar.setVisibility(View.GONE);
        notifyDataSetChanged();
    }
    public static void urlupdated(Url obj){
        urls=obj;
        baseUrl=obj.getImages().getBase_url()+obj.getImages().getPoster_sizes().get(2);
        Log.e("URLUPDATE","COMPLETE URL " + baseUrl);
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("MOVIESADAPTER","OBVH respnse" + results);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       return new MovieHolder(inflater.inflate(R.layout.list_item_movies,parent,false));
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {


        Results thisresult=results.get(position);
//        if(urls.getImages().getPoster_sizes().size()!=0){
//        String baseurl=urls.getImages().getBase_url();
//        String postersize=urls.getImages().getPoster_sizes().get(0);
//        String completeurl=baseurl+"/"+postersize;
//            completeurl=completeurl+thisresult.getPoster_path();
            Picasso.with(context).load(baseUrl+thisresult.getPoster_path()).into(holder.img);


        Log.e("MOVIESADAPTER","OBVH respnse" + results);

        holder.tvoverview.setText(thisresult.getOverview());
        float a = (float) (thisresult.getVote_average() * 0.5);
        Log.e("OBVH MA","RATING "+ a);
        holder.tvrating.setRating (a);

        holder.tvrelease.setText(thisresult.getRelease_date());
        holder.tvtitle.setText(thisresult.getTitle());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder{
        TextView tvtitle,tvrelease,tvoverview; RatingBar tvrating;
        ImageView img;

        public MovieHolder(View itemView) {
            super(itemView);
            tvtitle=(TextView)itemView.findViewById(R.id.tvtitle);
            tvrelease=(TextView)itemView.findViewById(R.id.tvrelease);
            tvrating=(RatingBar) itemView.findViewById(R.id.tvrating);
            tvoverview=(TextView)itemView.findViewById(R.id.tvoverview);
            img=(ImageView)itemView.findViewById(R.id.img);
        }
    }
}
