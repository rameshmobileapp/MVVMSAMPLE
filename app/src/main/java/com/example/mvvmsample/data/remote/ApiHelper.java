package com.example.mvvmsample.data.remote;

import android.accounts.NetworkErrorException;

import com.example.mvvmsample.data.model.api.cast.CastResponse;
import com.example.mvvmsample.data.model.api.moviedetails.MovieDetailsResponse;
import com.example.mvvmsample.data.model.api.movielist.MovieListResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiHelper {

//    ApiHeader getApiHeader();

    @GET(ApiEndPoint.ENDPOINT_MOVIE_LIST)
    Single<MovieListResponse> getMovieListDetails(
            @Query("api_key") String apiKey,
            @Query("primary_release_date.gte") String greaterDate,
            @Query("primary_release_date.lte") String lessDate) throws NetworkErrorException;

    @GET(ApiEndPoint.ENDPOINT_MOVIE)
    Single<MovieDetailsResponse> getMovie(
            @Path("movie_id") String movieId,
            @Query("api_key") String apiKey
    );

    @GET(ApiEndPoint.ENDPOINT_MOVIE_CAST)
    Single<CastResponse> getCastOfMovie(
            @Path("id") String movieId,
            @Query("api_key") String apiKey
    );


}
