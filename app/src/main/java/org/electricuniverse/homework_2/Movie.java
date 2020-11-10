package org.electricuniverse.homework_2;

/**
 * Created by acer on 03.04.2017.
 */

public class Movie {
    private String name;
    private String year;
    private int poster_id;
    public String getName()
    {
        return this.name;
    }
    public String getYear()
    {
        return this.year;
    }
    public int getPoster_id()
    {
        return this.poster_id;
    }
    public Movie(String name, String year, int poster_id)
    {
        this.name = name;
        this.year = year;
        this.poster_id = poster_id;
    }
}