package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    DirectorRepository directorRepository;

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        directorRepository.addDirector(director);
    }

    public Movie getMovieByName(String movieName) {
        Optional<Movie> movie = movieRepository.getMovieByName(movieName);
        if(movie.isPresent()){
            return movie.get();
        }
        return new Movie();
    }

    public Director getDirectorByName(String name) {
        Optional<Director> director = directorRepository.getDirectorByName(name);
        if(director.isPresent()){
            return director.get();
        }
        return new Director();
    }

    public void addMovieToDirector(String movieName, String directorName) {
        Optional<Movie> movie = movieRepository.getMovieByName(movieName);
        Optional<Director> director = directorRepository.getDirectorByName(directorName);
        if(movie.isPresent() && director.isPresent()) {
            directorRepository.addMovieDirectorPair(movieName, directorName);
        }
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> movies = directorRepository.getMoviesByDirectorName(director);
        return movies;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public void deleteDirectorAndMovies(String name) {
        List<String> movies = directorRepository.getMoviesByDirectorName(name);
        directorRepository.remove(name);
        for(String movie : movies){
            movieRepository.remove(movie);
        }
    }

    public void deleteAllDirectorAndMovies() {
        List<Director> directors = directorRepository.getAll();
        for(Director director : directors){
            List<String> movieList = getMoviesByDirectorName(director.getName());
            for(String movie : movieList){
                movieRepository.remove(movie);
            }
        }
    }
}
