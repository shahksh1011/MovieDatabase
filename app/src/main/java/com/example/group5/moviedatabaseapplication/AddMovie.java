package com.example.group5.moviedatabaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.io.Serializable;

public class AddMovie extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("bc","mc");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        final EditText name = findViewById(R.id.movieName);
        final EditText description = findViewById(R.id.movieDescription);
        final EditText imdb = findViewById(R.id.imdbEdit);
        final EditText year = findViewById(R.id.yearEdit);
        final SeekBar rating = findViewById(R.id.ratingSeekbar);
        final Spinner genreSpinner  = findViewById(R.id.genreSpinner);
        Boolean flag =false;
        int p = 0;
        Button addMovie = findViewById(R.id.saveAddMovieButton);
        if (getIntent().getExtras()!=null){

            Movie m = (Movie) getIntent().getExtras().get("MOVIES");
            int position = (int) getIntent().getExtras().get("Position");
            name.setText(m.getName());
            description.setText(m.getDescription());
            imdb.setText(m.getMovieImdb());
            addMovie.setText("Save");
            year.setText(m.getMovieYear().toString());
            genreSpinner.setSelection(m.getMovieGenre());
            rating.setProgress(m.getMovieRating());
            Log.d("Position",String.valueOf(position) + m.getName());
            flag = true;
            p = position;
        }
        final int finalP = p;
        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().matches("") | description.getText().toString().matches("") | imdb.getText().toString().matches("") | year.getText().toString().matches("")){
                    new EditTextValidation(name,"Please Enter Name");
                    new EditTextValidation(description, "Please Enter Description");
                    new EditTextValidation(imdb,"Please Enter Imdb");
                    new EditTextValidation(year, "Please Enter Year");
                    }
                else{

                    Log.d("Hola","woo");
                    Log.d("Spinner", String.valueOf(genreSpinner.getSelectedItemId()));
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    Movie m = new Movie(name.getText().toString(), description.getText().toString(), imdb.getText().toString(),  (int) genreSpinner.getSelectedItemId(), Integer.parseInt(year.getText().toString()), rating.getProgress());
                    i.putExtra("MOVIES", (Serializable) m);
                    if (true)
                        i.putExtra("Position", finalP);
                    startActivity(i);
                }
            }
        });
    }
}
