package com.example.projectkursuspti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projectkursuspti.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide(); // hide the title bar
        replaceFragment(new HomeFragment());



        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());

                    break;
                case R.id.course:
                    replaceFragment(new CourseFragment());
                    break;
                case R.id.tugas:
                    replaceFragment(new NoTasksFragment());
                    break;
                case R.id.pembayaran:
                    replaceFragment(new PaymentFragment());
                    break;
                case R.id.profil:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        Bundle bundle = getIntent().getExtras();
        Intent i = getIntent();
        String username = i.getStringExtra("username");
        String password = i.getStringExtra("password");
        String email = i.getStringExtra("email");
        String namalengkap = i.getStringExtra("namalengkap");
//        Bundle bundle = new Bundle();
//        String msg = "Randy Azhar Alman Faluthi";
        bundle.putString("username", username);
        bundle.putString("password", password);
        bundle.putString("email", email);
        bundle.putString("namalengkap", namalengkap);
        FragmentManager fragmentManager = getSupportFragmentManager();;
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }

}