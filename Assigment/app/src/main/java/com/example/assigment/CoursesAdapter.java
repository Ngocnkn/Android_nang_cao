package com.example.assigment;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesHolder> {
    private List<Courses> coursesList;
    private Context context;
    private CoursesDAO coursesDAO;

    public CoursesAdapter(List<Courses> coursesList, Context context) {
        this.coursesList = coursesList;
        this.context = context;
    }

    @NonNull
    @Override
    public CoursesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_courses, parent, false);

        CoursesHolder coursesHolder = new CoursesHolder(view);
        return coursesHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesHolder holder, int position) {
        final Courses courses = coursesList.get(position);

        holder.tvNameCourses.setText(courses.getTenKhoaHoc());
        holder.tvDateCourse.setText(courses.getThoiGian());

        holder.imgRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coursesDAO = new CoursesDAO(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Bạn có muốn thêm không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        long result = coursesDAO.insertCourses(courses);
                        if (result > 0) {
                            Toast.makeText(context, "Thêm khóa học thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Thêm khóa học thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }
}
