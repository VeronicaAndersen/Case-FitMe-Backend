package com.example.casefitmebackend.models.dto;

import com.example.casefitmebackend.models.Goal;
import com.example.casefitmebackend.models.Program;
import lombok.Data;

import java.util.Set;

@Data
public class WorkoutDto {
    private int id;
    private String name;
    private String type;
    private Boolean complete;
   // private Set<Integer> programs;
    private Set<Integer> sets;
   // private Set<Integer> goals;

}
