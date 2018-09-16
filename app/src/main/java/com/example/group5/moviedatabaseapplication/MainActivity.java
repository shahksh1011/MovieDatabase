package com.example.group5.moviedatabaseapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MovieList> movieLists = new ArrayList<MovieList>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieLists.add(new MovieList("The Predator", "Movie is all about Action", "https://www.imdb.com/title/tt3829266/?ref_=adv_li_tt", 0, 2018, 4));
        movieLists.add(new MovieList("Zootopia", "Movie is all about Animation", "https://www.imdb.com/title/tt2948356/", 1, 2016, 3));
        movieLists.add(new MovieList("Forrest Gump", "Movie is all about Comedy", "https://www.imdb.com/title/tt0109830/", 2, 1994, 5));
        movieLists.add(new MovieList("Harry Potter", "Movie is all about Family", "https://www.imdb.com/title/tt0241527/", 4, 2001, 4));
        movieLists.add(new MovieList("Inside Job", "Movie is all about Documentary", "https://www.imdb.com/title/tt1645089/", 3, 2000, 4));
        movieLists.add(new MovieList("Race 3", "Movie is all about Horror", "https://www.imdb.com/title/tt7431594/", 5, 2017, 0));
        movieLists.add(new MovieList("The Godfather", "Movie is all about Crime", "https://www.imdb.com/title/tt0068646/", 6, 1972, 5));
        movieLists.add(new MovieList("The adventure of Pluto Nash", "Movie is all about Others", "https://www.imdb.com/title/tt0180052/", 7, 2002, 1));




        String str = "hello world";
        Button addMovie = findViewById(R.id.addMovieButton);
        Button editMovie = findViewById(R.id.editMovieButton);
        Button deleteMovie = findViewById(R.id.deleteMovieButton);
        Button moviesByYear = findViewById(R.id.sortMovieByYearButton);
        final Button moviesByRating = findViewById(R.id.sortMovieByRatingButton);

        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddMovie.class);
                startActivity(intent);
            }
        });

        editMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final ArrayAdapter<MovieList> adapter = new ArrayAdapter<MovieList>(getApplicationContext(),android.R.layout.simple_spinner_item, movieLists);
                adapter.setDropDownViewResource(R.layout.list_row);

                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Hello",movieLists.get(which).getName());
                    }
                });
                builder.create();
                builder.show();
//                Spinner movieSpinner = findViewById(R.id.movieListSpinner);
//                movieSpinner.setAdapter(adapter);
//                movieSpinner.setVisibility(View.VISIBLE);
            }
        });


    }
}
