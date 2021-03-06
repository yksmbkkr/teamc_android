package com.example.ks.suraksha.UI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ks.suraksha.R;
import com.example.ks.suraksha.Utility.Stats;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class AadharFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        BarChart v= (BarChart) inflater.inflate(R.layout.chart_view, container, false);

        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String>labels=new ArrayList<>();

        float y= (float) Math.random();
        entries.add(new BarEntry(0,y));
        entries.add(new BarEntry(1,1-y));

        labels.add("HAVE");
        labels.add("NOT HAVE");

        BarDataSet genderDataSet;
        genderDataSet = new BarDataSet(entries, "AADHAR DISTRIBUTION");
        genderDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(genderDataSet);
        BarData data = new BarData(dataSets);
        v.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));

        data.setValueTextSize(24f);
        data.setBarWidth(0.9f);
        YAxis axisLeft=v.getAxisLeft();
        axisLeft.setAxisMaximum(1f);
        axisLeft.setGranularity(.01f);

        YAxis axisRight=v.getAxisRight();
        axisRight.setAxisMaximum(1f);
        axisRight.setGranularity(.01f);
        v.setTouchEnabled(false);
        v.setData(data);
        return v;
    }
}
