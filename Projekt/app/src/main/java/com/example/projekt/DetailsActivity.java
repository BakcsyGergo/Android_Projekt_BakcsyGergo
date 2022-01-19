package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle extras = getIntent().getExtras();
        String selectedItem1 = extras.getString("EXTRA_MOVIE");

        TextView textView = (TextView) findViewById(R.id.selectedopt);
        textView.setText("You have selected "+selectedItem1);
    }
}