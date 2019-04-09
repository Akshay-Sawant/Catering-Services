package com.example.cateringapp.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cateringapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(SplashScreenActivity.this, HomeScreenActivity.class);

                //Anonymous Class Declaration
                startActivity(new Intent(SplashScreenActivity.this, WelcomeActivity.class));
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
