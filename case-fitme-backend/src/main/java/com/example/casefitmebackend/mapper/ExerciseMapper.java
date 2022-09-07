package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.models.Set;
import com.example.casefitmebackend.models.dto.ExerciseDto;
import com.example.casefitmebackend.services.set.SetService;
import com.example.casefitmebackend.services.workout.WorkoutService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ExerciseMapper {
    @Autowired
    private SetService setService;

    @Mapping(target="sets", source="sets.id")
    public abstract ExerciseDto exerToExerDTO(Exercise exercise);

    @Mapping(target = "sets", source = "sets.id")
    public abstract ExerciseDto exerciseToExerciseDto(Exercise exercise);

    @Mapping(target = "exercise", source = "exercise.id")
    public abstract Exercise exerciseDtoToExercise(ExerciseDto exerciseDto);

//    @Mapping(target = "exercise", source = "exercise")
//    public abstract Collection<ExerciseDto> exerciseToExerciseDto(Collection<Exercise> exercises);



    /*@Named("mapSetToExercises")
    Set<Set>mapSetToExercises(Set<Integer> setIds) {

    }*/
}
