package com.example.bakcsygergoprojekt;

public class Movie {
    private String title;
    private String year;
    private String type;
    private String poster;

    public Movie( String title, String year, String type, String poster) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.poster = poster;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                ", Title='" + title + '\'' +
                ", Year='" + year + '\'' +
                ", Type='" + type + '\'' +
                ", Poster='" + poster + '\'' +
                '}';
    }
}
