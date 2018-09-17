package com.example.group5.moviedatabaseapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Movie> movies = new ArrayList<Movie>();

    private Button addMovie, editMovie, deleteMovie, moviesByYear, moviesByRating;
    static String MOVIES_KEY = "MOVIES";
    static String SHOW_LIST_TAG = "TAG";
    static ArrayAdapter<Movie> adapter;

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
                adapter = new ArrayAdapter<Movie>(getApplicationContext(), android.R.layout.simple_spinner_item, movies) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        // Cast list view each item as text view
                        TextView text_view = (TextView) super.getView(position, convertView, parent);
                        // Set text size
                        text_view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        // Finally, return the modified items
                        return text_view;
                    }
                };
                adapter.setDropDownViewResource(R.layout.list_row);
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Hello", movies.get(which).getName());
                        Intent i = new Intent(getApplicationContext(), AddMovie.class);
                        i.putExtra("Position", which);
                        i.putExtra("MOVIES", movies.get(which));
                        startActivity(i);
                    }
                });
                builder.setTitle("Pick a  Movie");
                // Create the alert dialog
                AlertDialog dialog = builder.create();
                // Get the alert dialog ListView instance
                ListView listView = dialog.getListView();
                // Set the divider color of alert dialog list view
                listView.setDivider(new ColorDrawable(Color.BLUE));
                // Set the divider height of alert dialog list view
                listView.setDividerHeight(5);
                // Finally, display the alert dialog
                dialog.show();
            }
        });

        moviesByYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.group5.moviedatabaseapplication.intent.action.VIEW");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.putExtra(MOVIES_KEY, movies);
                intent.putExtra(SHOW_LIST_TAG, "YEAR");
                startActivity(intent);
            }
        });

        moviesByRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.group5.moviedatabaseapplication.intent.action.VIEW");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.putExtra(MOVIES_KEY, movies);
                intent.putExtra(SHOW_LIST_TAG, "RATING");
                startActivity(intent);
            }
        });

        deleteMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                adapter = new ArrayAdapter<Movie>(getApplicationContext(), android.R.layout.simple_spinner_item, movies) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        // Cast list view each item as text view
                        TextView text_view = (TextView) super.getView(position, convertView, parent);
                        // Set text size
                        text_view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        // Finally, return the modified items
                        return text_view;
                    }
                };
                adapter.setDropDownViewResource(R.layout.list_row);
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Delete", movies.get(which).getName());
                        movies.remove(which);
                    }
                });
                builder.setTitle("Pick a  Movie");
                // Create the alert dialog
                AlertDialog dialog = builder.create();
                // Get the alert dialog ListView instance
                ListView listView = dialog.getListView();
                // Set the divider color of alert dialog list view
                listView.setDivider(new ColorDrawable(Color.BLUE));
                // Set the divider height of alert dialog list view
                listView.setDividerHeight(5);
                // Finally, display the alert dialog
                dialog.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MOVIES", movies.get(0).getDescription());

        if (getIntent().getExtras() != null) {
            Log.d("Moviessize", String.valueOf(movies.size()));
            Log.d("UPDATE", String.valueOf(getIntent().getExtras().containsKey("Position")));
            Movie m = (Movie) getIntent().getExtras().get("MOVIES");
            if (getIntent().getExtras().containsKey("Position")) {
                int p = getIntent().getExtras().getInt("Position");
                Log.d("Update", String.valueOf(getIntent().getExtras().containsKey("Position")));
                movies.get(p).setName(m.getName());
                movies.get(p).setDescription(m.getDescription());
                movies.get(p).setMovieGenre(m.getMovieGenre());
                movies.get(p).setMovieRating(m.getMovieRating());
                movies.get(p).setMovieImdb(m.getMovieImdb());
                movies.get(p).setMovieYear(m.getMovieYear());
                synchronized (movies){
                    movies.notifyAll();

                }

//                adapter.notifyDataSetChanged();
//                adapter.notifyDataSetChanged();
            } else{

                movies.add(new Movie(m.getName(),m.getDescription(),m.getMovieImdb(),m.getMovieGenre(),m.getMovieYear(),m.getMovieRating()));
                if (movies.size() > 8)
                    Log.d("MovieSizesssss", movies.get(8).getName());
                Log.d("MovieSize", String.valueOf(movies.size()));
                synchronized (movies){
                    movies.notifyAll();

                }
//                adapter.notifyDataSetChanged();
            }

            getIntent().removeExtra("MOVIES");
            getIntent().removeExtra("Position");
//            movies.add(new Movie("The adventure of Pluto Nash", "Movie is all about Others", "https://www.imdb.com/title/tt0180052/", 7, 2002, 1));
        }
    }


}
