package com.example.crafstman.error;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crafstman.R;

public class ErrorAcrivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error_acrivity);
        getSupportFragmentManager().beginTransaction().add(R.id.continer_error_fragment, new ErrorFragment()).commit();
    }
}