package com.example.projectkursuspti;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DetailAlgoCourseFragment extends Fragment {
    TextView btn_checkout;
    LinearLayout materi_pendahuluan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_algo_course, container, false);
        btn_checkout = view.findViewById(R.id.btn_checkout);
        materi_pendahuluan = view.findViewById(R.id.materi_pendahuluan);
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment ProfileFragment = new PaymentFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frame_layout,ProfileFragment).commit();
            }
        });
        materi_pendahuluan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment ProfileFragment = new MateriFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.frame_layout,ProfileFragment).commit();
            }
        });
        return view;
    }
}