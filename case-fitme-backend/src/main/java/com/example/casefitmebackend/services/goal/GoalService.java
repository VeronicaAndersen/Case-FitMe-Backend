package com.example.casefitmebackend.services.goal;

import com.example.casefitmebackend.models.Goal;
import com.example.casefitmebackend.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface GoalService extends CrudService<Goal, Integer> {
}
