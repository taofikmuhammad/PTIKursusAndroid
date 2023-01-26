package com.example.projectkursuspti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen1 extends AppCompatActivity {
    private static int DELAY_TIME =4000;
    Animation topAnim, botAnim;
    ImageView imageView;
    TextView titlesplash;
    Button btnsplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = findViewById(R.id.imgsplash);
        titlesplash = findViewById(R.id.titlesplash);
        btnsplash = findViewById(R.id.btnsplash);

        imageView.setAnimation(topAnim);
        titlesplash.setAnimation(topAnim);
        btnsplash.setAnimation(botAnim);

        btnsplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashScreen1.this, SplashScreen2.class);
                startActivity(intent);
                finish();
            }
        });

    }
}