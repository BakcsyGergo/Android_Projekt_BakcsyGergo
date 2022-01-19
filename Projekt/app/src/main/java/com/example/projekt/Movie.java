package com.example.projekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {
    private String mName;
    private int mDrawable;
    private String mGenre;
    private String mLength;

    public Movie(String name, int drawable, String genre, String length) {
        mName = name;
        mDrawable = drawable;
        mGenre = genre;
        mLength = length;
    }

    public String getName() {
        return mName;
    }

    public int getDrawable() {
        return mDrawable;
    }

    public String getGenre() {
        return mGenre;
    }

    public String getLength() {
        return mLength;
    }

    // Returns a list of contacts
    public static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Avengers", R.drawable.avengers, "Super-Hero","180"));
        movies.add(new Movie("Blade Runner", R.drawable.blade, "Sci-fi","165"));
        movies.add(new Movie("Once Upon a Time...", R.drawable.hollywood, "Drama","165"));
        movies.add(new Movie("Inception", R.drawable.inception, "Action","150"));
        movies.add(new Movie("Interstellar", R.drawable.interstellar, "Sci-fi","181"));
        movies.add(new Movie("Joker", R.drawable.joker, "Drama","124"));
        movies.add(new Movie("Mad Max", R.drawable.mad, "Action","122"));
        movies.add(new Movie("Martian", R.drawable.martian, "Sci-fi","132"));
        movies.add(new Movie("Noah", R.drawable.noah, "Biblical","145"));
        movies.add(new Movie("Witch", R.drawable.witch, "Horror","133"));

        return movies;
    }
}
