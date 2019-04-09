package com.example.cateringapp.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cateringapp.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment implements View.OnClickListener {

    ImageView mobileImg, whatsappImg, fbImg, locationImg;
    TextView mobileTitle, mobileNo, whatsappTitle, whatsappNo, fbTitle, fb, locationTitle, location;

    private Intent sendIntent;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment-
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        Objects.requireNonNull(getActivity()).setTitle(R.string.contact_us);

        //ImageView Binding
        mobileImg = view.findViewById(R.id.mobile_no_image_view);
        whatsappImg = view.findViewById(R.id.whatsapp_image_view);
        fbImg = view.findViewById(R.id.facebook_image_view);
        locationImg = view.findViewById(R.id.location_image_view);

        //TextView Binding
        mobileTitle = view.findViewById(R.id.mobile_no_title_text_view);
        mobileNo = view.findViewById(R.id.mobile_no_text_view);
        whatsappTitle = view.findViewById(R.id.whatsapp_title_text_view);
        whatsappNo = view.findViewById(R.id.whatsapp_text_view);
        fbTitle = view.findViewById(R.id.facebook_title_text_view);
        fb = view.findViewById(R.id.facebook_text_view);
        locationTitle = view.findViewById(R.id.location_title_text_view);
        location = view.findViewById(R.id.location_text_view);

        //placing set on click listener for MOBILE
        mobileImg.setOnClickListener(this);
        mobileTitle.setOnClickListener(this);
        mobileNo.setOnClickListener(this);

        //placing set on click listener for WHATSAPP
        whatsappImg.setOnClickListener(this);
        whatsappTitle.setOnClickListener(this);
        whatsappNo.setOnClickListener(this);

        //placing set on click listener for FACEBOOK
        fbImg.setOnClickListener(this);
        fbTitle.setOnClickListener(this);
        fb.setOnClickListener(this);

        //placing set on click listener for LOCATION
        locationImg.setOnClickListener(this);
        locationTitle.setOnClickListener(this);
        location.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mobile_no_image_view:
                mobileFunc();
                break;
            case R.id.mobile_no_title_text_view:
                mobileFunc();
                break;
            case R.id.mobile_no_text_view:
                mobileFunc();
                break;
            case R.id.whatsapp_image_view:
                whatsappFunc();
                break;
            case R.id.whatsapp_title_text_view:
                whatsappFunc();
                break;
            case R.id.whatsapp_text_view:
                whatsappFunc();
                break;
            case R.id.facebook_image_view:
                facebookFunc();
                break;
            case R.id.facebook_title_text_view:
                facebookFunc();
                break;
            case R.id.facebook_text_view:
                facebookFunc();
                break;
            case R.id.location_image_view:
                locationFunc();
                break;
            case R.id.location_title_text_view:
                locationFunc();
                break;
            case R.id.location_text_view:
                locationFunc();
                break;
        }
    }

    public void mobileFunc() {
        /*sendIntent = new Intent(Intent.ACTION_DIAL);
        sendIntent.setData(Uri.parse("tel:" + "8828088787"));
        startActivity(sendIntent);*/
        startActivity(
                new Intent(Intent.ACTION_DIAL).setData(
                        Uri.parse("tel:" + "8828088787")
                )
        );
    }

    public void whatsappFunc() {
        sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }

    public void facebookFunc() {
        sendIntent = new Intent("android.intent.action.VIEW");
        sendIntent.setData(Uri.parse("https://www.facebook.com/swara.chaudhary.372"));
        startActivity(sendIntent);
    }

    public void locationFunc() {
        sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:19.098809,72.8493333"));
        startActivity(sendIntent);
    }
}
