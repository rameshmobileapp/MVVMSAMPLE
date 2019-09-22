package com.example.mvvmsample.data;

import com.example.mvvmsample.data.model.api.LoginRequest;
import com.example.mvvmsample.data.model.api.LoginResponse;
import com.example.mvvmsample.data.remote.ApiHelper;

import io.reactivex.Single;

public interface DataManager extends ApiHelper {

    Single<LoginResponse> doServerLoginApiCall(LoginRequest loginRequest);

    // Get the movie from the server
//    Single<MovieListResponse> getMovieList(MovieListRequest request) throws Exception;





}
