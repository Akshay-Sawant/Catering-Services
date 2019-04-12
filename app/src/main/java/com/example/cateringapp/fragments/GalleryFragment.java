package com.example.cateringapp.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.cateringapp.R;

import java.util.HashMap;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements ViewPager.OnPageChangeListener {

    SliderLayout gallerySlider;
    HashMap<String, Integer> galleryHashMap;
    TextSliderView galleryTextSliderView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        Objects.requireNonNull(getActivity()).setTitle(R.string.gallery);

        galleryHashMap = new HashMap<>();
        gallerySlider = view.findViewById(R.id.gallery_slider);

        galleryHashMap.put("One", R.drawable.one);
        galleryHashMap.put("Two", R.drawable.two);
        galleryHashMap.put("Three", R.drawable.three);
        galleryHashMap.put("Four", R.drawable.four);
        galleryHashMap.put("Five", R.drawable.five);
        galleryHashMap.put("Six", R.drawable.six);
        galleryHashMap.put("Seven", R.drawable.seven);
        galleryHashMap.put("Eight", R.drawable.eight);

        for (String name : galleryHashMap.keySet()) {
            galleryTextSliderView = new TextSliderView(getActivity());
            galleryTextSliderView.description(name)
                    .image(galleryHashMap.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .bundle(new Bundle())
                    .getBundle()
                    .putString("extra", name);
            gallerySlider.addSlider(galleryTextSliderView);
        }

        gallerySlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        gallerySlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        gallerySlider.setCustomAnimation(new DescriptionAnimation());
        gallerySlider.setDuration(3000);

        return view;
    }

    @Override
    public void onStop() {
        gallerySlider.startAutoCycle();
        super.onStop();
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
