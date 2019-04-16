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
public class DinnerFragment extends Fragment {


    public DinnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dinner, container, false);

        getActivity().setTitle(R.string.dinner);

        return view;
    }
}
