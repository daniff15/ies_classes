package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private QuoteProduct service;

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie m) {
        return service.saveMovie(m);
    }

    @PostMapping("/addMovies")
    public List<Movie> addMovies(@RequestBody List<Movie> products) {
        return service.saveMovies(products);
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return service.getMovies();
    }

    @GetMapping("/movieById/{id}")
    public Movie findMovieById(@PathVariable int id) {
        return service.getMovieById(id);
    }

    @GetMapping("/movie/{name}")
    public Movie findMovieByName(@PathVariable String name) {
        return service.getMovieByName(name);
    }

    @PutMapping("/updateMovie")
    public Movie updateProduct(@RequestBody Movie product) {
        return service.updateMovie(product);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable int id) {
        return service.deleteMovie(id);
    }
}