package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.models.Workout;
import com.example.casefitmebackend.models.dto.ExerciseDto;
import com.example.casefitmebackend.models.dto.WorkoutDto;
import com.example.casefitmebackend.services.set.SetService;
import com.example.casefitmebackend.services.workout.WorkoutService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class WorkoutMapper {

    @Autowired
    SetService setService;

    @Mapping(source = "sets", target = "sets", qualifiedByName = "setsToIds")
    public abstract WorkoutDto workoutToWorkoutDTO(Workout workouts);

    public abstract Collection<WorkoutDto> workoutsToWorkoutDTOs(Collection<Workout> workouts);

    @Mapping(source = "sets", target = "sets", qualifiedByName = "setIdsToSet")
      public abstract Workout workoutDTOToWorkout(WorkoutDto workoutDtos);

    @Named("setIdsToSet")
        java.util.Set<com.example.casefitmebackend.models.Set> mapIdsToSets(java.util.Set<Integer> id) {
        if(id ==null)
            return null;
        return id.stream()
                .map(i -> setService.findById(i))
                .collect(Collectors.toSet());
    }

    @Named("setsToIds")
    java.util.Set<Integer> mapSetsToIds(java.util.Set<com.example.casefitmebackend.models.Set> source) {
        if(source ==null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
}
