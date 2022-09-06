package com.example.casefitmebackend.services.workout;

import com.example.casefitmebackend.models.Workout;
import com.example.casefitmebackend.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface WorkoutService extends CrudService<Workout, Integer> {
}
