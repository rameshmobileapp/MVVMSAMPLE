package com.example.mvvmsample.data.remote;


import android.accounts.NetworkErrorException;

import com.example.mvvmsample.data.model.api.cast.CastResponse;
import com.example.mvvmsample.data.model.api.moviedetails.MovieDetailsResponse;
import com.example.mvvmsample.data.model.api.movielist.MovieListResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper  implements ApiHelper{

    private ApiHelper mApiHelper;

    @Inject
    public AppApiHelper(ApiHelper apiHelper) {
        mApiHelper = apiHelper;
    }


    @Override
    public Single<MovieListResponse> getMovieListDetails(String apiKey, String greaterDate, String lessDate) throws NetworkErrorException {
        return mApiHelper.getMovieListDetails(apiKey,greaterDate,lessDate);
    }

    @Override
    public Single<MovieDetailsResponse> getMovie(String movieId, String apiKey) {
        return mApiHelper.getMovie(movieId,apiKey);
    }

    @Override
    public Single<CastResponse> getCastOfMovie(String movieId, String apiKey) {
        return mApiHelper.getCastOfMovie(movieId,apiKey);
    }


}
