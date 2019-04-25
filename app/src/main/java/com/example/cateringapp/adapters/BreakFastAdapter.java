package com.example.cateringapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cateringapp.R;

import java.util.ArrayList;
import java.util.List;

public class BreakFastAdapter extends RecyclerView.Adapter<BreakFastAdapter.BreakFastViewHolder> {

    private Context context;
    private List<String> breakfastFoodNameList = new ArrayList<>();
    private List<String> breakfastFoodAmountList = new ArrayList<>();

    public BreakFastAdapter(Context context, List<String> breakfastFoodNameList, List<String> breakfastFoodAmountList) {
        this.context = context;
        this.breakfastFoodNameList = breakfastFoodNameList;
        this.breakfastFoodAmountList = breakfastFoodAmountList;
    }

    @NonNull
    @Override
    public BreakFastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.default_food_item_layout, viewGroup, false);

        return new BreakFastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreakFastViewHolder breakFastViewHolder, int position) {
        breakFastViewHolder.breakfastFoodNameText.setText(breakfastFoodNameList.get(position));
        breakFastViewHolder.breakfastFoodAmountText.setText(breakfastFoodAmountList.get(position));
    }

    @Override
    public int getItemCount() {
        return breakfastFoodNameList.size();
    }


    public class BreakFastViewHolder extends RecyclerView.ViewHolder {
        TextView breakfastFoodNameText, breakfastFoodAmountText;
        Button breakfastFoodItemAddBtn;

        public BreakFastViewHolder(@NonNull View itemView) {
            super(itemView);

            breakfastFoodNameText = itemView.findViewById(R.id.food_name_text_view);
            breakfastFoodAmountText = itemView.findViewById(R.id.food_item_amount_text_view);
//            breakfastFoodItemAddBtn = itemView.findViewById(R.id.add_food_to_cart_btn);
        }
    }
}
