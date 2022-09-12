package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.models.Set;
import com.example.casefitmebackend.models.Workout;
import com.example.casefitmebackend.models.dto.SetDto;
import com.example.casefitmebackend.services.exercise.ExerciseService;
import com.example.casefitmebackend.services.set.SetService;
import com.example.casefitmebackend.services.workout.WorkoutService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class SetMapper {

    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private WorkoutService workoutService;

    @Mapping(target="workouts", source="workouts", qualifiedByName = "workoutsToIds")
    @Mapping(target="exercise", source="exercise.id")
    public abstract SetDto setToSetDTO(Set set);

    @Mapping(target = "workouts", source = "workouts", qualifiedByName = "workoutIdsToWorkout")
    @Mapping(target = "exercise.id", source = "exercise")
    public abstract Set setDtoToSet(SetDto setDto);

    @Named("workoutIdsToWorkout")
    java.util.Set<Workout> mapIdsToWorkouts(java.util.Set<Integer> id) {
        return id.stream()
                .map(i -> workoutService.findById(i))
                .collect(Collectors.toSet());
    }

    @Named("workoutsToIds")
    java.util.Set<Integer> mapWorkoutsToIds(java.util.Set<Workout> source) {
        if(source ==null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
}
