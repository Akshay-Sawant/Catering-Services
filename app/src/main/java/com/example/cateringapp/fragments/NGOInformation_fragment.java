package com.example.cateringapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cateringapp.R;

public class NGOInformation_fragment extends Fragment implements View.OnClickListener{
    private Button getDetails;


    public NGOInformation_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

                View view=inflater.inflate(R.layout.fragment_ngoinformation_fragment, container, false);
        getDetails=view.findViewById(R.id.NGO_contact_button);
        initializeEditTextFunc();
        return view;
    }
    public void initializeEditTextFunc(){getDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // go to Payment Page.
    }
}
