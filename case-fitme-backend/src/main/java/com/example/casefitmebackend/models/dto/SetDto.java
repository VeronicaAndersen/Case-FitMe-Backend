package com.example.casefitmebackend.models.dto;

import lombok.Data;

import java.util.Set;

@Data
public class SetDto {
    private int id;
    private String exerciseRepetition;
    private Integer exercise;
    private Set<Integer> workouts;
}
