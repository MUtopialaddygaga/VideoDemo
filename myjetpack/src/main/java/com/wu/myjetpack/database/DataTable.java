package com.wu.myjetpack.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Each @Entity class represents a SQLite table
 */
@Entity(tableName = "test_table")
public class DataTable {

    @PrimaryKey(autoGenerate = true)
    private int _id;

    /**
     * 数据库表的字段用public修饰或是包含set/get
     */
    @ColumnInfo(name = "test_value")
    private String mTest;

    public void setmTest(String mTest) {
        this.mTest = mTest;
    }

    public String getmTest() {
        return mTest;
    }
}
