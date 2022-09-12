package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.models.Set;
import com.example.casefitmebackend.models.Workout;
import com.example.casefitmebackend.models.dto.ExerciseDto;
import com.example.casefitmebackend.services.set.SetService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ExerciseMapper {
    @Autowired
    private SetService setService;

    @Mapping(target="set", source="set", qualifiedByName = "setsToIds")
    public abstract ExerciseDto exerciseToExerciseDTO(Exercise exercise);

    @Mapping(target = "set", source = "set", qualifiedByName = "setIdsToSet")
    public abstract Exercise exerciseDtoToExercise(ExerciseDto exerciseDto);

    @Named("setIdsToSet")
    java.util.Set<Set> mapIdsToSets(java.util.Set<Integer> id) {
        return id.stream()
                .map(i -> setService.findById(i))
                .collect(Collectors.toSet());
    }

    @Named("setsToIds")
    java.util.Set<Integer> mapSetsToIds(java.util.Set<Set> source) {
        if(source ==null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
}
