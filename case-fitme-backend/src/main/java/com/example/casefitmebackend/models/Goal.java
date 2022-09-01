package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name = "goal_end_date")
    private String end_date;

    @Column(name = "goal_achieved")
    private String achieved;

}
