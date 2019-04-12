package com.example.cateringapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthyFoodFragment extends Fragment {


    public HealthyFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_healthy_food, container, false);
    }

}
