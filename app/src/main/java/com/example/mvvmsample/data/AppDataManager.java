package com.example.mvvmsample.data;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.example.mvvmsample.data.model.api.LoginRequest;
import com.example.mvvmsample.data.model.api.LoginResponse;
import com.example.mvvmsample.data.model.api.cast.CastResponse;
import com.example.mvvmsample.data.model.api.moviedetails.MovieDetailsResponse;
import com.example.mvvmsample.data.model.api.movielist.MovieListResponse;
import com.example.mvvmsample.data.remote.ApiHelper;
import com.example.mvvmsample.di.ApiInfo;
import com.example.mvvmsample.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";
    private final ApiHelper mApiHelper;
    private final Context mContext;
    private final String mApiKey;

    @Inject
    public AppDataManager(@ApplicationContext Context mContext, ApiHelper mApiHelper,@ApiInfo String apiKey) {
        this.mContext = mContext;
        this.mApiHelper = mApiHelper;
        mApiKey = apiKey;
    }




    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest loginRequest) {
        return null;
    }


    @Override
    public Single<MovieListResponse> getMovieListDetails(String apiKey, String greaterDate, String lessDate) throws NetworkErrorException {
        return mApiHelper.getMovieListDetails(apiKey, greaterDate, lessDate);
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
