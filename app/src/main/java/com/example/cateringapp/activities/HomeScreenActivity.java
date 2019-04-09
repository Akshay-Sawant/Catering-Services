package com.example.cateringapp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.drm.DrmStore;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cateringapp.R;
import com.example.cateringapp.fragments.AboutUsFragment;
import com.example.cateringapp.fragments.ContactUsFragment;
import com.example.cateringapp.fragments.GalleryFragment;
import com.example.cateringapp.fragments.HomeFragment;
import com.example.cateringapp.fragments.MenuFragment;

public class HomeScreenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FloatingActionButton emailFloatingActionButton;
    TextView usernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bindingViewFunc();

        /*String emailFromIntent = getIntent().getStringExtra("EMAIL");
        usernameText.setText(emailFromIntent);*/

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }

    public void bindingViewFunc() {
        //usernameText = findViewById(R.id.user_name_text);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav_view);
        emailFloatingActionButton = findViewById(R.id.email_fab);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.blue));
        actionBarDrawerToggle.syncState();

        emailFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailFunc();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                break;
            case R.id.menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MenuFragment()).commit();
                break;
            case R.id.gallery:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new GalleryFragment()).commit();
                break;
            case R.id.contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ContactUsFragment()).commit();
                break;
            case R.id.about_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new AboutUsFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressLint("IntentReset")
    public void emailFunc() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to = {"shobhachaudhary421@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Catering Service Feedback");
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Send Feedback: "));
    }
}
