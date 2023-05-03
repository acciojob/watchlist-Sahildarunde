package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DirectorRepository {
    Map<String, Director> directorMap = new HashMap<>();
    Map<String, List<String>> directorMovieMap = new HashMap<>();
    public void addDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public Optional<Director> getDirectorByName(String name) {
        if(directorMap.containsKey(name)){
            return Optional.of(directorMap.get(name));
        }
        return Optional.empty();
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(directorMovieMap.containsKey(directorName)){
            List<String> movies = directorMovieMap.get(directorName);
            movies.add(movieName);
            directorMovieMap.put(directorName, movies);
        }else{
            directorMovieMap.put(directorName, List.of(movieName));
        }
    }

    public List<String> getMoviesByDirectorName(String director) {
        return directorMovieMap.get(director);
    }

    public void remove(String name) {
        directorMap.remove(name);
        directorMovieMap.remove(name);
    }

    public List<Director> getAll() {
        return new ArrayList<>(directorMap.values());
    }
}
