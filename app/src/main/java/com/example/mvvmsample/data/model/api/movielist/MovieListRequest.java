package com.example.mvvmsample.data.model.api.movielist;

import com.google.gson.annotations.SerializedName;

public class MovieListRequest {

    @SerializedName("primary_release_date.gte")
    private String mDateGreater;

    @SerializedName("primary_release_date.lte")
    private String mDateLess;

    public MovieListRequest(String dateGreater, String dateLess) {
        this.mDateGreater = dateGreater;
        this.mDateLess = dateLess;
    }

    public String getDateGreater() {
        return mDateGreater;
    }

    public void setDateGreater(String mDateGreater) {
        this.mDateGreater = mDateGreater;
    }

    public String getDateLess() {
        return mDateLess;
    }

    public void setDateLess(String mDateLess) {
        this.mDateLess = mDateLess;
    }
}
