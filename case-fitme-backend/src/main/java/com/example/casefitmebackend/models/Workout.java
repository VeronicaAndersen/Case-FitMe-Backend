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

    @Column(name = "workout_name")
    private String name;

    @Column(name = "workout_type")
    private String type;

    @Column(name = "workout_complete")
    private String complete;


}

