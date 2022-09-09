/*
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

    @Mapping(target="exercise", source="exercise.id")
    public abstract SetDto setToSetDTO(Set set);

    @Mapping(target = "exercise.id", source = "exercise")
    public abstract Set setDtoToSet(SetDto setDto);

    @Mapping(target="workouts", source="workouts", qualifiedByName = "workoutsToIds")
    public abstract java.util.Set<SetDto> setToSetDTO(java.util.Set<Set> set);

    @Mapping(target = "workouts", source = "workouts", qualifiedByName = "workoutIdsToWorkout")
    public abstract java.util.Set<Set> setDtoToSet(java.util.Set<SetDto> setDto);

    @Named("mapFromExercise")
    Integer mapFromExercise(Exercise exercise) {
        if (exercise == null) return null;
        return exercise.getId();
    }

    @Named("mapToExercise")
    Exercise mapToExercise(Integer id){
        if(id == null) return null;
        return exerciseService.findById(id);
    }

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
*/
