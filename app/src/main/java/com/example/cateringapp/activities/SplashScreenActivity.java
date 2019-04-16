package com.example.cateringapp.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cateringapp.R;
import com.example.cateringapp.utils.PrefManager;

import java.util.HashMap;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Anonymous Class Declaration
                if (PrefManager.getUsername(SplashScreenActivity.this).equals("") && PrefManager.getPassword(SplashScreenActivity.this).equals("")) {
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, HomeScreenActivity.class));
                    finish();
                }
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
