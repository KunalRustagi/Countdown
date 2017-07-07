package com.example.kunalrustagi.countdown.models;

import java.io.Serializable;

/**
 * Created by kunalrustagi on 07/07/17.
 */

public class TechEvent implements Serializable {
    String title;
    String description;
    String urlToImage;
    String url;
    String date;

    public TechEvent(String title, String description, String urlToImage, String url, String date) {
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
        this.url = url;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }
}
