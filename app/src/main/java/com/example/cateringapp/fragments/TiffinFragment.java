package com.example.cateringapp.fragments;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cateringapp.R;
import com.example.cateringapp.adapters.StaggeredRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class TiffinFragment extends Fragment implements  View.OnClickListener {
    private TextView seeLocation;
    private ArrayList<String> tiffinNamesList;
    private ArrayList<Integer> tiffinImageUrlsList;
    private RecyclerView tiffinRecyclerView;
    StaggeredRecyclerViewAdapter tiffinStaggeredRecyclerViewAdapter;
    StaggeredGridLayoutManager tiffinStaggeredGridLayoutManager;
    private static final int NUM_COlUMNS = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tiffin, container, false);

       tiffinRecyclerView = view.findViewById(R.id.tiffin_recycler_view);
        seeLocation=view.findViewById(R.id.TextView_Location);
        tiffinNamesList = new ArrayList<>();
        tiffinImageUrlsList = new ArrayList<>();

        addTiffinToArrayListFunc();
        initializeTiffinRecyclerViewFunc();

        return view;
    }

    public void addTiffinToArrayListFunc() {
        tiffinNamesList.add("BreakFast");
        tiffinImageUrlsList.add(R.drawable.breakfast);

        tiffinNamesList.add("Lunch");
        tiffinImageUrlsList.add(R.drawable.lunch);

        tiffinNamesList.add("Dinner");
        tiffinImageUrlsList.add(R.drawable.dinner);
    }

    public void initializeTiffinRecyclerViewFunc() {
        tiffinStaggeredRecyclerViewAdapter = new StaggeredRecyclerViewAdapter(tiffinNamesList, tiffinImageUrlsList, getActivity());
        tiffinStaggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COlUMNS, LinearLayoutManager.VERTICAL);
        tiffinRecyclerView.setLayoutManager(tiffinStaggeredGridLayoutManager);
        tiffinRecyclerView.setAdapter(tiffinStaggeredRecyclerViewAdapter);
        seeLocation.setOnClickListener(this);
    }
    public void onClick(View view) {

        switch (view.getId()) {
                 case R.id.TextView_Location:
                 String uri = String.format(Locale.CANADA.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", 12f, 2f, "Where the party is at");
                 Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                 intent.setPackage("com.google.android.apps.maps");
                     startActivity(intent);
        }
    }
}