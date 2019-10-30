package com.example.assigment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotRegisteredFragment extends Fragment {
    private RecyclerView rvCourse;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_notregistered, container, false);

        rvCourse=view.findViewById(R.id.rvCourses);

        List<Courses> coursesList=new ArrayList<>();
        coursesList.add(new Courses("Android nâng cao","07-12-2018 - 07-3-2019"));
        coursesList.add(new Courses("Tiếng anh","08-09-2019 - 08-11-2019"));
        coursesList.add(new Courses("Lập trình java 2","09-10-2019 - 09-11-2019"));
        coursesList.add(new Courses("Lập trình android","10-10-2019 - 10-11-2019"));
        coursesList.add(new Courses("Dự án mẫu","10-10-2019 - 10-11-2019"));
        coursesList.add(new Courses("Thiết kế trang web","21-10-2019 - 21-12-2019"));

        CoursesAdapter coursesAdapter = new CoursesAdapter(coursesList, getContext());
        rvCourse.setAdapter(coursesAdapter);

        LinearLayoutManager vertical = new LinearLayoutManager(getContext());
        rvCourse.setLayoutManager(vertical);
        return view;
    }

}
