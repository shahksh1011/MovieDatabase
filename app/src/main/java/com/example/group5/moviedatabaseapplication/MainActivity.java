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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies = new ArrayList<Movie>();

    private Button addMovie,editMovie,deleteMovie,moviesByYear,moviesByRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies.add(new Movie("The Predator", "Movie is all about Action", "https://www.imdb.com/title/tt3829266/?ref_=adv_li_tt", 0, 2018, 4));
        movies.add(new Movie("Zootopia", "Movie is all about Animation", "https://www.imdb.com/title/tt2948356/", 1, 2016, 3));
        movies.add(new Movie("Forrest Gump", "Movie is all about Comedy", "https://www.imdb.com/title/tt0109830/", 2, 1994, 5));
        movies.add(new Movie("Harry Potter", "Movie is all about Family", "https://www.imdb.com/title/tt0241527/", 4, 2001, 4));
        movies.add(new Movie("Inside Job", "Movie is all about Documentary", "https://www.imdb.com/title/tt1645089/", 3, 2000, 4));
        movies.add(new Movie("Race 3", "Movie is all about Horror", "https://www.imdb.com/title/tt7431594/", 5, 2017, 0));
        movies.add(new Movie("The Godfather", "Movie is all about Crime", "https://www.imdb.com/title/tt0068646/", 6, 1972, 5));
        movies.add(new Movie("The adventure of Pluto Nash", "Movie is all about Others", "https://www.imdb.com/title/tt0180052/", 7, 2002, 1));

        addMovie = findViewById(R.id.addMovieButton);
        editMovie = findViewById(R.id.editMovieButton);
        deleteMovie = findViewById(R.id.deleteMovieButton);
        moviesByYear = findViewById(R.id.sortMovieByYearButton);
        moviesByRating = findViewById(R.id.sortMovieByRatingButton);
//
//        final ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(getApplicationContext(),android.R.layout.simple_spinner_item, movies);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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
                final ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(getApplicationContext(),android.R.layout.simple_spinner_item, movies);
                adapter.setDropDownViewResource(R.layout.list_row);
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Hello",movies.get(which).getName());
                    }
                });
                builder.create();
                builder.show();
            }
        });

        moviesByYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.group5.moviedatabaseapplication.intent.action.VIEW");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MOVIES", movies.get(0).getDescription());
        if (getIntent().getExtras()!=null){
            Movie m = (Movie) getIntent().getExtras().get("MOVIES");
            movies.add(m);
//            Log.d("pintu", String.valueOf(m.getMovieYear()));
        }
    }
}
