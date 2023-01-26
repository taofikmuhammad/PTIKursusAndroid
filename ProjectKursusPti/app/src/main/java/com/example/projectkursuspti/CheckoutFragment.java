package com.example.projectkursuspti;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


public class CheckoutFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false);

    }
//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.ovo:
//                if (checked)
//                    // Pirates are the best
//                    break;
//            case R.id.dana:
//                if (checked)
//                    // Ninjas rule
//                    break;
//            case R.id.gopay:
//                if (checked)
//                    // Ninjas rule
//                    break;
//        }
//    }
}