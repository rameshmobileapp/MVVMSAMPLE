package com.example.mvvmsample.data.remote;


import com.example.mvvmsample.BuildConfig;

public final class ApiEndPoint {

    public static final String ENDPOINT_MOVIE_LIST = BuildConfig.BASE_URL
            + "discover/movie?";

    public static final String ENDPOINT_MOVIE = BuildConfig.BASE_URL
            + "movie/{movie_id}?";

    public static final String ENDPOINT_MOVIE_CAST = BuildConfig.BASE_URL
            + "movie/{id}/casts?";

}
