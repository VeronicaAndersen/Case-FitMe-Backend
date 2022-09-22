package com.example.casefitmebackend.models.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ExerciseDto {
    private int id;
    private String name;
    private String description;
    private String targetMuscleGroup;
    private String image;
    private String videoLink;
    private Set<Integer> set;
}
