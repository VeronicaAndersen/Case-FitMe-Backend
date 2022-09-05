package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.models.Set;
import com.example.casefitmebackend.models.dto.ExerciseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ExerciseMapper {

    @Mapping(target = "sets", source = "sets", qualifiedByName = "mapSetToId")
    public abstract ExerciseDto exerciseToExerciseDto(Exercise exercise);

    @Mapping(target = "exercise", source = "exercise", qualifiedByName = "mapSetToExercises")
    public abstract Exercise exerciseDtoToExercise(ExerciseDto exerciseDto);

    @Mapping(target = "exercise", source = "exercise")
    public abstract Collection<ExerciseDto> exerciseToExerciseDto(Collection<Exercise> exercises);

    @Named("mapSetToId")
    Integer mapSetToSetId(Set set){
        return set.getId();
    }

    /*@Named("mapSetToExercises")
    Set<Set>mapSetToExercises(Set<Integer> setIds) {

    }*/
}
