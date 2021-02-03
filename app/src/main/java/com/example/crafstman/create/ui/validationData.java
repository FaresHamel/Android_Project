package com.example.crafstman.create.ui;

import android.widget.EditText;

public class validationData {

    protected boolean validateUsername(EditText EditTextUserName) {
        String val = EditTextUserName.getText().toString().trim();
//        String checkspaces = "Aw{1,20}z";

        if (val.isEmpty()) {
            EditTextUserName.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            EditTextUserName.setError("Username is too large!");
            return false;
        } else {
            EditTextUserName.setError(null);
            EditTextUserName.setEnabled(false);
            return true;
        }
    }

    protected boolean validateFirstName(EditText EditTextFirstName) {
        String username = EditTextFirstName.getText().toString().trim();
        if (username.isEmpty()) {
            EditTextFirstName.setError("Field can not be empty");
            return false;
        } else {
            EditTextFirstName.setError(null);
            EditTextFirstName.setEnabled(false);
            return true;
        }
    }

    protected boolean validateLastName(EditText EditTextLastName) {
        String username = EditTextLastName.getText().toString().trim();
        if (username.isEmpty()) {
            EditTextLastName.setError("Field can not be empty");
            return false;
        } else {
            EditTextLastName.setError(null);
            EditTextLastName.setEnabled(false);
            return true;
        }
    }

    protected boolean validateCity(EditText EditTextCity) {
        String username = EditTextCity.getText().toString().trim();
        if (username.isEmpty()) {
            EditTextCity.setError("Field can not be empty");
            return false;
        } else {
            EditTextCity.setError(null);
            EditTextCity.setEnabled(false);
            return true;
        }
    }

    protected boolean validateVille(EditText EditTextVille) {
        String username = EditTextVille.getText().toString().trim();
        if (username.isEmpty()) {
            EditTextVille.setError("Field can not be empty");
            return false;
        } else {
            EditTextVille.setError(null);
            EditTextVille.setEnabled(false);
            return true;
        }
    }


    protected boolean validateEmail(EditText EditTextEmail) {
        String val = EditTextEmail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            EditTextEmail.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            EditTextEmail.setError("Invalid Email!");
            return false;
        } else {
            EditTextEmail.setError(null);
            EditTextEmail.setEnabled(false);
            return true;
        }
    }

    protected boolean validatePassword(EditText EditTextPassword) {
        String val = EditTextPassword.getText().toString().trim();
//        String checkPassword = "^" +
//                //"(?=.*[0-9])" +         //at least 1 digit
//                //"(?=.*[a-z])" +         //at least 1 lower case letter
//                //"(?=.*[A-Z])" +         //at least 1 upper case letter
////                "(?=.*[a-zA-Z])" +      //any letter
//                "(?=.*[@#$%^&+=])" +    //at least 1 special character
//                "(?=$)" +           //no white spaces
////                ".{4,}" +               //at least 4 characters
//                "$";

        if (val.isEmpty()) {
            EditTextPassword.setError("Field can not be empty");
            return false;
        } else {
            EditTextPassword.setError(null);
            EditTextPassword.setEnabled(false);
            return true;
        }
    }

    protected boolean validatePhoneNumber(EditText EditTextNumberPhone) {
        String val = EditTextNumberPhone.getText().toString().trim();
//        String checkspaces = "Aw{1,20}z";
        if (val.isEmpty()) {
            EditTextNumberPhone.setError("Enter valid phone number");
            return false;
        }  else {
            EditTextNumberPhone.setError(null);
            EditTextNumberPhone.setEnabled(false);
            return true;
        }
    }
}
