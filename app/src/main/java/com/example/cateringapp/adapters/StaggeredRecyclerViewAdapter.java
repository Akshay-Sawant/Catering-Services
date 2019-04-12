package com.example.cateringapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
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
import com.example.cateringapp.fragments.ChineseFragment;
import com.example.cateringapp.fragments.MenuFragment;

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
                if (viewHolder.foodTypeText.getText().equals("Desserts")) {
                    FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container, new ChineseFragment()).commit();
                } else if (viewHolder.foodTypeText.getText().equals("Chinese")) {

                } else if (viewHolder.foodTypeText.getText().equals("Indian")) {

                } else if (viewHolder.foodTypeText.getText().equals("North Indian")) {

                } else if (viewHolder.foodTypeText.getText().equals("South Indian")) {

                } else if (viewHolder.foodTypeText.getText().equals("Biryani")) {

                } else if (viewHolder.foodTypeText.getText().equals("Ice Cream")) {

                } else if (viewHolder.foodTypeText.getText().equals("Juices")) {

                } else if (viewHolder.foodTypeText.getText().equals("Street Food")) {

                } else if (viewHolder.foodTypeText.getText().equals("Healthy Food")) {

                } else if (viewHolder.foodTypeText.getText().equals("Chicken")) {

                } else if (viewHolder.foodTypeText.getText().equals("American")) {

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
}
