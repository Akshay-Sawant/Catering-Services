package com.example.cateringapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment {

    View viewPaymentFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewPaymentFragment = inflater.inflate(R.layout.fragment_payment, container, false);

        getActivity().setTitle("Payment");

        return viewPaymentFragment;
    }
}
