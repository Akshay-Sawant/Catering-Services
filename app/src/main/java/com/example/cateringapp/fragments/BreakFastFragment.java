package com.example.cateringapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringapp.R;
import com.example.cateringapp.adapters.DefaultFoodItemAdapter;

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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_break_fast, container, false);
        getActivity().setTitle(R.string.breakfast);

        breakfastCoordinatorLayout = view.findViewById(R.id.breakfast_root_layout);
        breakFastRecyclerView = view.findViewById(R.id.break_fast_recycler_view);

        mBreakFastNames = new ArrayList<>();
        mBreakFastPrice = new ArrayList<>();

        addBreakFastDishesToArrayListFunc();
        initializeBreakFastRecyclerView();

        return view;
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
        breakfastDefaultFoodItemAdapter = new DefaultFoodItemAdapter(getActivity(), mBreakFastNames, mBreakFastPrice, breakfastCoordinatorLayout);
        breakfastLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        breakFastRecyclerView.setLayoutManager(breakfastLinearLayoutManager);
        breakFastRecyclerView.setAdapter(breakfastDefaultFoodItemAdapter);
    }
}
