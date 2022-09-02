package com.example.casefitmebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SetNotFoundException extends RuntimeException{
    public SetNotFoundException(int id) {super("No set exists with id " + id);}
}
