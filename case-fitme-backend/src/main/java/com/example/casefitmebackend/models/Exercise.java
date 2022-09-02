package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Exercise model.
 */
@Entity
@Setter
@Getter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private int id;

    @Column(name = "exercise_name")
    private String name;

    @Column(name = "goal_description")
    private String description;

    @Column(name = "goal_target_muscle_group")
    private String target_muscle_group;

    @Column(name = "goal_image")
    private String image;

    @Column(name = "goal_video_link")
    private String video_link;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Set sets;
}
