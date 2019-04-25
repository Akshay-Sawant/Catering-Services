package com.example.cateringapp.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringapp.R;
import com.example.cateringapp.activities.MyFoodCartActivity;
import com.example.cateringapp.fragments.BreakFastFragment;
import com.example.cateringapp.models.FoodCartModel;
import com.example.cateringapp.utils.PrefManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DefaultFoodItemAdapter extends RecyclerView.Adapter<DefaultFoodItemAdapter.DefaultFoodItemViewHoldder> {

    private Context defaultFoodItemContext;
    //    private List<String> defaultFoodItemNameList, defaultFoodItemAmountList, defaultFoodItemCountList;
    private List<String> defaultFoodItemNameList, defaultFoodItemAmountList;
    private CoordinatorLayout defaultCoordinatorLayout;
    private Snackbar addToCartSnackbar;
    private MyFoodCartActivity myFoodCartActivity;
    private PrefManager prefManager;
    private ArrayList<FoodCartModel> foodCartModelArrayList;
    private BreakFastFragment breakFastFragment;

    public ArrayList<String> foodItemArrayList, foodCountArrayList, foodPriceArrayList;
    String[] arr;
    private int totalAmount, finalBill = 0;

    public DefaultFoodItemAdapter(Context defaultFoodItemContext, List<String> defaultFoodItemNameList, List<String> defaultFoodItemAmountList, CoordinatorLayout defaultCoordinatorLayout) {
        this.defaultFoodItemContext = defaultFoodItemContext;
        this.defaultFoodItemNameList = defaultFoodItemNameList;
        this.defaultFoodItemAmountList = defaultFoodItemAmountList;
        this.defaultCoordinatorLayout = defaultCoordinatorLayout;
    }

    @NonNull
    @Override
    public DefaultFoodItemViewHoldder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View defaultFoodItemView = LayoutInflater.from(defaultFoodItemContext).inflate(R.layout.default_food_item_layout, viewGroup, false);

        return new DefaultFoodItemViewHoldder(defaultFoodItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final DefaultFoodItemViewHoldder defaultFoodItemViewHoldder, final int position) {
        final int[] countAdd = {0};
        foodItemArrayList = new ArrayList<>();
        foodCountArrayList = new ArrayList<>();
        foodPriceArrayList = new ArrayList<>();

//        prefManager = new PrefManager(defaultFoodItemContext);
        defaultFoodItemViewHoldder.defaultFoodItemNameTextView.setText(defaultFoodItemNameList.get(position));
        defaultFoodItemViewHoldder.defaultFoodItemAmountTextView.setText(defaultFoodItemAmountList.get(position));

        defaultFoodItemViewHoldder.defaultAddFoodItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countAdd[0]++;
                totalAmount = Integer.parseInt(String.valueOf(defaultFoodItemAmountList.get(position))) * countAdd[0];
                defaultFoodItemViewHoldder.defaultFoodCountTextView.setText(String.valueOf(countAdd[0]));
                foodCountArrayList.add(defaultFoodItemViewHoldder.defaultFoodCountTextView.getText().toString());

                foodPriceArrayList.add(String.valueOf(totalAmount));

                Toast.makeText(defaultFoodItemContext, String.valueOf(totalAmount), Toast.LENGTH_SHORT).show();
            }
        });
        defaultFoodItemViewHoldder.defaultSubtractFoodItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countAdd[0]--;
                totalAmount = Integer.parseInt(String.valueOf(defaultFoodItemAmountList.get(position))) * countAdd[0];
                defaultFoodItemViewHoldder.defaultFoodCountTextView.setText(String.valueOf(countAdd[0]));
                Toast.makeText(defaultFoodItemContext, String.valueOf(totalAmount), Toast.LENGTH_SHORT).show();
            }
        });

        defaultFoodItemViewHoldder.defaultFoodItemAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                foodCartModel.setFoodItemName(defaultFoodItemViewHoldder.defaultFoodItemNameTextView.getText().toString());
                foodItemArrayList.add(defaultFoodItemViewHoldder.defaultFoodItemNameTextView.getText().toString());

                PrefManager.setFoodName(defaultFoodItemContext, foodItemArrayList);
                PrefManager.setFoodCount(defaultFoodItemContext, foodCountArrayList);
                PrefManager.setFoodPrice(defaultFoodItemContext, foodPriceArrayList);
                Toast.makeText(defaultFoodItemContext, PrefManager.getFoodName(defaultFoodItemContext).toString(), Toast.LENGTH_SHORT).show();
//
            }
        });
    }

    @Override
    public int getItemCount() {
        return defaultFoodItemNameList.size();
    }

    public class DefaultFoodItemViewHoldder extends RecyclerView.ViewHolder {

        TextView defaultFoodItemNameTextView, defaultFoodItemAmountTextView, defaultFoodCountTextView, dummyTextView;
        Button defaultFoodItemAddButton;
        ImageView defaultAddFoodItemButton, defaultSubtractFoodItemButton, defaultFoodItemDeleteButton;

        public DefaultFoodItemViewHoldder(@NonNull View itemView) {
            super(itemView);

            defaultFoodItemNameTextView = itemView.findViewById(R.id.food_name_text_view);
            defaultFoodItemAmountTextView = itemView.findViewById(R.id.food_item_amount_text_view);
            defaultFoodItemAddButton = itemView.findViewById(R.id.add_food_to_cart_btn);
            dummyTextView = itemView.findViewById(R.id.dummy_text);
            defaultAddFoodItemButton = itemView.findViewById(R.id.add_image);
            defaultSubtractFoodItemButton = itemView.findViewById(R.id.minus_image);
            defaultFoodCountTextView = itemView.findViewById(R.id.food_count_text_view);
            defaultFoodItemDeleteButton = itemView.findViewById(R.id.delete_item_image);
        }
    }

    public void snackBarFunc() {
        addToCartSnackbar = Snackbar
                .make(defaultCoordinatorLayout, "Item added to your cart", Snackbar.LENGTH_INDEFINITE)
                .setAction("View Cart", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
        addToCartSnackbar.setActionTextColor(Color.WHITE);


        View snackbarView = addToCartSnackbar.getView();
        snackbarView.setBackgroundColor(defaultFoodItemContext.getResources().getColor(R.color.blue));
        TextView snackbarTextView = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        snackbarTextView.setTextColor(Color.WHITE);
//        addToCartSnackbar.show();
    }
}
