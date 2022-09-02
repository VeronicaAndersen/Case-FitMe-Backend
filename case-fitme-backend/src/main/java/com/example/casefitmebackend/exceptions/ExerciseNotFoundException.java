package com.example.casefitmebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExerciseNotFoundException extends RuntimeException{
    public ExerciseNotFoundException(int id) {super("No exercise exists with id " + id);}
}
