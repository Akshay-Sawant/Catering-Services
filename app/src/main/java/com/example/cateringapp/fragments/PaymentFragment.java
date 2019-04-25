package com.example.cateringapp.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cateringapp.R;
import com.example.cateringapp.utils.PrefManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment implements View.OnClickListener {

    View viewPaymentFragment;
    TextView editPaymentDetailsTextView, cardHolderNameTextView, cardHolderNumberTextView, cardExpiryDateTextView, cardCVVNumberTextView;
    EditText cardHolderNameEditText, cardHolderNumberEditText, cardExpiryDateEditTExt, cardCVVNumberEditText;
    Button saveCardDetailsButton;
    private Snackbar paymentSnackBar;
    RelativeLayout paymentRootLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewPaymentFragment = inflater.inflate(R.layout.fragment_payment, container, false);

        getActivity().setTitle("Payment");

        bindingPaymentFragmentViews();
        loadPaymentDetailsFunc();

        return viewPaymentFragment;
    }

    public void bindingPaymentFragmentViews() {
        editPaymentDetailsTextView = viewPaymentFragment.findViewById(R.id.edit_card_details_text);

        cardHolderNameTextView = viewPaymentFragment.findViewById(R.id.card_holder_name_text);
        cardHolderNameEditText = viewPaymentFragment.findViewById(R.id.card_holder_name_edit_text);

        cardHolderNumberTextView = viewPaymentFragment.findViewById(R.id.card_number_text);
        cardHolderNumberEditText = viewPaymentFragment.findViewById(R.id.card_number_edit_text);

        cardExpiryDateTextView = viewPaymentFragment.findViewById(R.id.card_expiry_date_text);
        cardExpiryDateEditTExt = viewPaymentFragment.findViewById(R.id.card_expiry_date_edit_text);

        cardCVVNumberTextView = viewPaymentFragment.findViewById(R.id.card_cvv_text);
        cardCVVNumberEditText = viewPaymentFragment.findViewById(R.id.card_cvv_edit_text);

        saveCardDetailsButton = viewPaymentFragment.findViewById(R.id.save_card_details);

        paymentRootLayout = viewPaymentFragment.findViewById(R.id.payment_root_layout);

        editPaymentDetailsTextView.setOnClickListener(this);
        saveCardDetailsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_card_details_text:
                editCardDetailsFunc();
                break;
            case R.id.save_card_details:
                saveCardDetailsFunc();
                break;
        }
    }

    public void editCardDetailsFunc() {
        editPaymentDetailsTextView.setVisibility(View.GONE);

        saveCardDetailsButton.setVisibility(View.VISIBLE);

        cardHolderNameTextView.setVisibility(View.GONE);
        cardHolderNumberTextView.setVisibility(View.GONE);
        cardExpiryDateTextView.setVisibility(View.GONE);
        cardCVVNumberTextView.setVisibility(View.GONE);

        cardHolderNameEditText.setVisibility(View.VISIBLE);
        cardHolderNumberEditText.setVisibility(View.VISIBLE);
        cardExpiryDateEditTExt.setVisibility(View.VISIBLE);
        cardCVVNumberEditText.setVisibility(View.VISIBLE);
    }

    public void saveCardDetailsFunc() {
        editPaymentDetailsTextView.setVisibility(View.VISIBLE);

        saveCardDetailsButton.setVisibility(View.GONE);

        cardHolderNameTextView.setVisibility(View.VISIBLE);
        cardHolderNumberTextView.setVisibility(View.VISIBLE);
        cardExpiryDateTextView.setVisibility(View.VISIBLE);
        cardCVVNumberTextView.setVisibility(View.VISIBLE);

        cardHolderNameEditText.setVisibility(View.GONE);
        cardHolderNumberEditText.setVisibility(View.GONE);
        cardExpiryDateEditTExt.setVisibility(View.GONE);
        cardCVVNumberEditText.setVisibility(View.GONE);

        PrefManager.setCardHolderName(getActivity(), String.valueOf(cardHolderNameEditText.getText()));
        PrefManager.setCardNumber(getActivity(), String.valueOf(cardHolderNumberEditText.getText()));
        PrefManager.setCardExpiryDate(getActivity(), String.valueOf(cardExpiryDateEditTExt.getText()));
        PrefManager.setCardCvvNumber(getActivity(), String.valueOf(cardCVVNumberEditText.getText()));

        snackBarFunc();
    }

    public void loadPaymentDetailsFunc() {
        cardHolderNameTextView.setText(PrefManager.getCardHolderName(getActivity()));
        cardHolderNumberTextView.setText(PrefManager.getCardNumber(getActivity()));
        cardExpiryDateTextView.setText(PrefManager.getCardExpiryDate(getActivity()));
        cardCVVNumberTextView.setText(PrefManager.getCardCvvNumber(getActivity()));
    }

    public void snackBarFunc() {
        paymentSnackBar = Snackbar
                .make(paymentRootLayout, "Payment Details Saved Successfully", Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveCardDetailsButton.setVisibility(View.GONE);
                    }
                });
        paymentSnackBar.setActionTextColor(Color.WHITE);


        View snackbarView = paymentSnackBar.getView();
        snackbarView.setBackgroundColor(getActivity().getResources().getColor(R.color.blue));
        TextView snackbarTextView = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        snackbarTextView.setTextColor(Color.WHITE);
        paymentSnackBar.show();
    }
}
