package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody Movie movie) {
        try {
            Boolean added = movieService.addMovie(movie);
            return new ResponseEntity("Added successfully", HttpStatus.CREATED); //200
        } catch(MovieAlreadyExistsException ex) {
            return new ResponseEntity("unable to add book as it already exists", HttpStatus.valueOf(400));
        }
    }
}
