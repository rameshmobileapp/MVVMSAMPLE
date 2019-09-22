package com.example.mvvmsample.data.local.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mvvmsample.data.local.db.Table.TableMovieList;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface DataBaseDao {

    @Query("SELECT * FROM TableMovieList")
    Single<List<TableMovieList>> getAllMovie();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(TableMovieList tableMovieList);

    @Delete
    int delete(TableMovieList tableMovieList);

    @Update
    int update(TableMovieList tableMovieList);

}
