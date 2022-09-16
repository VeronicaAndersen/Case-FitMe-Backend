package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Goal model.
 */
@Entity
@Setter
@Getter
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int id;

    @Column(name = "goal_name")
    private String goalName;

    @Column(name = "goal_end_date", length = 50)
    private Date date;

    @Column(name = "goal_achieved", length = 50)
    private Boolean achieved;

    @ManyToMany
    @JoinTable(name = "goal_workout",
            joinColumns = {@JoinColumn (name = "goal_id") },
            inverseJoinColumns = {@JoinColumn (name = "workout_id")})
    private Set<Workout> workouts;
}
