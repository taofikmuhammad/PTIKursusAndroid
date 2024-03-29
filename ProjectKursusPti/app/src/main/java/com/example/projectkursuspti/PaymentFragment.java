package com.example.projectkursuspti;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class PaymentFragment extends Fragment {

    Button kursuslain, btn_checkout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_payment, container, false);

        kursuslain = view.findViewById(R.id.kursuslain);
        btn_checkout = view.findViewById(R.id.btn_checkout);
        kursuslain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment CourseFrag = new CourseFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,CourseFrag).commit();
            }
        });
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment CourseFrag = new CheckoutFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container,CourseFrag).commit();
            }
        });
        return view;
    }
}