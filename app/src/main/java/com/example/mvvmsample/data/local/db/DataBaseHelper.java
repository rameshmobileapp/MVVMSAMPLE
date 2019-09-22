package com.example.mvvmsample.data.local.db;


import com.example.mvvmsample.data.local.db.Table.TableMovieList;
import com.example.mvvmsample.data.model.api.movielist.MovieList;

import java.util.List;

import io.reactivex.Single;

public interface DataBaseHelper {

    Single<Integer> updateMovie(MovieList movie);

    Single<List<TableMovieList>> getAllMovie();

    Single<TableMovieList> getSingleMovie(String movieName);

    Single<Long> insertSingle(MovieList movieList);

    Single<Long[]> insertMultipleMovieList(List<MovieList> movieList);

    Single<Integer> delete(MovieList movieList);

    Single<Integer> update(MovieList movieList);

}
