package com.driver;

public class MovieAlreadyExistsException extends RuntimeException{
    public MovieAlreadyExistsException(int id) {
        super("Movie for id: " + id + " already exists in database");
    }
}
