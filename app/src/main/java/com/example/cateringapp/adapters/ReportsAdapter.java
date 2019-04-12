package com.example.cateringapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cateringapp.R;
import com.example.cateringapp.models.Reports;

import java.util.List;

public class ReportsAdapter extends ArrayAdapter<Reports> {

    // List context
    private final Context context;

    private final List<Reports> reportsList;

    public ReportsAdapter(Context contextx, int textViewResourceId, List<Reports> reports) {
        super(contextx, textViewResourceId);
        context = contextx;
        reportsList = reports;
    }

    // add item to adapter
    public void add(Reports log) {
        reportsList.add(log);
    }

    // remove from adapter
    public void remove(Reports log) {
        reportsList.remove(log);
    }

    // get adapter count
    public int getCount() {
        return reportsList.size();
//        return 10;
    }

    // get contact by position
    public Reports getItem(int position) {
        return reportsList.get(position);
    }

    // inflate view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Reports mLog = reportsList.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_reports, parent, false);
        TextView personContact = v.findViewById(R.id.contact);
        personContact.setText(mLog.get_name());
        return v;
    }
}
