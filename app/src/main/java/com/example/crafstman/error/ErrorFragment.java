package com.example.crafstman.error;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.crafstman.R;
import com.example.crafstman.explain.ExplainActiivity;

public class ErrorFragment extends Fragment {


    protected TextView textViewOopsTex;
    protected ImageView imageViewConnectionInternet;
    private TextView textViewAlertTextInternetConnection;
    private Button btnTryAgain;
    private ProgressBar progressBarTryChecInternet;

    public ErrorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_error, container, false);

        //get the element from the view fragment
        textViewAlertTextInternetConnection = (TextView) view.findViewById(R.id.textview_alert_text);
        textViewOopsTex = (TextView) view.findViewById(R.id.text_view_opps_text);
        imageViewConnectionInternet = (ImageView) view.findViewById(R.id.image_view_internet_connection);
        progressBarTryChecInternet = (ProgressBar) view.findViewById(R.id.progress_try_again_internet_connection);


        btnTryAgain = (Button) view.findViewById(R.id.btn_click_try_again);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set the visibilite to GONE this mean Not get space in Fragment
                imageViewConnectionInternet.setVisibility(View.GONE);
                textViewOopsTex.setVisibility(View.GONE);
                textViewAlertTextInternetConnection.setVisibility(View.GONE);
                btnTryAgain.setVisibility(View.GONE);

                //Set visibility for the progress Bar to vissible
                progressBarTryChecInternet.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        boolean testConnection = isOnline();

                        if (testConnection == true) {

                            Intent intent = new Intent(getContext(), ExplainActiivity.class);
                            view.getContext().startActivity(intent);
                            getActivity().finish();

                        } else {

                            //set the visibilite to GONE this mean Not get space in Fragment
                            imageViewConnectionInternet.setVisibility(View.VISIBLE);
                            textViewOopsTex.setVisibility(View.VISIBLE);
                            textViewAlertTextInternetConnection.setVisibility(View.VISIBLE);
                            btnTryAgain.setVisibility(View.VISIBLE);

                            //Set visibility for the progress Bar to vissible
                            progressBarTryChecInternet.setVisibility(View.GONE);

                        }

                    }
                }, 2000);

            }
        });

        return view;
    }


    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}