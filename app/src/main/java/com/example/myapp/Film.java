package com.example.myapp;

import org.json.JSONException;
import org.json.JSONObject;

public class Film {
    private String title;
    private String description;
    private String director;
    private String release;

    public Film(String title, String description, String director, String release) {
        this.title=title;
        this.description=description;
        this.director=director;
        this.release=release;
    }

    public Film(JSONObject json) {
        try {
            this.title=json.getString("title");
            this.description=json.getString("opening_crawl");
            this.director=json.getString("director");
            this.release=json.getString("release_date");
        } catch (JSONException e) {
            e.printStackTrace();
            this.title="";
            this.description="";
            this.director="";
            this.release="";
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }
}
