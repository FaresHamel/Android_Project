package com.example.crafstman.explain;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crafstman.R;

public class ExplainActiivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);
        getSupportFragmentManager().beginTransaction().add(R.id.explain_fragment_container, new ExplainFragment()).commit();
    }
}