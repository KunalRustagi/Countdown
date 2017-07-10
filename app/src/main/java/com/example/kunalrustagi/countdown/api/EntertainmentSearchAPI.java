package com.example.kunalrustagi.countdown.api;

import com.example.kunalrustagi.countdown.models.Search;
import com.example.kunalrustagi.countdown.models.Url;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kunalrustagi on 10/07/17.
 */

public interface EntertainmentSearchAPI {
@GET("search/movie")
    Call<Search>getResults(
            @Query("api_key") String api_key,
            @Query("query") String query
);
 @GET("configuration")
    Call<Url>getCompleteUrl(@Query("api_key") String api_key);
}
