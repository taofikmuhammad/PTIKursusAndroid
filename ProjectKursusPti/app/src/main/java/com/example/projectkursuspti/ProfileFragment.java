package com.example.projectkursuspti;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;


public class ProfileFragment extends Fragment {
    TextView namalengkaptop,emailtop, namalengkap, email, username, password;
    LinearLayout btn_update, btn_logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        namalengkap = view.findViewById(R.id.namalengkap);
        namalengkaptop = view.findViewById(R.id.namalengkaptop);
        email = view.findViewById(R.id.email);
        emailtop = view.findViewById(R.id.emailtop);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        btn_logout = view.findViewById(R.id.btn_logout);
       btn_update = view.findViewById(R.id.btn_update);
        namalengkap.setText(this.getArguments().getString("namalengkap"));
        namalengkaptop.setText(this.getArguments().getString("namalengkap"));
        email.setText(this.getArguments().getString("email"));
        emailtop.setText(this.getArguments().getString("email"));
        username.setText(this.getArguments().getString("username"));
        password.setText(this.getArguments().getString("password"));
//        btn_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment CourseFrag = new UpdateProfileFragment();
//                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
//                fm.replace(R.id.container,CourseFrag).commit();
//            }
//        });

        return view;
    }

}