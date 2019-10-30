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

public class CoursesRegistAdapter extends RecyclerView.Adapter<CoursesRegistHolder> {
    private List<Courses> coursesList;
    private Context context;
    private CoursesDAO coursesDAO;

    public CoursesRegistAdapter(List<Courses> coursesList, Context context) {
        this.coursesList = coursesList;
        this.context = context;
    }

    @NonNull
    @Override
    public CoursesRegistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_courses_regist, parent, false);

        CoursesRegistHolder coursesRegistHolder = new CoursesRegistHolder(view);
        return coursesRegistHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesRegistHolder holder, final int position) {
        final Courses courses = coursesList.get(position);
        coursesDAO = new CoursesDAO(context);

        holder.tvNameCoursesRegist.setText(courses.getTenKhoaHoc());
        holder.tvDateCoursesRegist.setText(courses.getThoiGian());

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Bạn có muốn xóa không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        coursesDAO.deleteCoursesByName(courses.getTenKhoaHoc());
                        coursesList.remove(position);
                        notifyDataSetChanged();
                        Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
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
