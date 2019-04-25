package com.example.cateringapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.cateringapp.R;
import com.example.cateringapp.activities.HomeScreenActivity;

import java.util.HashMap;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    SliderLayout sliderLayout;
    HashMap<String, Integer> hashMap;
    TextSliderView textSliderView;
    CardView eventsCardView, tiffinsCardView;
    HomeScreenActivity homeScreenActivity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Objects.requireNonNull(getActivity()).setTitle(R.string.home);

        sliderLayout = view.findViewById(R.id.slider);
        eventsCardView = view.findViewById(R.id.events_menu_card_view);
        tiffinsCardView = view.findViewById(R.id.tiffin_menu_card_view);

        eventsCardView.setOnClickListener(this);
        tiffinsCardView.setOnClickListener(this);

//        homeScreenActivity = new HomeScreenActivity();

        setSliderLayoutFunc();

        return view;
    }

    public void setSliderLayoutFunc(){
        hashMap = new HashMap<>();

        hashMap.put(getString(R.string.biryani_dish), R.drawable.biryani_dishes);
        hashMap.put(getString(R.string.tandoori_dish), R.drawable.tandoori_dishes);
        hashMap.put(getString(R.string.chocolates_dish), R.drawable.chocolate_dishes);
        hashMap.put(getString(R.string.variety_dish), R.drawable.food_dishes);
        hashMap.put(getString(R.string.ice_cream_dish), R.drawable.ice_cream_dishes);
        hashMap.put(getString(R.string.dessert_dish), R.drawable.dessert_dishes);
        hashMap.put(getString(R.string.chinese_dishes), R.drawable.chinese_dishes);
        hashMap.put(getString(R.string.juices), R.drawable.juice_dishes);
        hashMap.put(getString(R.string.indian_sweets_thali), R.drawable.sweets_thali_dishes);
        hashMap.put(getString(R.string.salad_dishes), R.drawable.salad_dishes);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.events_menu_card_view:
                Toast.makeText(getActivity(), "Go to Menu and Enter Order Details First", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tiffin_menu_card_view:
                Toast.makeText(getActivity(), "Go to Menu and Enter Order Details First", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}