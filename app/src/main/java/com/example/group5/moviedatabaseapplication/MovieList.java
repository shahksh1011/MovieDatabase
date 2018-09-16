package com.example.group5.moviedatabaseapplication;

public class MovieList {
    private String name;
    private String description;
    private String movieImdb;
    private int movieGenre, movieYear, movieRating;
    MovieList(String name, String description, String movieImdb, int movieGenre, int movieYear, int movieRating){
        this.name = name;
        this.movieYear = movieYear;
        this.description = description;
        this.movieRating = movieRating;
        this.movieGenre = movieGenre;
        this.movieImdb = movieImdb;

    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovieImdb() {
        return movieImdb;
    }

    public void setMovieImdb(String movieImdb) {
        this.movieImdb = movieImdb;
    }

    public int getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(int movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }



}
