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
public class LegalFragment extends Fragment {

    View viewLegalFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewLegalFragment = inflater.inflate(R.layout.fragment_legal, container, false);

        getActivity().setTitle("Legal");

        return viewLegalFragment;
    }

}
