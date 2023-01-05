package com.example.projectkursuspti;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyCourseFragment extends Fragment {

    TextView onGoing;
    ImageView btn_notification, btn_profile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_course, container, false);

        onGoing = view.findViewById(R.id.ongoing);
        btn_notification = view.findViewById(R.id.btn_notification);
        btn_profile = view.findViewById(R.id.btn_profile);

        onGoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment CourseFrag = new CourseFragment();
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
        return view;
    }
}