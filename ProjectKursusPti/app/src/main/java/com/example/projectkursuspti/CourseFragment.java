package com.example.projectkursuspti;

import android.media.MediaCodec;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CourseFragment extends Fragment {

    TextView mycourse;
    ImageView btn_notification, btn_profile;
    LinearLayout machine_learning_course, algoritmacourse, jarkomcourse;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        mycourse = view.findViewById(R.id.mycourse);
        btn_notification = view.findViewById(R.id.btn_notification);
        machine_learning_course = view.findViewById(R.id.machine_learning_course);
        algoritmacourse = view.findViewById(R.id.algoritmacourse);
        jarkomcourse = view.findViewById(R.id.jarkomcourse);
        btn_profile = view.findViewById(R.id.btn_profile);
        mycourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment CourseFrag = new MyCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,CourseFrag).commit();
            }
        });
        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment NotificationFragment = new NotificationFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frame_layout,NotificationFragment).commit();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment ProfileFragment = new ProfileFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frame_layout,ProfileFragment).commit();
            }
        });
        machine_learning_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment ProfileFragment = new DetailCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frame_layout,ProfileFragment).commit();
            }
        });algoritmacourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment ProfileFragment = new DetailAlgoCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frame_layout,ProfileFragment).commit();
            }
        });jarkomcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment ProfileFragment = new DetailJarkomCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frame_layout,ProfileFragment).commit();
            }
        });

        return view;
    }
}