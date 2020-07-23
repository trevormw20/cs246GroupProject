package com.example.retailstoresurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class ReviewChart extends AppCompatActivity {
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews);
        getData();

        //barChart = findViewById(R.id.review_chart);

        barDataSet = new BarDataSet(barEntries, "Data set");
        barData = new BarData(barDataSet);

        barChart.setData(barData);

        //customize options
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(18f);
    }

    private void getData() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 2));
        barEntries.add(new BarEntry(3f, 4));
        barEntries.add(new BarEntry(5f, 7));
        barEntries.add(new BarEntry(6f, 10));
        barEntries.add(new BarEntry(7f, 13));
    }

}
