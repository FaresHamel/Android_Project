package com.example.crafstman.create.ui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.crafstman.data.model.CreateUser;
import com.example.crafstman.dialog.ui.dialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class sendDatas {

    public CreateNewUserActivity createNewUserActivity2;

    private final String url = "http://192.168.43.62:8080/clients/singUp";
    public sendDatas(CreateNewUserActivity createNewUserActivity1){

        this.createNewUserActivity2 = createNewUserActivity1;

    }

    public void  createUser(CreateUser createUser){

        RequestQueue requestQueue = Volley.newRequestQueue(createNewUserActivity2);

        Map<String, String> map = new HashMap<>();
        map.put("username", createUser.getUsername());
        map.put("city", createUser.getCity());
        map.put("ville", createUser.getVille());
        map.put("firstname", createUser.getFirstName());
        map.put("lastname", createUser.getLastName());
        map.put("email", createUser.getEmail());
        map.put("password", createUser.getPassword());
        map.put("numberphone", String.valueOf(createUser.getNumberPhone()));

        JSONObject jsonObj = new JSONObject(map);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonObj, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            boolean result = response.getBoolean("insertion");
                            if (result) {
                                Intent intent = new Intent(createNewUserActivity2, dialog.class);

//                                ContextCompat.startActivity(createNewUserActivity,intent);
                                ContextCompat.startActivity(createNewUserActivity2,intent,null);

                            } else {
                                Intent intent = new Intent(createNewUserActivity2, CreateNewUserActivity.class);

//                                ContextCompat.startActivity(createNewUserActivity,intent);
                                ContextCompat.startActivity(createNewUserActivity2,intent,null);
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
