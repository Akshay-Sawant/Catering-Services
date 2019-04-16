package com.example.cateringapp.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cateringapp.R;
import com.example.cateringapp.adapters.StaggeredRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    private static final String TAG = "EventsFragment";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<Integer> mFoodImages = new ArrayList<>();
    private ArrayList<String> mFoodTypeNames = new ArrayList<>();
    private RecyclerView eventsRecyclerView;


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        eventsRecyclerView = view.findViewById(R.id.events_recycler_view);

        initializeRecyclerViewFunc();
        initializeImagesFunc();

        return view;
    }

    public void initializeImagesFunc() {
        mFoodImages.add(R.drawable.dessert_dishes);
        mFoodTypeNames.add(getString(R.string.desserts));

        mFoodImages.add(R.drawable.chinese_dishes);
        mFoodTypeNames.add(getString(R.string.chinese));

        mFoodImages.add(R.drawable.indian);
        mFoodTypeNames.add(getString(R.string.indian));

        mFoodImages.add(R.drawable.north_indian);
        mFoodTypeNames.add(getString(R.string.north_indian));

        mFoodImages.add(R.drawable.south_indian);
        mFoodTypeNames.add(getString(R.string.south_indian));

        mFoodImages.add(R.drawable.biryani_dishes);
        mFoodTypeNames.add(getString(R.string.biryani));

        mFoodImages.add(R.drawable.ice_cream_dishes);
        mFoodTypeNames.add(getString(R.string.ice_cream));

        mFoodImages.add(R.drawable.juice_dishes);
        mFoodTypeNames.add(getString(R.string.juice));

        mFoodImages.add(R.drawable.street_food);
        mFoodTypeNames.add(getString(R.string.street_food));

        mFoodImages.add(R.drawable.healthy_food);
        mFoodTypeNames.add(getString(R.string.healthy_food));

        mFoodImages.add(R.drawable.tandoori_dishes);
        mFoodTypeNames.add(getString(R.string.chicken));

        mFoodImages.add(R.drawable.american);
        mFoodTypeNames.add(getString(R.string.american));

        mFoodImages.add(R.drawable.italian);
        mFoodTypeNames.add(getString(R.string.italian));

        mFoodImages.add(R.drawable.food_dishes);
        mFoodTypeNames.add(getString(R.string.vegetarian));

        mFoodImages.add(R.drawable.sea_food);
        mFoodTypeNames.add(getString(R.string.sea_food));

        mFoodImages.add(R.drawable.bbq);
        mFoodTypeNames.add(getString(R.string.bbq));

        mFoodImages.add(R.drawable.salad_dishes);
        mFoodTypeNames.add(getString(R.string.salads));

        mFoodImages.add(R.drawable.lebanese);
        mFoodTypeNames.add(getString(R.string.lebanese));

        mFoodImages.add(R.drawable.asian);
        mFoodTypeNames.add(getString(R.string.asian));

        mFoodImages.add(R.drawable.mexican);
        mFoodTypeNames.add(getString(R.string.mexican));

        mFoodImages.add(R.drawable.thai);
        mFoodTypeNames.add(getString(R.string.thai));

        mFoodImages.add(R.drawable.middle_eastern);
        mFoodTypeNames.add(getString(R.string.middle_eastern));

        mFoodImages.add(R.drawable.european);
        mFoodTypeNames.add(getString(R.string.european));

        mFoodImages.add(R.drawable.french);
        mFoodTypeNames.add(getString(R.string.french));

        mFoodImages.add(R.drawable.french);
        mFoodTypeNames.add(getString(R.string.belgian));

        mFoodImages.add(R.drawable.persian);
        mFoodTypeNames.add(getString(R.string.persian));

        mFoodImages.add(R.drawable.northern_thai);
        mFoodTypeNames.add(getString(R.string.northern_thai));

        mFoodImages.add(R.drawable.japanese);
        mFoodTypeNames.add(getString(R.string.japanese));

        mFoodImages.add(R.drawable.spanish);
        mFoodTypeNames.add(getString(R.string.spanish));

        mFoodImages.add(R.drawable.spanish);
        mFoodTypeNames.add(getString(R.string.greek));

        mFoodImages.add(R.drawable.mediterranian);
        mFoodTypeNames.add(getString(R.string.mediterranean));
    }

    public void initializeRecyclerViewFunc() {
        Log.d(TAG, "initializeRecyclerViewFunc: initializing staggered recycler view");

        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter =
                new StaggeredRecyclerViewAdapter(mFoodTypeNames, mFoodImages, getActivity());

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);

        eventsRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        eventsRecyclerView.setAdapter(staggeredRecyclerViewAdapter);
    }

    /*@Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                    *//*if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    return true;*//*
                    appCloseConfirmationFunc();
                }

                return false;
            }
        });
    }


    public void appCloseConfirmationFunc() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to exit from this app?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }*/
}
