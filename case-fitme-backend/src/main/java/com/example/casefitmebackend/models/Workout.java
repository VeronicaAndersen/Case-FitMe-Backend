package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Workout model.
 */
@Entity
@Setter
@Getter
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private int id;

    @Column(name = "workout_name", length = 50)
    private String name;

    @Column(name = "workout_type", length = 50)
    private String type;

    @Column(name = "workout_complete", length = 5)
    private Boolean complete;

    @ManyToMany(mappedBy = "workouts")
    private Set<Program> programs;

    @ManyToMany
    @JoinColumn(name = "set_id")
    private Set<com.example.casefitmebackend.models.Set> sets;

    @ManyToMany(mappedBy = "workouts")
    private Set<Goal> goals;
}
