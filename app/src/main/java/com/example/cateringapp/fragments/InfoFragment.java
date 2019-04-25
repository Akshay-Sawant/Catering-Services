package com.example.cateringapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
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
public class InfoFragment extends Fragment {

    SliderLayout gallerySlider;
    HashMap<String, Integer> galleryHashMap;
    TextSliderView galleryTextSliderView;
    View infoFragmentView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        infoFragmentView = inflater.inflate(R.layout.fragment_info, container, false);

        Objects.requireNonNull(getActivity()).setTitle(R.string.about);

        galleryHashMap = new HashMap<>();
        gallerySlider = infoFragmentView.findViewById(R.id.gallery_slider);

        galleryHashMap.put("Stop, eat and go!", R.drawable.one);
        galleryHashMap.put("An amazing experience for all.", R.drawable.two);
        galleryHashMap.put("Friendly serving.", R.drawable.three);
        galleryHashMap.put("The flavors of nature", R.drawable.four);
        galleryHashMap.put("Fresh, colorful, delicious.", R.drawable.five);
        galleryHashMap.put("Only for foodies", R.drawable.seven);
        galleryHashMap.put("The good taste of food", R.drawable.eight);

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

        return infoFragmentView;
    }

    @Override
    public void onStop() {
        gallerySlider.startAutoCycle();
        super.onStop();
    }

    public void onPageScrolled(int i, float v, int i1) {

    }

    public void onPageSelected(int i) {

    }

    public void onPageScrollStateChanged(int i) {

    }
}
