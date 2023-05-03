package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    Map<String, Movie> movieMap = new HashMap<>();
    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public Optional<Movie> getMovieByName(String movieName) {
        if(movieMap.containsKey(movieName)){
            return Optional.of(movieMap.get(movieName));
        }
        return Optional.empty();
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieMap.values());
    }

    public void remove(String movie) {
        movieMap.remove(movie);
    }
}
