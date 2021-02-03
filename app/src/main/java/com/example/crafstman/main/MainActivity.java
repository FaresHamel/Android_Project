package com.example.crafstman.main;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.crafstman.R;
import com.example.crafstman.error.ErrorAcrivity;
import com.example.crafstman.explain.ExplainActiivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_content_main_splashscrean, new splashScreanFragment()).commit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean testConnection = isOnline();

                if (testConnection == true) {
                    Intent intent = new Intent(MainActivity.this, ExplainActiivity.class);
                    MainActivity.this.startActivity(intent);
                    MainActivity.this.finish();
                } else {
                    Intent intent = new Intent(MainActivity.this, ErrorAcrivity.class);
                    MainActivity.this.startActivity(intent);
                    MainActivity.this.finish();
                }

            }
        }, 2000);
    }


    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    public static class splashScreanFragment extends Fragment {

        public splashScreanFragment() {

        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            final View view = inflater.inflate(R.layout.splash_screan_fragment, container, false);
            return view;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
    }
}
