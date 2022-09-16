package com.example.casefitmebackend.exceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException() {super("User already exist");}
}
