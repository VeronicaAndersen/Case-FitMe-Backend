package com.example.casefitmebackend.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
public class SetDto {
    private int id;
    private Integer exerciseRepetition;
    private Integer exercise;
    private Set<Integer> workouts;
}
