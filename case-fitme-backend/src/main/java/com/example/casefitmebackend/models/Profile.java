package com.example.casefitmebackend.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Profile model.
 */
@Entity
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int id;

    @Column(name = "profile_weight")
    private String weight;

    @Column(name = "profile_height")
    private String height;

    @Column(name = "profile_medical_conditions")
    private String medical_conditions;

    @Column(name = "profile_disabilities")
    private String disabilities;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "profile_program",
    joinColumns = {@JoinColumn (name = "profile_id")},
            inverseJoinColumns = {@JoinColumn (name = "program_id")})
    private Set<Program> programs;

}
