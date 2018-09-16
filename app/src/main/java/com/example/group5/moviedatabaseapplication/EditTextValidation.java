package com.example.group5.moviedatabaseapplication;

import android.widget.EditText;

public class EditTextValidation {
    EditTextValidation(EditText editText, String message){
        if (editText.getText().toString().matches(""))
            editText.setError(message);
    }
}
