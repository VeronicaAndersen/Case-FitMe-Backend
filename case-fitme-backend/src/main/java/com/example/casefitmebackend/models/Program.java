package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Program model.
 */
@Entity
@Setter
@Getter
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private int id;

    @Column(name = "program_name")
    private String name;

    @Column(name = "program_category")
    private String category;

    @ManyToMany(mappedBy = "programs")
    private Set<Profile> profiles;

    @ManyToMany
    @JoinTable(name = "program_workout",
    joinColumns = {@JoinColumn (name = "program_id") },
            inverseJoinColumns = {@JoinColumn (name = "workout_id")})
    private Set<Workout> workouts;

}
