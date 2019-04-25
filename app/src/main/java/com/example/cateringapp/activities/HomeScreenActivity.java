package com.example.cateringapp.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringapp.R;
import com.example.cateringapp.fragments.AboutUsFragment;
import com.example.cateringapp.fragments.DatePickerFragment;
import com.example.cateringapp.fragments.HomeFragment;
import com.example.cateringapp.fragments.InfoFragment;
import com.example.cateringapp.fragments.MenuFragment;
import com.example.cateringapp.fragments.SettingsFragment;
import com.example.cateringapp.fragments.TimePickerFragment;
import com.example.cateringapp.utils.PrefManager;
import com.github.clans.fab.FloatingActionButton;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Stack;

public class HomeScreenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FloatingActionButton emailFloatingActionButton, fbFloatingActionButton, whatsappFloatingActionButton, contactUsFloatingActionButton, locateUsFloatingActionButton;
    TextView usernameText, serviceTypeTextView, scheduleServiceTextView, scheduleOrderTextView, scheduledDateTextView, scheduledTimeTextView;

    private Intent sendIntent;
    private Stack<Fragment> fragmentStack;
    private FragmentManager fragmentManager;
    private AlertDialog.Builder builder;
    private PrefManager prefManager;
    private Context homeScreenActivityContext;
    private EditText eventNameDeliveryWhenEditText, noOfGuestsEditText, noOfPeopleEditText;
    private DatePicker datePickerDeliveryWhen;
    private Calendar calendarDeliveryWhen;
    private ImageView scheduleDateImageView, scheduleTimeImageView;
    private Button okChooserBtn, cancelChooserBtn;
    private Spinner deliveryServiceTypeSpinner;
    private int year, month, day;
    private ArrayAdapter<CharSequence> charSequenceArrayAdapter;
    private String spinnerLabel = "";

    CheckBox breakFastCheckBox, lunchCheckBox, dinnerCheckBox, asapCheckBox;

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
                chooserDialogFunc();
                break;
            case R.id.about_us:
                loadHomeScreenActivityFragmentsFunc(new InfoFragment());
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

    public void chooserDialogFunc() {

        final AlertDialog.Builder alert = new AlertDialog.Builder(HomeScreenActivity.this);
        View view = getLayoutInflater().inflate(R.layout.chooser_dialog, null);

        okChooserBtn = view.findViewById(R.id.ok_chooser_btn);
        cancelChooserBtn = view.findViewById(R.id.cancel_chooser_btn);
        deliveryServiceTypeSpinner = view.findViewById(R.id.delivery_service_type_spinner);
        //Binding SERVICE TYPE text view
        serviceTypeTextView = view.findViewById(R.id.tiffin_service_type);

        //Binding SERVICE TYPE check box
        breakFastCheckBox = view.findViewById(R.id.break_fast_service);
        lunchCheckBox = view.findViewById(R.id.lunch_service);
        dinnerCheckBox = view.findViewById(R.id.dinner_service);

        //Binding EVENT NAME edit text
        eventNameDeliveryWhenEditText = view.findViewById(R.id.event_name_edit_text);
        noOfGuestsEditText = view.findViewById(R.id.no_of_guests_edit_text);
        noOfPeopleEditText = view.findViewById(R.id.no_of_people_edit_text);

        //Binding SCHEDULE SERVICE text view
        scheduleServiceTextView = view.findViewById(R.id.schedule_tiffin_service);

        //Binding SCHEDULE SERVICE checkbox
        asapCheckBox = view.findViewById(R.id.asap_tiffin_service);

        //Binding SCHEDULE AN ORDER  DATE & TIME text view
        scheduleOrderTextView = view.findViewById(R.id.schedule_an_order_text_view);
        scheduledDateTextView = view.findViewById(R.id.schedule_order_date);
        scheduledTimeTextView = view.findViewById(R.id.schedule_order_time);

        //Binding SCHEDULE DATE & TIME image view
        scheduleDateImageView = view.findViewById(R.id.schedule_date_icon);
        scheduleTimeImageView = view.findViewById(R.id.schedule_time_icon);

        scheduledDateTextView.setOnClickListener(this);
        scheduledTimeTextView.setOnClickListener(this);
        scheduleDateImageView.setOnClickListener(this);
        scheduleTimeImageView.setOnClickListener(this);

        alert.setView(view);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCancelable(false);

        if (deliveryServiceTypeSpinner != null) {
            deliveryServiceTypeSpinner.setOnItemSelectedListener(this);
        }

        charSequenceArrayAdapter = ArrayAdapter.createFromResource(HomeScreenActivity.this, R.array.services,
                android.R.layout.simple_spinner_dropdown_item);
        charSequenceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (deliveryServiceTypeSpinner != null) {
            deliveryServiceTypeSpinner.setAdapter(charSequenceArrayAdapter);
        }

        okChooserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (spinnerLabel.equals("Tiffin")) {
                    if (!breakFastCheckBox.isChecked() || !lunchCheckBox.isChecked() || !dinnerCheckBox.isChecked()
                            && noOfPeopleEditText.getText().equals("") && scheduledDateTextView.getText().equals("") && scheduledTimeTextView.getText().equals("")) {
                        Toast.makeText(homeScreenActivityContext, "Above mentioned fields cannot be empty", Toast.LENGTH_SHORT).show();
                    } else {
                        if (breakFastCheckBox.isChecked()) {
                            PrefManager.setTiffinServiceType(homeScreenActivityContext, "BreakFast");
                        }
                        if (lunchCheckBox.isChecked()) {
                            PrefManager.setTiffinServiceType(homeScreenActivityContext, "Lunch");
                        }
                        if (dinnerCheckBox.isChecked()) {
                            PrefManager.setTiffinServiceType(homeScreenActivityContext, "Dinner");
                        }
                        if (asapCheckBox.isChecked()) {
                            PrefManager.setScheduleService(homeScreenActivityContext, "ASAP");
                        }
                        PrefManager.setNoOfPeople(homeScreenActivityContext, noOfPeopleEditText.getText().toString().trim());
                        PrefManager.setOrderDate(homeScreenActivityContext, scheduledDateTextView.getText().toString());
                        PrefManager.setOrderTime(homeScreenActivityContext, scheduledTimeTextView.getText().toString());

                        loadHomeScreenActivityFragmentsFunc(new MenuFragment());
                        alertDialog.dismiss();
                    }
                }
                if (spinnerLabel.equals("Events")) {
                    if (!(noOfGuestsEditText.getText().equals("") && eventNameDeliveryWhenEditText.getText().equals("")
                            && scheduledDateTextView.getText().equals("") && scheduledTimeTextView.getText().equals(""))) {
                        PrefManager.setEventName(homeScreenActivityContext, eventNameDeliveryWhenEditText.getText().toString().trim());
                        PrefManager.setNoOfGuests(homeScreenActivityContext, noOfGuestsEditText.getText().toString().trim());

                        PrefManager.setOrderDate(homeScreenActivityContext, scheduledDateTextView.getText().toString());
                        PrefManager.setOrderTime(homeScreenActivityContext, scheduledTimeTextView.getText().toString());

                        loadHomeScreenActivityFragmentsFunc(new MenuFragment());
                        alertDialog.dismiss();
                    } else {
                        Toast.makeText(homeScreenActivityContext, "Above mentioned fields cannot be empty", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cancelChooserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    public void chooserButtonFunc() {

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
            case R.id.schedule_date_icon:
                showDatePickerDialog();
                break;
            case R.id.schedule_order_date:
                showDatePickerDialog();
                break;
            case R.id.schedule_time_icon:
                showTimePickerDialog();
                break;
            case R.id.schedule_order_time:
                showTimePickerDialog();
                break;
        }
    }

    public void showDatePickerDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.date_picker));
    }

    public void showTimePickerDialog() {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.time_picker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        // The month integer returned by the date picker starts counting at 0
        // for January, so you need to add 1 to show months starting at 1.
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        // Assign the concatenated strings to dateMessage.
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
//        Toast.makeText(this, getString(R.string.date) + dateMessage, Toast.LENGTH_SHORT).show();
        scheduledDateTextView.setText(dateMessage);
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string);
//        Toast.makeText(this, getString(R.string.time) + timeMessage, Toast.LENGTH_SHORT).show();
        scheduledTimeTextView.setText(timeMessage);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerLabel = parent.getItemAtPosition(position).toString();
        if (spinnerLabel.equals("Tiffin")) {
            PrefManager.setServiceType(HomeScreenActivity.this, spinnerLabel);
            serviceTypeTextView.setVisibility(View.VISIBLE);
            breakFastCheckBox.setVisibility(View.VISIBLE);
            lunchCheckBox.setVisibility(View.VISIBLE);
            dinnerCheckBox.setVisibility(View.VISIBLE);
            scheduleServiceTextView.setVisibility(View.VISIBLE);
            asapCheckBox.setVisibility(View.VISIBLE);
            noOfPeopleEditText.setVisibility(View.VISIBLE);

            eventNameDeliveryWhenEditText.setVisibility(View.GONE);
            noOfGuestsEditText.setVisibility(View.GONE);
//            getActivity().getSupportFragmentManager().popBackStack();
        } else {
            PrefManager.setServiceType(HomeScreenActivity.this, spinnerLabel);
            serviceTypeTextView.setVisibility(View.GONE);
            breakFastCheckBox.setVisibility(View.GONE);
            lunchCheckBox.setVisibility(View.GONE);
            dinnerCheckBox.setVisibility(View.GONE);
            scheduleServiceTextView.setVisibility(View.GONE);
            asapCheckBox.setVisibility(View.GONE);
            noOfPeopleEditText.setVisibility(View.GONE);

            eventNameDeliveryWhenEditText.setVisibility(View.VISIBLE);
            noOfGuestsEditText.setVisibility(View.VISIBLE);
//            getActivity().getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
