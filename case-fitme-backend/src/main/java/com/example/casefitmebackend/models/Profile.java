package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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

    @Column(name = "profile_weight", length = 10)
    private int weight;

    @Column(name = "profile_height", length = 10)
    private int height;

    @Column(name = "profile_medical_conditions", length = 50)
    private String medical_conditions;

    @Column(name = "profile_disabilities", length = 50)
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
