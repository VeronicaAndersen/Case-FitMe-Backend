package com.example.casefitmebackend.models.dto;

import lombok.Data;

@Data
public class WorkoutDto {
    private int id;
    private String name;
    private String type;
    private boolean complete;
}
