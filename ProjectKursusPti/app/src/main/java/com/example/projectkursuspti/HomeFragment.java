package com.example.projectkursuspti;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class HomeFragment extends Fragment {

    LinearLayout machine_learning_course, machine_learning_course2, algoritmacourse, algoritmacourse2, jarkomcourse, jarkomcourse2;
    ImageView btn_notification, btn_profile;
    TextView namalengkap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

//        String userDataLogin = this.getArguments().getString()
        btn_notification = view.findViewById(R.id.btn_notification);
        btn_profile = view.findViewById(R.id.btn_profile);
        namalengkap = view.findViewById(R.id.namalengkap);
        namalengkap.setText("Hi "+this.getArguments().getString("username")+"\n Lets Start Learning");

        machine_learning_course = view.findViewById(R.id.machine_learning_course);
        machine_learning_course2 = view.findViewById(R.id.machine_learning_course2);
        algoritmacourse = view.findViewById(R.id.algoritmacourse);
        algoritmacourse2 = view.findViewById(R.id.algoritmacourse2);
        jarkomcourse = view.findViewById(R.id.jarkomcourse);
        jarkomcourse2 = view.findViewById(R.id.jarkomcourse2);

        machine_learning_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment DetailFrag = new DetailCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,DetailFrag).commit();
            }
        });
        machine_learning_course2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment DetailFrag = new DetailCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,DetailFrag).commit();
            }
        });
        algoritmacourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment DetailFrag = new DetailAlgoCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,DetailFrag).commit();
            }
        });algoritmacourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment DetailFrag = new DetailAlgoCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,DetailFrag).commit();
            }
        });jarkomcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment DetailFrag = new DetailJarkomCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,DetailFrag).commit();
            }
        });jarkomcourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment DetailFrag = new DetailJarkomCourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,DetailFrag).commit();
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
        return view;
    }
}