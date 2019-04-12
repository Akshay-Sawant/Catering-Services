package com.example.cateringapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.cateringapp.R;
import com.example.cateringapp.adapters.DefaultFoodItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class LunchActivity extends AppCompatActivity {

    private static final String TAG = "LunchActivity";
    private List<String> lunchItemNameList, lunchItemsAmountList;
    private RecyclerView lunchRecyclerView;
    DefaultFoodItemAdapter lunchDefaultFoodItemAdapter;
    LinearLayoutManager lunchLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lunchRecyclerView = findViewById(R.id.lunch_recycler_view);

        lunchItemNameList = new ArrayList<>();
        lunchItemsAmountList = new ArrayList<>();

        addLunchDishesToArrayListFunc();
        initializeLunchRecyclerViewFunc();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addLunchDishesToArrayListFunc() {
        lunchItemNameList.add("Lemon Rice");
        lunchItemsAmountList.add("70.00");

        lunchItemNameList.add("Muttor Pulav");
        lunchItemsAmountList.add("90.00");

        lunchItemNameList.add("Roti & Sabji");
        lunchItemsAmountList.add("50.00");

        lunchItemNameList.add("Veg Thali");
        lunchItemsAmountList.add("120.00");

        lunchItemNameList.add("Non Veg Thali");
        lunchItemsAmountList.add("150.00");

        lunchItemNameList.add("Jain Thali");
        lunchItemsAmountList.add("130.00");

        lunchItemNameList.add("Tandoori Roti And Sarso Ka Saag");
        lunchItemsAmountList.add("110.00");

        lunchItemNameList.add("Palak Paneer And Tandoori Roti");
        lunchItemsAmountList.add("150.00");

        lunchItemNameList.add("Gujarati Thali");
        lunchItemsAmountList.add("180.00");

        lunchItemNameList.add("Special Thali");
        lunchItemsAmountList.add("200.00");
    }

    public void initializeLunchRecyclerViewFunc() {
        /*lunchDefaultFoodItemAdapter = new DefaultFoodItemAdapter(this, lunchItemNameList, lunchItemsAmountList);
        lunchLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        lunchRecyclerView.setLayoutManager(lunchLinearLayoutManager);
        lunchRecyclerView.setAdapter(lunchDefaultFoodItemAdapter);*/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
