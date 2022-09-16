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
    @Column(name = "user_id")
    private String uid;

    @Column(name = "user_first_name", length = 50)
    private String firstName;

    @Column(name = "user_last_name", length = 50)
    private String lastName;

    @Column(name = "user_is_contributor", length = 5)
    private boolean isContributor;

    @Column(name = "user_is_admin", length = 5)
    private boolean isAdmin;

    @OneToOne(mappedBy = "user")
    private Profile profile;
}
