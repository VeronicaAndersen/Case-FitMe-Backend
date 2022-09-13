package com.example.casefitmebackend.models.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ProgramDto {
    private int id;
    private String name;
    private String category;
    private Set<Integer> workouts;
    private Set<Integer> profiles;
}
