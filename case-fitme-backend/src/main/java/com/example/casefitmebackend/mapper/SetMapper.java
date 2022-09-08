package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.models.Set;
import com.example.casefitmebackend.models.dto.SetDto;
import com.example.casefitmebackend.services.exercise.ExerciseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SetMapper {

    @Autowired
    private ExerciseService exerciseService;

    //@Mapping(target="exercises", source="exercise.id")
    @Mapping(target="exercise", source="exercise.id")
    public abstract SetDto setToSetDTO(Set set);

   // @Mapping(target = "exercise.id", source = "exercises")
    @Mapping(target = "exercise.id", source = "exercise")
    public abstract Set setDtoToSet(SetDto setDto);

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
}
