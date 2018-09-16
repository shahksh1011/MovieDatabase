package com.example.group5.moviedatabaseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        final EditText name = findViewById(R.id.movieName);
        final EditText description = findViewById(R.id.movieDescription);
        final EditText imdb = findViewById(R.id.imdbEdit);
        final EditText year = findViewById(R.id.yearEdit);
        Spinner genreSpinner  = findViewById(R.id.genreSpinner);
        Button addMovie = findViewById(R.id.saveAddMovieButton);

        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().matches("") | description.getText().toString().matches("") | imdb.getText().toString().matches("") | year.getText().toString().matches("")){
                    new EditTextValidation(name,"Please Enter Name");
                    new EditTextValidation(description, "Please Enter Description");
                    new EditTextValidation(imdb,"Please Enter Imdb");
                    new EditTextValidation(year, "Please Enter Year");
                }
                else
                    Log.d("Hola","woo");
            }
        });


    }
}
