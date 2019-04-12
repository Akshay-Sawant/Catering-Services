package com.example.cateringapp.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.cateringapp.R;
import com.example.cateringapp.adapters.DefaultFoodItemAdapter;

import java.util.ArrayList;

public class BreakFastActivity extends AppCompatActivity {

    private static final String TAG = "BreakFastFragment";
    private ArrayList<String> mBreakFastNames, mBreakFastPrice;
    private RecyclerView breakFastRecyclerView;
    DefaultFoodItemAdapter breakfastDefaultFoodItemAdapter;
    LinearLayoutManager breakfastLinearLayoutManager;
    CoordinatorLayout breakfastCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break_fast);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        breakfastCoordinatorLayout = findViewById(R.id.breakfast_root_layout);
        breakFastRecyclerView = findViewById(R.id.break_fast_recycle);

        mBreakFastNames = new ArrayList<>();
        mBreakFastPrice = new ArrayList<>();

        addBreakFastDishesToArrayListFunc();
        initializeBreakFastRecyclerView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addBreakFastDishesToArrayListFunc() {
        mBreakFastNames.add("Butter Idli");
        mBreakFastPrice.add("29.00");

        mBreakFastNames.add("Mendu Vada");
        mBreakFastPrice.add("65.00");

        mBreakFastNames.add("Uttappa");
        mBreakFastPrice.add("85.00");

        mBreakFastNames.add("Batata Vada");
        mBreakFastPrice.add("50.00");

        mBreakFastNames.add("Samosa Pav");
        mBreakFastPrice.add("30.00");

        mBreakFastNames.add("Vada Pav");
        mBreakFastPrice.add("30.00");

        mBreakFastNames.add("Usal Pav");
        mBreakFastPrice.add("70.00");

        mBreakFastNames.add("Misal Pav");
        mBreakFastPrice.add("80.00");

        mBreakFastNames.add("Toast Sandwich");
        mBreakFastPrice.add("30.00");

        mBreakFastNames.add("Cheese Grilled Sandwich");
        mBreakFastPrice.add("130.00");
    }

    public void initializeBreakFastRecyclerView() {
        breakfastDefaultFoodItemAdapter = new DefaultFoodItemAdapter(this, mBreakFastNames, mBreakFastPrice, breakfastCoordinatorLayout);
        breakfastLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        breakFastRecyclerView.setLayoutManager(breakfastLinearLayoutManager);
        breakFastRecyclerView.setAdapter(breakfastDefaultFoodItemAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
