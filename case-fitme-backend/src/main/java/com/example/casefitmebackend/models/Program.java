package com.example.casefitmebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Program model.
 */
@Entity
@Setter
@Getter
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private int id;

    @Column(name = "program_name")
    private String name;

    @Column(name = "program_category")
    private String category;

/*    @OneToMany(mappedBy = "program")
    private Set<Profile> profiles;*/
}
