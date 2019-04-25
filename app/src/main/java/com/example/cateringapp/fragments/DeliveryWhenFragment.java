package com.example.cateringapp.fragments;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cateringapp.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryWhenFragment extends DialogFragment implements View.OnClickListener {

    View viewDeliveryWhenFragment;
    private Spinner servicesDeliveryWhenSpinner;
    private CheckBox breakfastDeliveryWhenCheckBox, lunchDeliveryWhenCheckBox, dinnerDeliveryWhenCheckBox, asapDeliveryWhenCheckBox;
    private EditText eventNameDeliveryWhenEditText;
    private DatePicker datePickerDeliveryWhen;
    private Calendar calendarDeliveryWhen;
    private TextView serviceTypeTextView, scheduleServiceTextView, scheduleOrderTextView, scheduledDateTextView, scheduledTimeTextView;
    private ImageView scheduleDateImageView, scheduleTimeImageView;
    private int year, month, day;
    private ArrayAdapter<CharSequence> charSequenceArrayAdapterDeliveryWhen;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewDeliveryWhenFragment = inflater.inflate(R.layout.fragment_delivery_when, container, false);

        getActivity().setTitle("When To Deliver?");

        bindingDeliveryWhenViewsFunc();

        return viewDeliveryWhenFragment;
    }

    public void bindingDeliveryWhenViewsFunc() {
        //Binding SERVICE TYPE spinner
        servicesDeliveryWhenSpinner = viewDeliveryWhenFragment.findViewById(R.id.delivery_service_type_spinner);

        //Binding SERVICE TYPE text view
        serviceTypeTextView = viewDeliveryWhenFragment.findViewById(R.id.tiffin_service_type);

        //Binding SERVICE TYPE check box
        breakfastDeliveryWhenCheckBox = viewDeliveryWhenFragment.findViewById(R.id.break_fast_service);
        lunchDeliveryWhenCheckBox = viewDeliveryWhenFragment.findViewById(R.id.lunch_service);
        dinnerDeliveryWhenCheckBox = viewDeliveryWhenFragment.findViewById(R.id.dinner_service);

        //Binding EVENT NAME edit text
        eventNameDeliveryWhenEditText = viewDeliveryWhenFragment.findViewById(R.id.event_name_edit_text);

        //Binding SCHEDULE SERVICE text view
        scheduleServiceTextView = viewDeliveryWhenFragment.findViewById(R.id.schedule_tiffin_service);

        //Binding SCHEDULE SERVICE checkbox
        asapDeliveryWhenCheckBox = viewDeliveryWhenFragment.findViewById(R.id.asap_tiffin_service);

        //Binding SCHEDULE AN ORDER  DATE & TIME text view
        scheduleOrderTextView = viewDeliveryWhenFragment.findViewById(R.id.schedule_an_order_text_view);
        scheduledDateTextView = viewDeliveryWhenFragment.findViewById(R.id.schedule_order_date);
        scheduledTimeTextView = viewDeliveryWhenFragment.findViewById(R.id.schedule_order_time);

        //Binding SCHEDULE DATE & TIME image view
        scheduleDateImageView = viewDeliveryWhenFragment.findViewById(R.id.schedule_date_icon);
        scheduleTimeImageView = viewDeliveryWhenFragment.findViewById(R.id.schedule_time_icon);

        scheduledDateTextView.setOnClickListener(this);
        scheduledTimeTextView.setOnClickListener(this);
        scheduleDateImageView.setOnClickListener(this);
        scheduleTimeImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.schedule_order_date:

                break;
            case R.id.schedule_date_icon:

                break;
            case R.id.schedule_order_time:

                break;
            case R.id.schedule_time_icon:

                break;
        }
    }

    /*public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getActivity(), "ca", Toast.LENGTH_SHORT).show();
    }

    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(getActivity(), myDateListener, year, month, day);
        }
        return null;
    }


    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        scheduledDateTextView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }*/

    /*public void dummy(){
        calendarDeliveryWhen = Calendar.getInstance();
        DatePickerDialog datePickerDialog;
        scheduleDateDeliveryWhenLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateTimeField() ;
            }
        });
    }

    private void setDateTimeField() {
        Calendar newCalendar = calendarDeliveryWhen;
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendarDeliveryWhen.set(year, monthOfYear, dayOfMonth, 0, 0);
                scheduledDateTextView.setText(dateFormatter.format(calendarDeliveryWhen.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        scheduledDateTextView.setText(dateFormatter.format(calendarDeliveryWhen.getTime()));
    }*/
}
