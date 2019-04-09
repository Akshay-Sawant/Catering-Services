package com.example.cateringapp.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.cateringapp.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    ViewFlipper viewFlipper;

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR_MR1)

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        Objects.requireNonNull(getActivity()).setTitle(R.string.gallery);

        int images[] = {
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
                R.drawable.five,
                R.drawable.seven,
                R.drawable.eight
        };

        viewFlipper = view.findViewById(R.id.view_flipper);

        for (int image : images) {
            flipeImage(image);
        }

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR_MR1)
    public void flipeImage(int image) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
    }
}
