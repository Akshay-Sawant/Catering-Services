package com.example.cateringapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cateringapp.R;
import com.example.cateringapp.fragments.AmericanFragment;
import com.example.cateringapp.fragments.BiryaniFragment;
import com.example.cateringapp.fragments.BreakFastFragment;
import com.example.cateringapp.fragments.ChickenFragment;
import com.example.cateringapp.fragments.ChineseFragment;
import com.example.cateringapp.fragments.DessertsFragment;
import com.example.cateringapp.fragments.DinnerFragment;
import com.example.cateringapp.fragments.HealthyFoodFragment;
import com.example.cateringapp.fragments.IceCreamFragment;
import com.example.cateringapp.fragments.IndianFragment;
import com.example.cateringapp.fragments.JuicesFragment;
import com.example.cateringapp.fragments.LunchFragment;
import com.example.cateringapp.fragments.MenuFragment;
import com.example.cateringapp.fragments.NorthIndianFragment;
import com.example.cateringapp.fragments.SouthIndianFragment;
import com.example.cateringapp.fragments.StreetFoodFragment;

import java.util.ArrayList;

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "StaggeredRecyclerViewAd";

    private ArrayList<String> mNames;
    private ArrayList<Integer> mImageUrls;
    private Context context;

    public StaggeredRecyclerViewAdapter(ArrayList<String> mNames, ArrayList<Integer> mImageUrls, Context context) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.staggered_recycler_view_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(context)
                .load(mImageUrls.get(i))
                .apply(requestOptions)
                .into(viewHolder.foodTypeImage);
        viewHolder.foodTypeText.setText(mNames.get(i));
        viewHolder.staggeredcCardContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.staggeredcCardContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.foodTypeText.getText().equals("BreakFast")) {
                    loadFragmentFunc(new BreakFastFragment());

                } else if (viewHolder.foodTypeText.getText().equals("Lunch")) {
                    loadFragmentFunc(new LunchFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Dinner")) {
                    loadFragmentFunc(new DinnerFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Desserts")) {
                    loadFragmentFunc(new DessertsFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Chinese")) {
                    loadFragmentFunc(new ChineseFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Indian")) {
                    loadFragmentFunc(new IndianFragment());
                } else if (viewHolder.foodTypeText.getText().equals("North Indian")) {
                    loadFragmentFunc(new NorthIndianFragment());
                } else if (viewHolder.foodTypeText.getText().equals("South Indian")) {
                    loadFragmentFunc(new SouthIndianFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Biryani")) {
                    loadFragmentFunc(new BiryaniFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Ice Cream")) {
                    loadFragmentFunc(new IceCreamFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Juices")) {
                    loadFragmentFunc(new JuicesFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Street Food")) {
                    loadFragmentFunc(new StreetFoodFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Healthy Food")) {
                    loadFragmentFunc(new HealthyFoodFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Chicken")) {
                    loadFragmentFunc(new ChickenFragment());
                } else if (viewHolder.foodTypeText.getText().equals("American")) {
                    loadFragmentFunc(new AmericanFragment());
                } else if (viewHolder.foodTypeText.getText().equals("Italian")) {

                } else if (viewHolder.foodTypeText.getText().equals("Vegetarian")) {

                } else if (viewHolder.foodTypeText.getText().equals("Sea Food")) {

                } else if (viewHolder.foodTypeText.getText().equals("BBQ")) {

                } else if (viewHolder.foodTypeText.getText().equals("Salads")) {

                } else if (viewHolder.foodTypeText.getText().equals("Lebanese")) {

                } else if (viewHolder.foodTypeText.getText().equals("Asian")) {

                } else if (viewHolder.foodTypeText.getText().equals("Mexican")) {

                } else if (viewHolder.foodTypeText.getText().equals("Thai")) {

                } else if (viewHolder.foodTypeText.getText().equals("Middle Eastern")) {

                } else if (viewHolder.foodTypeText.getText().equals("European")) {

                } else if (viewHolder.foodTypeText.getText().equals("French")) {

                } else if (viewHolder.foodTypeText.getText().equals("Belgian")) {

                } else if (viewHolder.foodTypeText.getText().equals("Persian")) {

                } else if (viewHolder.foodTypeText.getText().equals("Northern Thai")) {

                } else if (viewHolder.foodTypeText.getText().equals("Japanese")) {

                } else if (viewHolder.foodTypeText.getText().equals("Spanish")) {

                } else if (viewHolder.foodTypeText.getText().equals("Greek")) {

                } else {

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView staggeredcCardContainer;
        ImageView foodTypeImage;
        TextView foodTypeText;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            staggeredcCardContainer = itemView.findViewById(R.id.staggered_card_container);
            foodTypeImage = itemView.findViewById(R.id.food_type_image);
            foodTypeText = itemView.findViewById(R.id.food_type_name);
        }
    }

    public void loadFragmentFunc(Fragment fragment) {
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container, fragment).commit();
    }
}
