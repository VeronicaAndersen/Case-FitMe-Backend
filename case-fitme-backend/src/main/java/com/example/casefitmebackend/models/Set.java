package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Set model.
 */
@Entity
@Setter
@Getter
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "set_id")
    private int id;

    @Column(name = "set_exercise_repetition", length = 10)
    private int exerciseRepetition;

    @ManyToMany
    @JoinColumn(name = "workout_id")
    private java.util.Set<Workout> workouts;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
}