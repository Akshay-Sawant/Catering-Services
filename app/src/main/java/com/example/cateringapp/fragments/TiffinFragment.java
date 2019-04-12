package com.example.cateringapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringapp.R;
import com.example.cateringapp.activities.BreakFastActivity;
import com.example.cateringapp.activities.DinnerActivity;
import com.example.cateringapp.activities.LunchActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class TiffinFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "TiffinFragment";
    CardView breakfastCard, lunchCard, dinnerCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tiffin, container, false);

        breakfastCard = view.findViewById(R.id.breakfast_card);
        lunchCard = view.findViewById(R.id.lunch_card);
        dinnerCard = view.findViewById(R.id.dinner_card);

        breakfastCard.setOnClickListener(this);
        lunchCard.setOnClickListener(this);
        dinnerCard.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.breakfast_card:
                startActivity(new Intent(getActivity(), BreakFastActivity.class));
                break;
            case R.id.lunch_card:
                startActivity(new Intent(getActivity(), LunchActivity.class));
                break;
            case R.id.dinner_card:
                startActivity(new Intent(getActivity(), DinnerActivity.class));
                break;
        }
    }


}
