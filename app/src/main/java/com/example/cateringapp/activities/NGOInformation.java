package com.example.cateringapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.cateringapp.R;
import com.example.cateringapp.fragments.HomeFragment;

public class NGOInformation extends AppCompatActivity implements View.OnClickListener {

    private Button getDetails;
    Snackbar addToCartSnackbar;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoinformation);

        getDetails = findViewById(R.id.NGO_contact_button);
        scrollView = findViewById(R.id.scroll_view_layout);
        initializeEditTextFunc();
    }

    public void initializeEditTextFunc() {
        getDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Your Method");
        builder.setMessage("Which payment method would you like to follow from the following options");
        builder.setPositiveButton("CASH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                snackBarFunc();
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                startActivity(new Intent(NGOInformation.this, HomeScreenActivity.class));
            }
        });
        builder.setNegativeButton("CARD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(NGOInformation.this, MyFoodCartActivity.class));
            }
        });
        builder.show();
    }

    public void snackBarFunc() {
        addToCartSnackbar = Snackbar
                .make(scrollView, "Payment Done Successfully", Snackbar.LENGTH_INDEFINITE);
                /*.setAction("View Cart", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });*/
        addToCartSnackbar.setActionTextColor(Color.WHITE);


        View snackbarView = addToCartSnackbar.getView();
        snackbarView.setBackgroundColor(scrollView.getResources().getColor(R.color.blue));
        TextView snackbarTextView = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        snackbarTextView.setTextColor(Color.WHITE);
        addToCartSnackbar.show();
    }
}
