package com.example.cateringapp.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringapp.R;
import com.example.cateringapp.activities.LoginActivity;
import com.example.cateringapp.utils.PrefManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {

    View viewSettingsFragment;
    private TextView fullNameSettingsTextView, userNameSettingsTextView, homeSettingsTextView, workSettingsTextView, deliverySettingsTextView, deliverySettingsTitle,
            managePaymentSettingsTextView, paymentSettingsTitle, logoutSettingsTitle;

    private AlertDialog.Builder builderSettings;
    private PrefManager prefManagerSettings;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewSettingsFragment = inflater.inflate(R.layout.fragment_settings, container, false);

        getActivity().setTitle(R.string.settings);

        bindingSettingsFragmentViewsFunc();

        prefManagerSettings = new PrefManager(getActivity());

        return viewSettingsFragment;
    }

    public void bindingSettingsFragmentViewsFunc() {
        fullNameSettingsTextView = viewSettingsFragment.findViewById(R.id.user_full_name_text_view);
        userNameSettingsTextView = viewSettingsFragment.findViewById(R.id.user_name_text);

        homeSettingsTextView = viewSettingsFragment.findViewById(R.id.home_text_view);

        workSettingsTextView = viewSettingsFragment.findViewById(R.id.saved_places_work_text_view);

        deliverySettingsTitle = viewSettingsFragment.findViewById(R.id.delivery_address_title);
        deliverySettingsTextView = viewSettingsFragment.findViewById(R.id.delivery_address_text_view);

        paymentSettingsTitle = viewSettingsFragment.findViewById(R.id.payments_title);
        managePaymentSettingsTextView = viewSettingsFragment.findViewById(R.id.manage_payments_text_view);

        logoutSettingsTitle = viewSettingsFragment.findViewById(R.id.other_options_sign_out_text_view);

        deliverySettingsTitle.setOnClickListener(this);
        deliverySettingsTextView.setOnClickListener(this);

        paymentSettingsTitle.setOnClickListener(this);
        managePaymentSettingsTextView.setOnClickListener(this);

        logoutSettingsTitle.setOnClickListener(this);

        fullNameSettingsTextView.setText(PrefManager.getUserFullName(getActivity()));
        userNameSettingsTextView.setText(PrefManager.getUsername(getActivity()));

        if (PrefManager.getHomeAddress(getActivity()) == null || PrefManager.getWorkAddress(getActivity()) == null) {
            homeSettingsTextView.setText(R.string.home);
            workSettingsTextView.setText(R.string.work);
        } else {
            homeSettingsTextView.setText(PrefManager.getHomeAddress(getActivity()));
            workSettingsTextView.setText(PrefManager.getWorkAddress(getActivity()));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delivery_address_title:
                loadAboutUsFragmentFunc(new DeliveryAddressFragment());
                break;
            case R.id.delivery_address_text_view:
                loadAboutUsFragmentFunc(new DeliveryAddressFragment());
                break;
            case R.id.payments_title:
                loadAboutUsFragmentFunc(new PaymentFragment());
                break;
            case R.id.manage_payments_text_view:
                loadAboutUsFragmentFunc(new PaymentFragment());
                break;
            case R.id.other_options_sign_out_text_view:
                logoutSettingsFragmentFunc();
                break;
        }
    }

    public void loadAboutUsFragmentFunc(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container, fragment).commit();
    }

    public void logoutSettingsFragmentFunc() {
        builderSettings = new AlertDialog.Builder(getActivity());
        builderSettings.setMessage("Are you sure you want to logout?");
        builderSettings.setCancelable(false);
        builderSettings.setPositiveButton(R.string.yes_button_of_alert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                prefManagerSettings.logoutUser(getActivity());
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
            }
        });
        builderSettings.setNegativeButton(R.string.no_button_of_alert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builderSettings.show();
    }
}
