package com.example.cateringapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {

    SliderLayout sliderLayout;
    HashMap<String, Integer> hashMap;
    TextSliderView textSliderView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Objects.requireNonNull(getActivity()).setTitle(R.string.home);

        hashMap = new HashMap<>();
        sliderLayout = view.findViewById(R.id.slider);

        hashMap.put(getString(R.string.biryani_dish), R.drawable.biryani_dishes);
        hashMap.put(getString(R.string.tandoori_dish), R.drawable.tandoori_dishes);
        hashMap.put(getString(R.string.chocolates_dish), R.drawable.chocolate_dishes);
        hashMap.put(getString(R.string.variety_dish), R.drawable.food_dishes);
        hashMap.put(getString(R.string.ice_cream_dish), R.drawable.ice_cream_dishes);
        hashMap.put(getString(R.string.dessert_dish), R.drawable.dessert_dishes);

        for (String name : hashMap.keySet()) {
            textSliderView = new TextSliderView(getActivity());
            textSliderView.description(name)
                    .image(hashMap.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .bundle(new Bundle())
                    .getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);

        return view;
    }

    @Override
    public void onStop() {
        sliderLayout.startAutoCycle();
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