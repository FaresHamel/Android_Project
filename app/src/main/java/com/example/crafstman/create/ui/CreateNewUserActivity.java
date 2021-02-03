package com.example.crafstman.create.ui;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.crafstman.R;
import com.example.crafstman.data.model.CreateUser;
import com.example.crafstman.dialog.ui.dialog;
import com.example.crafstman.explain.ExplainActiivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.crafstman.R.layout.activity_sing_up;

public class CreateNewUserActivity extends AppCompatActivity {

    public final String url = "http://192.168.43.62:8080/clients/singUp";

    public EditText EditTextUserName;
    public EditText EditTextFirstName;
    public EditText EditTextLastName;
    public EditText EditTextNumberPhone;
    public EditText EditTextEmail;
    public EditText EditTextPassword;
    public EditText EditTextCity;
    public EditText EditTextVille;

    public Button btnArrowbacklogin;
    public Button btnSingUp;

    public String username;
    public String firstname;
    public String lastname;
    public String numberPhoneString;
    public String Email;
    public String Password;
    public long numberPhone;
    public String city;
    public String ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_sing_up);

        EditTextUserName = findViewById(R.id.user_name_sing_up);
        EditTextFirstName = findViewById(R.id.first_name_sing_up);
        EditTextLastName = findViewById(R.id.last_name_sing_up);
        EditTextNumberPhone = findViewById(R.id.number_phone_sing_up);
        EditTextEmail = findViewById(R.id.emil_sing_up);
        EditTextPassword = findViewById(R.id.passord_sing_up);
        EditTextCity = findViewById(R.id.city_sing_up);
        EditTextVille = findViewById(R.id.ville_sing_up);

        btnArrowbacklogin = (Button) findViewById(R.id.btn_back_login_page);
        btnSingUp = (Button) findViewById(R.id.login_btn_create_new_user);

        //Button to ruturn the main Page
        btnArrowbacklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CreateNewUserActivity.this, ExplainActiivity.class);
                startActivity(intent);
                finish();

            }
        });
        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validationData valid = new validationData();

                if (valid.validateUsername(EditTextUserName) && valid.validateFirstName(EditTextFirstName) &&
                    valid.validateLastName(EditTextLastName)  && valid.validateEmail(EditTextEmail) &&
                    valid.validatePhoneNumber(EditTextNumberPhone)  && valid.validatePassword(EditTextPassword) &&
                    valid.validateCity(EditTextCity) && valid.validateVille(EditTextVille)
                    ){
                    enableButtons();

                    username = EditTextUserName.getText().toString();
                    firstname = EditTextFirstName.getText().toString();
                    lastname = EditTextLastName.getText().toString();
                    numberPhoneString = EditTextNumberPhone.getText().toString();
                    Email = EditTextEmail.getText().toString();
                    Password = EditTextPassword.getText().toString();
                    city = EditTextCity.getText().toString();
                    ville = EditTextVille.getText().toString();

                    numberPhone = Long.parseLong(numberPhoneString);
                    if (isOnline()) {

                         CreateUser createUser = new CreateUser(username, firstname, lastname, Email, Password, numberPhone, city, ville);
                         sendDatas sendDatas = new sendDatas(CreateNewUserActivity.this);
                         sendDatas.createUser(createUser);

                    }else { Toast.makeText(CreateNewUserActivity.this, "please check your Internet",Toast.LENGTH_LONG).show();
                    } } } }); }

    //enable Buttons methods
    public void enableButtons() {
        btnSingUp.setEnabled(false);
        btnArrowbacklogin.setEnabled(false);
    }
    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected()); }}