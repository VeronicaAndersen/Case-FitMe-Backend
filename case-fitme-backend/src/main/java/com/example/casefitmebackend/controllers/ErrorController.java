package com.example.casefitmebackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = {"http://localhost:3000"})
@RequestMapping(path = "/error")
public class ErrorController {
    @GetMapping
    public ResponseEntity getError() {
        return ResponseEntity.notFound();
    }

}
