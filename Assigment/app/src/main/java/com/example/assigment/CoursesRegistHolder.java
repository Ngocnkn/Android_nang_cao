package com.example.assigment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CoursesRegistHolder extends RecyclerView.ViewHolder {
    public TextView tvNameCoursesRegist, tvDateCoursesRegist;
    public ImageView imgDelete;

    public CoursesRegistHolder(@NonNull View itemView) {
        super(itemView);
        tvNameCoursesRegist = itemView.findViewById(R.id.tvNameCoursesRegist);
        tvDateCoursesRegist = itemView.findViewById(R.id.tvDateCoursesRegist);
        imgDelete = itemView.findViewById(R.id.imgDelete);
    }
}
