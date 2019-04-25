package com.example.cateringapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringapp.R;
import com.example.cateringapp.utils.PrefManager;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.AddToCartViewHolder> {

    private Context addToCartContext;
    private Set<String> foodItemSetString;
    private List<String> foodItemCountList, foodItemList = new ArrayList<>();
    private List<PrefManager> prefManagerList;
    private PrefManager prefManager;
    private ArrayList<String> addToCartAdapterList;
    DefaultFoodItemAdapter defaultFoodItemAdapter;


    public AddToCartAdapter(Context addToCartContext, ArrayList<String> strings) {
        this.addToCartContext = addToCartContext;
        this.addToCartAdapterList = strings;
    }

    @NonNull
    @Override
    public AddToCartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View addToCartView = LayoutInflater.from(addToCartContext).inflate(R.layout.add_to_cart_layout, viewGroup, false);

        return new AddToCartViewHolder(addToCartView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddToCartViewHolder addToCartViewHolder, int position) {

/*        String data = PrefManager.getFoodName(addToCartContext).get(i);
        String[] strings = data.split("");*/
//        Toast.makeText(addToCartContext, Arrays.toString(PrefManager.getFoodName(addToCartContext)), Toast.LENGTH_SHORT).show();
//        String array = PrefManager.getFoodName(addToCartContext).get(position);
        /*for (int i = 0; i <= array.length(); i++ ) {
            addToCartViewHolder.addToCartFoodItemName.setText(array[i]);
        }*/

        addToCartViewHolder.addToCartFoodItemName.setText(PrefManager.getFoodName(addToCartContext).get(position));
//        addToCartViewHolder.getAddToCartNoOfDishes.setText(PrefManager.getFoodCount(addToCartContext).get(position));
        /*for (int j = 0; j <= PrefManager.getFoodName(addToCartContext).size(); j++){
         *//*for (int k = 0; k <= j; k++){
                addToCartViewHolder.addToCartFoodItemName.setText(PrefManager.getFoodName(addToCartContext).get(j));
            }*//*

        }*/


    }

    @Override
    public int getItemCount() {
        return PrefManager.getFoodName(addToCartContext).size();
    }

    public class AddToCartViewHolder extends RecyclerView.ViewHolder {
        TextView addToCartFoodItemName, getAddToCartNoOfDishes;

        public AddToCartViewHolder(@NonNull View itemView) {
            super(itemView);
            addToCartFoodItemName = itemView.findViewById(R.id.add_to_cart_food_item_name_text_view);
//            getAddToCartNoOfDishes = itemView.findViewById(R.id.add_to_cart_no_of_dishes_text_view);
        }
    }
}
