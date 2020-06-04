package com.wu.myjetpack.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * 作用:A DAO (data access object) validates your SQL at compile-time and associates it with a method.
 *     By default, all queries must be executed on a separate thread
 * 必须是interface或是abstract的类
 */
@Dao
public interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DataTable dataTable);

    @Query("DELETE FROM test_table")
    void deleteAll();
}
