package com.example.cateringapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cateringapp.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment implements View.OnClickListener {


    private TextView helpAboutUsFragmentTexView, legalAboutUsFragmentTexView, inforAboutUsFragmentTextView;
    private Context aboutUsFragmentContext;
    private View viewAboutUsFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewAboutUsFragment = inflater.inflate(R.layout.fragment_about_us, container, false);

        Objects.requireNonNull(getActivity()).setTitle("About Us");

        aboutUsFragmentContext = getActivity();

        aboutUsFragmentContext = getActivity();

        bindingViewAboutUsFragmentFunc();

        return viewAboutUsFragment;
    }

    public void bindingViewAboutUsFragmentFunc() {
        helpAboutUsFragmentTexView = viewAboutUsFragment.findViewById(R.id.help_text_view);
        legalAboutUsFragmentTexView = viewAboutUsFragment.findViewById(R.id.legal_text_view);
        inforAboutUsFragmentTextView = viewAboutUsFragment.findViewById(R.id.info_text_view);

        helpAboutUsFragmentTexView.setOnClickListener(this);
        legalAboutUsFragmentTexView.setOnClickListener(this);
        inforAboutUsFragmentTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.help_text_view:
                loadAboutUsFragmentFunc(new HelpFragment());
                break;
            case R.id.legal_text_view:
                loadAboutUsFragmentFunc(new LegalFragment());
                break;
            case R.id.info_text_view:
                loadAboutUsFragmentFunc(new InfoFragment());
                break;
        }
    }

    public void loadAboutUsFragmentFunc(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container, fragment).commit();
    }
}
