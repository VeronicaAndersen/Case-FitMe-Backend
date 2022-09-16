package com.example.casefitmebackend.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private String uid;
    private String firstName;
    private String lastName;
    private Boolean isContributor;
    private Boolean isAdmin;
    private Integer profile;
}
