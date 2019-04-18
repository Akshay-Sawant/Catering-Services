package com.example.cateringapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cateringapp.R;
import com.example.cateringapp.utils.PrefManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryAddressFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    View viewDeliveryAddressFragment;

    private EditText deliveryAddressEditText;
    private Button saveDeliveryAddressButton;
    private Spinner spinnerDeliveryAddress;
    private ArrayAdapter<CharSequence> charSequenceArrayAdapter;
    private String spinnerLabel = "";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewDeliveryAddressFragment = inflater.inflate(R.layout.fragment_delivery_address, container, false);

        getActivity().setTitle("Work Address");

        bindingDeliveryAddressFragmentsViewsFunc();

        return viewDeliveryAddressFragment;
    }

    public void bindingDeliveryAddressFragmentsViewsFunc() {
        deliveryAddressEditText = viewDeliveryAddressFragment.findViewById(R.id.enter_delivery_address_edit_text);
        saveDeliveryAddressButton = viewDeliveryAddressFragment.findViewById(R.id.save_work_delivery_address_button);
        spinnerDeliveryAddress = viewDeliveryAddressFragment.findViewById(R.id.delivery_address_type_spinner);

        if (spinnerDeliveryAddress != null) {
            spinnerDeliveryAddress.setOnItemSelectedListener(this);
        }

        charSequenceArrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.delivery_address_type, android.R.layout.simple_spinner_dropdown_item);
        charSequenceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (spinnerDeliveryAddress != null) {
            spinnerDeliveryAddress.setAdapter(charSequenceArrayAdapter);
        }

        saveDeliveryAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDeliveryAddressButtonFunc();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerLabel = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveDeliveryAddressButtonFunc() {
        if (spinnerLabel.equals("Home")) {
            PrefManager.setHomeAddress(getActivity(), deliveryAddressEditText.getText().toString().trim());
            getActivity().getSupportFragmentManager().popBackStack();
        }
        if (spinnerLabel.equals("Work")) {
            PrefManager.setWorkAddress(getActivity(), deliveryAddressEditText.getText().toString().trim());
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }
}
