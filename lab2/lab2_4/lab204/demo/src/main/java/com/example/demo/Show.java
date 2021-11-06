package com.example.demo;

public class Show {
	private final long id;
    private final String name;
    
    public Show(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public long getId() {
        return id;
    }
    
}