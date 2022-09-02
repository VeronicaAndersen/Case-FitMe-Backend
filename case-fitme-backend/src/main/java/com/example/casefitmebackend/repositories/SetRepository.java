package com.example.casefitmebackend.repositories;

import com.example.casefitmebackend.models.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetRepository extends JpaRepository<Set, Integer> {
}
