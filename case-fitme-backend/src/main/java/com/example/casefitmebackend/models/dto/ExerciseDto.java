package com.example.casefitmebackend.models.dto;

import com.example.casefitmebackend.models.Set;
import lombok.Data;

import java.util.Date;

@Data
public class ExerciseDto {
    private int id;
    private String name;
    private String description;
    private String targetMuscleGroup;
    private String image;
    private String videoLink;
    private boolean achieved;
    private Integer sets;
}
