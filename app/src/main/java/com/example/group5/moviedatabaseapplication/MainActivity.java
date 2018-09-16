package com.example.group5.moviedatabaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str = "hello world";
        Button addMovie = findViewById(R.id.addMovieButton);
        Button editMovie = findViewById(R.id.editMovieButton);
        Button deleteMovie = findViewById(R.id.deleteMovieButton);
        Button moviesByYear = findViewById(R.id.sortMovieByYearButton);
        Button moviesByRating = findViewById(R.id.sortMovieByRatingButton);

        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddMovie.class);
                startActivity(intent);
            }
        });


    }
}
