package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * User model.
 */
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_first_name")
    private String first_name;

    @Column(name = "user_last_name")
    private String last_name;

    @Column(name = "user_is_contributor")
    private String is_contributor;

    @Column(name = "user_is_admin")
    private String is_admin;

/*    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;*/
}
