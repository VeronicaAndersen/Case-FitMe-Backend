package com.example.casefitmebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WorkoutNotFoundException extends RuntimeException{
    public WorkoutNotFoundException(int id) {super("No workout exists with id " + id);}
}
