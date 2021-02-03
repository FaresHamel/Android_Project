package com.example.crafstman.login.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.crafstman.R;
import com.example.crafstman.create.ui.CreateNewUserActivity;
import com.example.crafstman.data.model.LoggedInUser;
import com.example.crafstman.dialog.ui.dialog;
import com.example.crafstman.error.ErrorAcrivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    public EditText usernameEditText;
    public EditText passwordEditText;
    public Button loginButton;
    public ProgressBar loadingProgressBar;
    public Button loginFacebook;
    public Button loginGoogle;
    public TextView forgetPassword;
    public TextView createNewAcount;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_btn);
        loadingProgressBar = findViewById(R.id.loading);
        loginFacebook = (Button) findViewById(R.id.login_login_with_facebook);
        loginGoogle = (Button) findViewById(R.id.login_login_with_google);
        forgetPassword = (TextView) findViewById(R.id.text_forget_password_login);
        createNewAcount = (TextView) findViewById(R.id.text_create_new_acount);

        //Activ Login Button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Call enable the All Buttons Method
                enableButtons();

                //Called enable TextView Clickable True for disbale bcause it is like Buttons
                enableTextViewClickable();

                final String email = usernameEditText.getText().toString();
                final String password = passwordEditText.getText().toString();


                if (email.equals("") || password.equals("")) {

                    if (email.equals("")) {
                        usernameEditText.setError("Enter your name");
                    }
                    if (password.equals("")) {
                        passwordEditText.setError("Enter your password");
                    }

                } else {

                    new Handler().postDelayed(new Runnable() {
                        @SuppressLint("ResourceAsColor")
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void run() {

                            boolean testConnection = isOnline();

                            loginFacebook.setVisibility(View.GONE);
                            loginGoogle.setVisibility(View.GONE);
                            loadingProgressBar.setVisibility(View.VISIBLE);

                            if (testConnection) {

                                LoggedInUser loggedInUser = new LoggedInUser(email, password);
                                LoginUser(loggedInUser);

                            } else {
                                Intent intent = new Intent(LoginActivity.this, ErrorAcrivity.class);
                                LoginActivity.this.startActivity(intent);
                                LoginActivity.this.finish();
                            }

                        }
                    }, 2000);
                }
            }

            //enable Buttons methods
            public void enableButtons() {

                // loginButton.setEnabled(false);
                loginFacebook.setEnabled(false);
                loginGoogle.setEnabled(false);
            }

            //enable TextView Clicable True
            public void enableTextViewClickable() {
                forgetPassword.setEnabled(false);
                createNewAcount.setEnabled(false);
            }
        });


        createNewAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, CreateNewUserActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    public void LoginUser(final LoggedInUser loggedInUser) {

        String url = "http://192.168.43.62:8081/login/loginuser";
        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);

        Map<String, String> map = new HashMap<>();
        map.put("firstname", loggedInUser.getEmail());
        map.put("lastname", loggedInUser.getPassword());

        JSONObject jsonObj = new JSONObject(map);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonObj, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            boolean result = response.getBoolean("result");
                            if (result) {
                                Intent intent = new Intent(LoginActivity.this, dialog.class);
                                startActivity(intent);
                                finish();
                            } else {
                                usernameEditText.setError("Error enter correct email please .");
                            }

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Volly", error + "");
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }
}