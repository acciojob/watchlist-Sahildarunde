package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public Boolean addMovie(Movie movie) throws MovieAlreadyExistsException{
        Optional<Movie> movieOpt = movieRepository.getById(movie.getMovieId()); // movieId already exists
        if(movieOpt.isPresent()) {
            throw new MovieAlreadyExistsException(movie.getMovieId());
        }
        return movieRepository.add(movie);
    }
}
