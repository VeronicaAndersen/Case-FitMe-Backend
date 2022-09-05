package com.example.casefitmebackend.services.exercise;

import com.example.casefitmebackend.exceptions.ExerciseNotFoundException;
import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Fully functioning ServiceImpl. Use this as template
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {
    private ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise findById(Integer id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new ExerciseNotFoundException(id));
    }

    @Override
    public Collection<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise add(Exercise entity) {
        return exerciseRepository.save(entity);
    }

    @Override
    public Exercise update(Exercise entity) {
        return exerciseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        exerciseRepository.deleteById(id);
    }
}
