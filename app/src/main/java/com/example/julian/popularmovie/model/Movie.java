package com.example.julian.popularmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

public class Movie implements Parcelable {

    private long id;
    private String title;
    private String description;
    private Date releaseDate;
    private String poster;
    private float voteAverage;

    public Movie(){}

    protected Movie(Parcel in) {
        id          = in.readLong();
        title       = in.readString();
        description = in.readString();
        long time   = in.readLong();
        releaseDate = time != 0 ? new Date(time) : null;
        poster      = in.readString();
        voteAverage = in.readFloat();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {

        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeLong(releaseDate != null ? releaseDate.getTime() : 0);
        dest.writeString(poster);
        dest.writeFloat(voteAverage);
    }

    private ArrayList<Movie> results;

    public ArrayList<Movie> getMovies() {
        return results;
    }

    public String getPosterUrl(){
        return this.poster;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getPoster() {
        return poster;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

}
