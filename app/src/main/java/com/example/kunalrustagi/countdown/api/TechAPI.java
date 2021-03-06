package com.example.kunalrustagi.countdown.api;

import com.example.kunalrustagi.countdown.models.TechNews;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kunalrustagi on 07/07/17.
 */

public interface TechAPI {
    @GET("v1/articles?source=techradar&sortBy=top&apiKey=f363fd39b50e4c50b3a951858eb7a264")
    Call<TechNews>getTechNews();
    @GET("v1/articles?source=techcrunch&sortBy=top&apiKey=f363fd39b50e4c50b3a951858eb7a264")
    Call<TechNews>getMoreTechNews();
}
