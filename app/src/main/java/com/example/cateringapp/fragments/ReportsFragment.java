package com.example.cateringapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cateringapp.R;
import com.example.cateringapp.adapter.ReportsAdapter;
import com.example.cateringapp.database.DatabaseHelper;
import com.example.cateringapp.model.Reports;
import com.example.cateringapp.utils.DateUtilities;

import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportsFragment extends Fragment implements View.OnClickListener {

    private static final String STATE_DATE = "retain_date"; // save date on screen rotation

    private DatabaseHelper databaseHelper;
    Reports reports;
    private ReportsAdapter reportsAdapter;
    private Date mDate;
    private EditText editText;
    private ListView listView;
    private TextView txtDate;
    private Button prevDateBtn, nextDateBtn;

    public ReportsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reports, container, false);

        // Retain Instance State
        if (savedInstanceState != null) {
            mDate = (Date) savedInstanceState.getSerializable(STATE_DATE);
        } else {
            mDate = new Date();
        }

        // Widgets
        listView = view.findViewById(R.id.listView);
        txtDate = view.findViewById(R.id.mDate);

        prevDateBtn = view.findViewById(R.id.prevD);
        nextDateBtn = view.findViewById(R.id.nexD);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Reports reports = reportsAdapter.getItem(position);
                Snackbar.make(view, reports.get_name(), Snackbar.LENGTH_SHORT).show();*/
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                /*Snackbar.make(view, reports.get_name(), Snackbar.LENGTH_SHORT).show();
                databaseHelper.deleteReport(reports);
                reportsAdapter.remove(reports);
                reportsAdapter.notifyDataSetChanged();*/

                return false;
            }
        });

        prevDateBtn.setOnClickListener(this);
        nextDateBtn.setOnClickListener(this);

        // Set the adapter based on date
//        setAdapterFunc(mDate);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.prevD:
                prevDateFunc();
                break;
            case R.id.nexD:
                nextDateFunc();
                break;
        }
    }

    public void prevDateFunc() {
        mDate = DateUtilities.previousDate();
//        setAdapterFunc(mDate);
    }

    public void nextDateFunc() {
        mDate = DateUtilities.nextDate();
//        setAdapterFunc(mDate);
    }

    // Filter data by date
    private void setAdapterFunc(Date newDate) {
        String date = DateUtilities.dateToString(newDate); // Convert date to string
        databaseHelper = new DatabaseHelper(getActivity());

        List<Reports> contacts = databaseHelper.getReportByDate(date); // filter by string
        Log.d("TAG", contacts.toString());
        reportsAdapter = new ReportsAdapter(getActivity(), 0, contacts);
        listView.setAdapter(reportsAdapter);
        txtDate.setText(DateFormat.format("MMM dd", newDate));
    }

    //Save date on screen rotation
    @Override
    public void onSaveInstanceState(@NonNull Bundle state) {
        super.onSaveInstanceState(state);
        state.putSerializable(STATE_DATE, mDate);
    }
}
