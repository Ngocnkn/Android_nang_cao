package com.example.assigment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.assigment.DatabaseHelper.COLUMN_DATEREGIST;
import static com.example.assigment.DatabaseHelper.COLUMN_NAMECOURSE;
import static com.example.assigment.DatabaseHelper.TABLE_COURSES;


public class CoursesDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private Context context;


    public CoursesDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public long insertCourses(Courses courses) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMECOURSE, courses.getTenKhoaHoc());
        values.put(COLUMN_DATEREGIST, courses.getThoiGian());

        long result = db.insert(TABLE_COURSES, null, values);

        db.close();

        return result;

    }

    public List<Courses> getAllCoursesRegist() {
        List<Courses> coursesList = new ArrayList<>();

        db = dbHelper.getReadableDatabase();
        String select = "SELECT * FROM " + TABLE_COURSES;
        Cursor cursor = db.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                Courses courses = new Courses();
                courses.setTenKhoaHoc(cursor.getString(cursor.getColumnIndex(COLUMN_NAMECOURSE)));
                courses.setThoiGian(cursor.getString(cursor.getColumnIndex(COLUMN_DATEREGIST)));
                coursesList.add(courses);
            } while (cursor.moveToNext());

            // dong ket noi con tro
            cursor.close();
        }
        // dong ket noi DB
        db.close();
        return coursesList;

    }

    public long deleteCoursesByName(String username) {
        db = dbHelper.getWritableDatabase();
        long result = db.delete(TABLE_COURSES, COLUMN_NAMECOURSE + "=?", new String[]{username});
        db.close();
        return result;

    }
}
