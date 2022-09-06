package com.example.casefitmebackend.services.goal;

import com.example.casefitmebackend.exceptions.GoalNotFoundException;
import com.example.casefitmebackend.models.Goal;
import com.example.casefitmebackend.repositories.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Fully functioning ServiceImpl. Use this as template
 */
@Service
public class GoalServiceImpl implements GoalService {
    private GoalRepository goalRepository;

    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public Goal findById(Integer id) {
        return goalRepository.findById(id)
                .orElseThrow(() -> new GoalNotFoundException(id));
    }

    @Override
    public Collection<Goal> findAll() {
        return goalRepository.findAll();
    }

    @Override
    public Goal add(Goal entity) {
        return goalRepository.save(entity);
    }

    @Override
    public Goal update(Goal entity) {
        return goalRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        goalRepository.deleteById(id);
    }
}
