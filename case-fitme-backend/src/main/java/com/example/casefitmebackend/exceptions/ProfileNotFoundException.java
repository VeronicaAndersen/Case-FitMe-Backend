package com.example.casefitmebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProfileNotFoundException extends RuntimeException{
    public ProfileNotFoundException(int id) {super("No profile exists with id " + id);}
}
