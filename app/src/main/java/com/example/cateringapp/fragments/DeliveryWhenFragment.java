package com.example.cateringapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryWhenFragment extends Fragment {

    View viewDeliveryWhenFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewDeliveryWhenFragment = inflater.inflate(R.layout.fragment_delivery_when, container, false);

        getActivity().setTitle("When To Deliver?");

        return viewDeliveryWhenFragment;
    }

}
