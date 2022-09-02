package com.example.casefitmebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GoalNotFoundException extends RuntimeException{
    public GoalNotFoundException(int id) {super("No goal exists with id " + id);}
}
