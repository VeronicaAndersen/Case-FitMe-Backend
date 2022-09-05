package com.example.casefitmebackend.services.workout;

import com.example.casefitmebackend.exceptions.ExerciseNotFoundException;
import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.models.Workout;
import com.example.casefitmebackend.repositories.ExerciseRepository;
import com.example.casefitmebackend.repositories.WorkoutRepository;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Fully functioning ServiceImpl. Use this as template
 */
@Service
public class WorkoutServiceImpl implements WorkoutService {
    private WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Workout findById(Integer id) {
        return workoutRepository.findById(id)
                .orElseThrow(() -> new ExerciseNotFoundException(id));
    }

    @Override
    public Collection<Workout> findAll() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout add(Workout entity) {
        return workoutRepository.save(entity);
    }

    @Override
    public Workout update(Workout entity) {
        return workoutRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        workoutRepository.deleteById(id);
    }
}
