package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MovieRepository {
    public MovieRepository(){

    }
    Map<Integer, Movie> data = new HashMap<>();

    public Boolean add(Movie movie) {
        data.put(movie.getMovieId(), movie);
        return true;
    }

    public Optional<Movie> getById(int id) {
        if(data.containsKey(id)) {
            return Optional.of(data.get(id));
        }
        return Optional.empty();
    }

    public void removeById(int id) {
        data.remove(id);
    }
}
