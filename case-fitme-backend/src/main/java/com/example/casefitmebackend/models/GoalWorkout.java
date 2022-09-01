package com.example.casefitmebackend.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Goal Workout model.
 */
@Entity
@Setter
@Getter
public class GoalWorkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_workout_id")
    private int id;

    @Column(name = "goal_workout_end_date")
    private String end_date;


}