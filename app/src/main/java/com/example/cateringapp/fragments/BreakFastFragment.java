package com.example.cateringapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cateringapp.R;
import com.example.cateringapp.activities.MyFoodCartActivity;
import com.example.cateringapp.adapters.AddToCartAdapter;
import com.example.cateringapp.adapters.DefaultFoodItemAdapter;
import com.example.cateringapp.models.FoodCartModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BreakFastFragment extends Fragment {

    private ArrayList<String> mBreakFastNames, mBreakFastPrice;
    private RecyclerView breakFastRecyclerView;
    DefaultFoodItemAdapter breakfastDefaultFoodItemAdapter;
    LinearLayoutManager breakfastLinearLayoutManager;
    CoordinatorLayout breakfastCoordinatorLayout;
    private ArrayList<FoodCartModel> breakFastArrayList;
    Button addToCartButton;

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_break_fast, container, false);
        getActivity().setTitle(R.string.breakfast);

//        breakfastCoordinatorLayout = view.findViewById(R.id.breakfast_root_layout);
        breakFastRecyclerView = view.findViewById(R.id.break_fast_recycler_view);
        addToCartButton = view.findViewById(R.id.add_to_cart_button);

        breakfastDefaultFoodItemAdapter = new DefaultFoodItemAdapter(getActivity(), null, null, null);

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyFoodCartActivity.class);
//                intent.putExtra("food_name", breakfastDefaultFoodItemAdapter.arrayList);
                startActivity(intent);
            }
        });

        mBreakFastNames = new ArrayList<>();
        mBreakFastPrice = new ArrayList<>();
        breakFastArrayList = new ArrayList<>();

        addBreakFastDishesToArrayListFunc();
        initializeBreakFastRecyclerView();

        return view;
    }

    public void addBreakFastDishesToArrayListFunc() {
        mBreakFastNames.add("Butter Idli");
        mBreakFastPrice.add("29");

        mBreakFastNames.add("Mendu Vada");
        mBreakFastPrice.add("65");

        mBreakFastNames.add("Uttappa");
        mBreakFastPrice.add("85");

        mBreakFastNames.add("Batata Vada");
        mBreakFastPrice.add("50");

        mBreakFastNames.add("Samosa Pav");
        mBreakFastPrice.add("30");

        mBreakFastNames.add("Vada Pav");
        mBreakFastPrice.add("30");

        mBreakFastNames.add("Usal Pav");
        mBreakFastPrice.add("70");

        mBreakFastNames.add("Misal Pav");
        mBreakFastPrice.add("80");

        mBreakFastNames.add("Toast Sandwich");
        mBreakFastPrice.add("30");

        mBreakFastNames.add("Cheese Grilled Sandwich");
        mBreakFastPrice.add("130");
    }

    public void initializeBreakFastRecyclerView() {
        breakfastDefaultFoodItemAdapter = new DefaultFoodItemAdapter(getActivity(), mBreakFastNames, mBreakFastPrice, null);
        breakfastLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        breakFastRecyclerView.setLayoutManager(breakfastLinearLayoutManager);
        breakFastRecyclerView.setAdapter(breakfastDefaultFoodItemAdapter);
    }

    public void insertDataFunc(String dishName, String dishAmount) {
        breakFastArrayList.add(new FoodCartModel(dishName, dishAmount));
        breakfastDefaultFoodItemAdapter.notifyItemInserted(breakFastArrayList.size());
    }
}
