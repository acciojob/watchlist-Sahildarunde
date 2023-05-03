package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity("Added successfully", HttpStatus.CREATED); //200
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added sucessfully", HttpStatus.CREATED);
    }
    @PostMapping("add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.addMovieToDirector(movie, director);
        return new ResponseEntity<>("Sucessfully added movie-director pair", HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorAndMovies(name);
        return new ResponseEntity<>("Deleted Director & its Movies", HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectorAndMovies();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
