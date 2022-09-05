package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.mapper.GoalMapper;
import com.example.casefitmebackend.models.Goal;
import com.example.casefitmebackend.models.dto.GoalDto;
import com.example.casefitmebackend.services.goal.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/goal")
public class GoalController {

    private final GoalService goalService;
    private final GoalMapper goalMapper;

    public GoalController(GoalService goalService, GoalMapper goalMapper) {
        this.goalService = goalService;
        this.goalMapper = goalMapper;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(goalService.findAll());
    }

    @GetMapping
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(goalService.findById(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Goal goal) {
        var addedGoal = goalService.add(goal);
        URI uri = URI.create("goal/" + addedGoal.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> update(@RequestBody GoalDto goalDto) {
        goalService.update(goalMapper.goalDtoToGoal(goalDto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        goalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
