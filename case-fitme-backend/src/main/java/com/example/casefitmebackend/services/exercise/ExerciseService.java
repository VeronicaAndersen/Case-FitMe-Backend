package com.example.casefitmebackend.services.exercise;

import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface ExerciseService extends CrudService<Exercise, Integer> {
}
