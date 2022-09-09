package com.example.casefitmebackend.models.dto;

import lombok.Data;

import java.util.Set;

@Data
public class WorkoutDto {
    private int id;
    private String name;
    private String type;
    private boolean complete;
    private Set<Integer> sets;
}
