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
    private Integer exerciseRepetition;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToMany(mappedBy = "sets")
    private java.util.Set<Workout> workouts;
}