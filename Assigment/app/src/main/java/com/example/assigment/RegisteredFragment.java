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

public class RegisteredFragment extends Fragment {
    private RecyclerView rvCoursesRegist;
    private List<Courses> coursesList;
    private CoursesDAO coursesDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registered, container, false);
        rvCoursesRegist = view.findViewById(R.id.rvCoursesRegist);

        coursesList = new ArrayList<>();
        coursesDAO = new CoursesDAO(getContext());
        coursesList = coursesDAO.getAllCoursesRegist();


        CoursesRegistAdapter coursesRegistAdapter = new CoursesRegistAdapter(coursesList, getContext());
        rvCoursesRegist.setAdapter(coursesRegistAdapter);

        LinearLayoutManager vertical = new LinearLayoutManager(getContext());
        rvCoursesRegist.setLayoutManager(vertical);
        return view;
    }
}
