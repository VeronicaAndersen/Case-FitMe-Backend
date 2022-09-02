package com.example.casefitmebackend.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GoalDto {
    private int id;
    private Date date;
    private boolean achieved;
}
