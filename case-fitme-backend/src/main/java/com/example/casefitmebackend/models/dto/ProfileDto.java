package com.example.casefitmebackend.models.dto;

import lombok.Data;

@Data
public class ProfileDto {
    private int id;
    private String weight;
    private String height;
    private String medicalConditions;
    private String disabilities;
    private int userId;
}
