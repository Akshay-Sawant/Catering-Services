package com.example.cateringapp.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringapp.R;
import com.example.cateringapp.fragments.AboutUsFragment;
import com.example.cateringapp.fragments.HomeFragment;
import com.example.cateringapp.fragments.MenuFragment;
import com.example.cateringapp.fragments.SettingsFragment;
import com.example.cateringapp.utils.PrefManager;
import com.github.clans.fab.FloatingActionButton;

import java.util.HashMap;
import java.util.Stack;

public class HomeScreenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FloatingActionButton emailFloatingActionButton, fbFloatingActionButton, whatsappFloatingActionButton, contactUsFloatingActionButton, locateUsFloatingActionButton;
    TextView usernameText;
    private Intent sendIntent;
    private Stack<Fragment> fragmentStack;
    private FragmentManager fragmentManager;
    private AlertDialog.Builder builder;
    private PrefManager prefManager;
    private Context homeScreenActivityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        homeScreenActivityContext = HomeScreenActivity.this;
        fragmentManager = getSupportFragmentManager();
        prefManager = new PrefManager(HomeScreenActivity.this);

        bindingViewFunc();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, new HomeFragment()).commit();
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
        fbFloatingActionButton = findViewById(R.id.facebook_fab);
        whatsappFloatingActionButton = findViewById(R.id.whatsapp_fab);
        contactUsFloatingActionButton = findViewById(R.id.contact_us_fab);
        locateUsFloatingActionButton = findViewById(R.id.locate_us_fab);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.blue));
        actionBarDrawerToggle.syncState();

        /**
         * Expandable Floating Action Button
         *
         * Email
         * Facebook
         * Whatsapp
         * Mobile Number
         * Location
         * */
        emailFloatingActionButton.setOnClickListener(this);
        fbFloatingActionButton.setOnClickListener(this);
        whatsappFloatingActionButton.setOnClickListener(this);
        contactUsFloatingActionButton.setOnClickListener(this);
        locateUsFloatingActionButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.food_cart:
                startActivity(new Intent(homeScreenActivityContext, MyFoodCartActivity.class));
                break;
            case R.id.user_profile:
                startActivity(new Intent(homeScreenActivityContext, UserProfileActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                loadHomeScreenActivityFragmentsFunc(new HomeFragment());
                break;
            case R.id.menu:
                loadHomeScreenActivityFragmentsFunc(new MenuFragment());
                break;
            case R.id.about_us:
                loadHomeScreenActivityFragmentsFunc(new AboutUsFragment());
                break;
            case R.id.settings:
                loadHomeScreenActivityFragmentsFunc(new SettingsFragment());
                break;
            case R.id.logout:
                logoutFunc();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public void loadHomeScreenActivityFragmentsFunc(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.email_fab:
                emailFunc();
                break;
            case R.id.facebook_fab:
                facebookFunc();
                break;
            case R.id.whatsapp_fab:
                whatsappFunc();
                break;
            case R.id.contact_us_fab:
                mobileFunc();
                break;
            case R.id.locate_us_fab:
                locationFunc();
                break;
        }
    }

    @SuppressLint("IntentReset")
    public void emailFunc() {
        sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setData(Uri.parse("mailto:"));
        String[] to = {"shobhachaudhary421@gmail.com"};
        sendIntent.putExtra(Intent.EXTRA_EMAIL, to);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Catering Service Feedback");
        sendIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(sendIntent, "Send Feedback: "));
    }

    public void mobileFunc() {
        startActivity(
                new Intent(Intent.ACTION_DIAL).setData(
                        Uri.parse("tel:" + "8828088787")
                )
        );
    }

    public void whatsappFunc() {
        sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }

    public void facebookFunc() {
        sendIntent = new Intent("android.intent.action.VIEW");
        sendIntent.setData(Uri.parse("https://www.facebook.com/swara.chaudhary.372"));
        startActivity(sendIntent);
    }

    public void locationFunc() {
        sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:19.098809,72.8493333"));
        startActivity(sendIntent);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() == 0 || toolbar.getTitle().equals("Home")
                || toolbar.getTitle().equals("Menu") || toolbar.getTitle().equals("About Us") || toolbar.getTitle().equals("Settings")) {
            //if size is `1` it means first fragment is visible and we can exit from application
            appCloseConfirmationFunc();
        } else {
            super.onBackPressed();
            /**
             * 1. Shared Preferences (Cache)
             * 2. Internal (Primary)
             * 3. External (Secondary/SD Card)
             * 4. SQLite
             * 5. Networks (API)
             * */
        }
    }

    public void appCloseConfirmationFunc() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_close_alert_title);
        builder.setMessage(R.string.app_close_alert_message);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.yes_button_of_alert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.no_button_of_alert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void logoutFunc() {
        builder = new AlertDialog.Builder(HomeScreenActivity.this);
        builder.setMessage("Are you sure you want to logout?");
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.yes_button_of_alert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                prefManager.logoutUser(HomeScreenActivity.this);
                startActivity(new Intent(HomeScreenActivity.this, LoginActivity.class));
                finish();
            }
        });
        builder.setNegativeButton(R.string.no_button_of_alert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
