package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * User model.
 */
@Entity
@Table(name = "app_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_password", length = 50)
    private String password;

    @Column(name = "user_first_name", length = 50)
    private String first_name;

    @Column(name = "user_last_name", length = 50)
    private String last_name;

    @Column(name = "user_is_contributor", length = 5, nullable = false)
    private boolean is_contributor;

    @Column(name = "user_is_admin", length = 5, nullable = false)
    private boolean is_admin;

    @OneToOne(mappedBy = "user")
    private Profile profile;


}
