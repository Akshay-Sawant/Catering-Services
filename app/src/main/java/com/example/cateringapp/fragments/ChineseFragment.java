package com.example.cateringapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringapp.R;
import com.example.cateringapp.adapters.DefaultFoodItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChineseFragment extends Fragment {

    private static final String TAG = "ChineseFragment";
    private List<String> chineseItemNamesList, chineseItemAmountList;
    private RecyclerView chineseRecyclerView;
    DefaultFoodItemAdapter chineseDefaultFoodItemAdapter;
    LinearLayoutManager chineseLinearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chinese, container, false);

        chineseRecyclerView = view.findViewById(R.id.chinese_recycler_view);

        chineseItemNamesList = new ArrayList<>();
        chineseItemAmountList = new ArrayList<>();

        addChineseItemsToArrayListFunc();
        initializeChineseRecyclerViewFunc();

        return view;
    }

    public void addChineseItemsToArrayListFunc() {
        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");

        chineseItemNamesList.add("");
        chineseItemAmountList.add("");
    }

    public void initializeChineseRecyclerViewFunc() {
        /*chineseDefaultFoodItemAdapter = new DefaultFoodItemAdapter(getActivity(), chineseItemNamesList, chineseItemAmountList);
        chineseLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        chineseRecyclerView.setLayoutManager(chineseLinearLayoutManager);
        chineseRecyclerView.setAdapter(chineseDefaultFoodItemAdapter);*/
    }
}
