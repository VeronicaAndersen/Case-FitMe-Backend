package com.example.casefitmebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProgramNotFoundException extends RuntimeException{
    public ProgramNotFoundException(int id) {super("No program exists with id " + id);}
}
