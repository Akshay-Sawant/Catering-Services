package com.example.cateringapp.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cateringapp.R;

public class CustomSnackBarHelper {

    private static Snackbar mCustomSnackBar;
    private View snackBarView;
    private TextView snackBarTextView;

    public void snackBarFunc(Context context, ViewGroup parent, String message, @Snackbar.Duration int duration) {
        mCustomSnackBar = Snackbar
                .make(parent, message, duration);
        mCustomSnackBar.setActionTextColor(Color.WHITE);

        snackBarView = mCustomSnackBar.getView();
        snackBarView.setBackgroundColor(context.getResources().getColor(R.color.blue));
        snackBarTextView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        snackBarTextView.setTextColor(Color.WHITE);
        mCustomSnackBar.show();
    }
}
