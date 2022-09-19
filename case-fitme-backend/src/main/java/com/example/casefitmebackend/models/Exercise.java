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

    @Column(name = "exercise_name", length = 50)
    private String name;

    @Column(name = "exercise_description", length = 300)
    private String description;

    @Column(name = "exercise_target_muscle_group", length = 300)
    private String targetMuscleGroup;

    @Column(name = "exercise_image", length = 300)
    private String image;

    @Column(name = "exercise_video_link", length = 300)
    private String videoLink;

    @OneToMany (mappedBy = "exercise")
    private java.util.Set<Set> set;
}
