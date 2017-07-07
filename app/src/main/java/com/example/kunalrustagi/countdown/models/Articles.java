package com.example.kunalrustagi.countdown.models;

/**
 * Created by kunalrustagi on 07/07/17.
 */

public class Articles {
    String title;
    String url;
    String urlToImage;
    String description;

    public Articles(String title, String url, String urlToImage, String description) {
        this.title = title;
        this.url = url;
        this.urlToImage = urlToImage;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getDescription() {
        return description;
    }
}
