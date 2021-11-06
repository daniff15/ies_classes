package com.example.demo;

public class Movie {
    private String name;
    private int id;

    public Movie(int id, String name) {
        this.name = name;
        this.id=id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

}
