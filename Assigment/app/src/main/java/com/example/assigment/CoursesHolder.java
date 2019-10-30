package com.example.assigment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CoursesHolder extends RecyclerView.ViewHolder {
    public TextView tvNameCourses, tvDateCourse;
    public ImageView imgRegist;

    public CoursesHolder(@NonNull View itemView) {
        super(itemView);

        tvNameCourses = itemView.findViewById(R.id.tvNameCourses);
        tvDateCourse = itemView.findViewById(R.id.tvDateCourses);
        imgRegist = itemView.findViewById(R.id.imgRegist);
    }
}
