package com.example.toolsshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DrillDetailActivity extends AppCompatActivity {
    String drillTitle;
    String drillInfo;
    int drillResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ImageView drillImageView = findViewById(R.id.drillDetailImg);
        TextView titleDrillTextView = findViewById(R.id.textViewDrillTitle);
        TextView infoDrillTextView = findViewById(R.id.textViewDrillInfo);

        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            drillTitle = intent.getStringExtra("title");
            drillInfo = intent.getStringExtra("info");
            drillResId = intent.getIntExtra("resId", -1);
        } else {
            Intent backToCategoryIntent = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategoryIntent);
        }
        titleDrillTextView.setText(drillTitle);
        infoDrillTextView.setText(drillInfo);
        drillImageView.setImageResource((drillResId));
    }
}
