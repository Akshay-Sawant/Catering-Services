package com.example.cateringapp.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cateringapp.R;
import com.example.cateringapp.adapters.StaggeredRecyclerViewAdapter;

import java.util.Locale;

public class ngoOptionFragment extends Fragment implements View.OnClickListener {
    private EditText selectNGO;
private Button GetChoice;

    public ngoOptionFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ngo_option, container, false);
        selectNGO=view.findViewById(R.id.SelectChoice);
        GetChoice=view.findViewById(R.id.GoToNext);
        initializeEditTextFunc();
        return view;
    }
    public void initializeEditTextFunc() {
       GetChoice.setOnClickListener(this);
    }
    public void onClick(View view) {
        String check=selectNGO.getText().toString().trim();
        if(check.equals("y") || check.equals("yes") || check.equals("Y") || check.equals("Yes"))
        {
        // Go to NGOInformation page.
        }
        else if(check.equals("n") || check.equals("no") || check.equals("N") || check.equals("No"))
        {
            //Go to Direct Payment Page.
        }
        }
}
