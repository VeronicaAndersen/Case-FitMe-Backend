package com.example.casefitmebackend.models.dto;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class GoalDto {
    private int id;
    private String goalName;
    private Date date;
    private boolean achieved;
    private Set<Integer> workouts;
}
