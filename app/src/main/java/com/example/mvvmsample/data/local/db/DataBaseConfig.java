package com.example.mvvmsample.data.local.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.mvvmsample.data.local.db.Table.TableMovieList;

import javax.inject.Singleton;

@Singleton
@Database(entities = {TableMovieList.class}, version = 1,exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class DataBaseConfig extends RoomDatabase {

    public abstract DataBaseDao dataBaseDao();

    // Database migration process
//    public static Migration migration_2_3 = new Migration(2,3) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE task "
//                    + " ADD COLUMN pub_years TEXT");
//        }
//    };
}