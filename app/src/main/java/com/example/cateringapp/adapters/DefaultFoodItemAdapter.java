package com.example.cateringapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringapp.R;

import java.util.List;

public class DefaultFoodItemAdapter extends RecyclerView.Adapter<DefaultFoodItemAdapter.DefaultFoodItemViewHoldder> {

    private Context defaultFoodItemContext;
    private List<String> defaultFoodItemNameList, defaultFoodItemAmountList;
    private CoordinatorLayout defaultCoordinatorLayout;
    private Snackbar addToCartSnackbar;

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
    public void onBindViewHolder(@NonNull final DefaultFoodItemViewHoldder defaultFoodItemViewHoldder, int position) {
        defaultFoodItemViewHoldder.defaultFoodItemNameTextView.setText(defaultFoodItemNameList.get(position));
        defaultFoodItemViewHoldder.defaultFoodItemAmountTextView.setText(defaultFoodItemAmountList.get(position));
        defaultFoodItemViewHoldder.defaultFoodItemAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(defaultFoodItemContext, defaultFoodItemNameList.get(position), Toast.LENGTH_SHORT).show();
                if (defaultFoodItemViewHoldder.defaultFoodItemAddButton.getText().equals("Add")) {
                    defaultFoodItemViewHoldder.defaultFoodItemAddButton.setText(defaultFoodItemContext.getString(R.string.added));
                    snackBarFunc();
                    addToCartSnackbar.show();
                } else {
                    defaultFoodItemViewHoldder.defaultFoodItemAddButton.setText(R.string.add);
//                    addToCartSnackbar.dismiss();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return defaultFoodItemNameList.size();
    }

    public class DefaultFoodItemViewHoldder extends RecyclerView.ViewHolder {

        TextView defaultFoodItemNameTextView, defaultFoodItemAmountTextView;
        Button defaultFoodItemAddButton;

        public DefaultFoodItemViewHoldder(@NonNull View itemView) {
            super(itemView);

            defaultFoodItemNameTextView = itemView.findViewById(R.id.food_name_text_view);
            defaultFoodItemAmountTextView = itemView.findViewById(R.id.food_item_amount_text_view);
            defaultFoodItemAddButton = itemView.findViewById(R.id.add_food_to_cart_btn);
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
