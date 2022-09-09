package com.example.casefitmebackend.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private int id;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isContributor;
    private boolean isAdmin;
    private Integer profile;
}
