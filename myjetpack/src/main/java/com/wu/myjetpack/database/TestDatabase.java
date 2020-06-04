package com.wu.myjetpack.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DataTable.class}, version = 1, exportSchema = false)
public abstract class TestDatabase extends RoomDatabase {
    public static volatile TestDatabase INSTANCE;
    private static final int MAX_THREAD_COUNT = 4;

    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(MAX_THREAD_COUNT);

    static TestDatabase getDataBase(final Context context){
        if (INSTANCE == null){
            synchronized (TestDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TestDatabase.class, "test_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract DataTable getDataTable();
}
