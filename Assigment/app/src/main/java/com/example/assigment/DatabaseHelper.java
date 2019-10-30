package com.example.assigment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbCoursesManager";
    public static final int VERSION = 2;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public static final String TABLE_COURSES = "KhoaHoc";
    public static final String COLUMN_NAMECOURSE = "tenkhoahoc";
    public static final String COLUMN_DATEREGIST = "ngaydangki";
    String SQL_COURSES = "CREATE TABLE " + TABLE_COURSES + " (" + COLUMN_NAMECOURSE + " text primary key, " + "" + COLUMN_DATEREGIST + " text);";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_COURSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists " + TABLE_COURSES);
    }
}
