package com.example.mvvmsample.data.local.db;

import com.example.mvvmsample.data.local.db.Table.TableMovieList;
import com.example.mvvmsample.data.model.api.movielist.MovieList;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppDataBaseHelper implements DataBaseHelper {

    // Database configuration class
    private DataBaseConfig dataBaseConfig;

    @Inject
    public AppDataBaseHelper(DataBaseConfig dataBaseInit) {
        this.dataBaseConfig = dataBaseInit;
    }


    @Override
    public Single<Integer> updateMovie(MovieList movie) {
        return null;
    }

    @Override
    public Single<List<TableMovieList>> getAllMovie() {
        return dataBaseConfig.dataBaseDao().getAllMovie();
    }

    @Override
    public Single<TableMovieList> getSingleMovie(String movieName) {
        return null;
    }

    @Override
    public Single<Long> insertSingle(MovieList movie) {
        return Single.create(emitter -> {
            //emitter.onSuccess(dataBaseConfig.dataBaseDao().insert(movie));
        });
    }

    @Override
    public Single<Long[]> insertMultipleMovieList(List<MovieList> movies) {
        return Single.create(emitter -> {
            Long[] longs = new Long[movies.size()];
            for (int i = 0; i < movies.size(); i++) {
                MovieList result = movies.get(i);
                longs[i] = dataBaseConfig.dataBaseDao().insert(getMovieDetails(result));
            }
            emitter.onSuccess(longs);
        });
    }

    @Override
    public Single<Integer> delete(MovieList movie) {
        return Single.create(emitter -> {
            //emitter.onSuccess(dataBaseConfig.dataBaseDao().delete(movie));
        });
    }

    @Override
    public Single<Integer> update(MovieList TableMovie) {
        return null;
    }


    private TableMovieList getMovieDetails(MovieList result) {
        return new TableMovieList(result.getVideo(),result.getVoteAverage(), result.getTitle(),
                result.getPopularity(),result.getPosterPath(),result.getOriginalLanguage(),
                result.getOriginalTitle(),result.getGenreIds(),result.getBackdrop_Path(),
                result.getAdult(),result.getOverview(),result.getRelease_date()
        );
    }
}
