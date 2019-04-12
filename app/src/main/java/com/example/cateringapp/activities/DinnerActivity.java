package com.example.cateringapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cateringapp.R;
import com.example.cateringapp.adapters.DefaultFoodItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class DinnerActivity extends AppCompatActivity {

    private static final String TAG = "DinnerActivity";
    private List<String> dinnerItemNamesList, dinnerItemAmountList;
    private RecyclerView dinnerRecyclerView;
    DefaultFoodItemAdapter dinnerDefaultFoodItemAdapter;
    LinearLayoutManager dinnerLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dinnerRecyclerView = findViewById(R.id.dinner_recycler_view);

        dinnerItemNamesList = new ArrayList<>();
        dinnerItemAmountList = new ArrayList<>();

        addDinnerItemsToArrayLisFunc();
        initializeDinnerRecyclerViewFunc();
    }

    public void addDinnerItemsToArrayLisFunc() {
        dinnerItemNamesList.add("Paella with Rice");
        dinnerItemAmountList.add("180.00");

        dinnerItemNamesList.add("Seared Ahi Tuna");
        dinnerItemAmountList.add("190.00");

        dinnerItemNamesList.add("Chicken Pot Pie or Chicken a la Ritz");
        dinnerItemAmountList.add("230.00");

        dinnerItemNamesList.add("Herb Mashed Potatoes");
        dinnerItemAmountList.add("200.00");

        dinnerItemNamesList.add("Oven Browned Rosemary Potatoes");
        dinnerItemAmountList.add("210.00");

        dinnerItemNamesList.add("Portobello Mushrooms and Herb Risotto");
        dinnerItemAmountList.add("250.00");

        dinnerItemNamesList.add("Potatoes Anna");
        dinnerItemAmountList.add("190.00");

        dinnerItemNamesList.add("Broccoli and Pimentos");
        dinnerItemAmountList.add("230.00");

        dinnerItemNamesList.add("Herb Tortellini Parmarosa");
        dinnerItemAmountList.add("270.00");

        dinnerItemNamesList.add("Classic Waldorf Salad");
        dinnerItemAmountList.add("160.00");

        dinnerItemNamesList.add("Grilled Vegetables in a Vodka Vinaigrette");
        dinnerItemAmountList.add("220.00");

        dinnerItemNamesList.add("Kentucky Bibb Lettuce and Strawberry Salad");
        dinnerItemAmountList.add("230.00");

        dinnerItemNamesList.add("Mocha Dacquoise");
        dinnerItemAmountList.add("290.00");

        dinnerItemNamesList.add("Chocolate-Raspberry Napoleon");
        dinnerItemAmountList.add("310.00");

        dinnerItemNamesList.add("Macadamia Nut Torte");
        dinnerItemAmountList.add("350.00");
    }

    public void initializeDinnerRecyclerViewFunc() {
        /*dinnerDefaultFoodItemAdapter = new DefaultFoodItemAdapter(this, dinnerItemNamesList, dinnerItemAmountList);
        dinnerLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        dinnerRecyclerView.setLayoutManager(dinnerLinearLayoutManager);
        dinnerRecyclerView.setAdapter(dinnerDefaultFoodItemAdapter);*/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
