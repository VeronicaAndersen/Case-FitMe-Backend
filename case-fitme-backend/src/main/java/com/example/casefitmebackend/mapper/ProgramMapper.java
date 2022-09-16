package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.*;
import com.example.casefitmebackend.models.dto.ProgramDto;
import com.example.casefitmebackend.services.profile.ProfileService;
import com.example.casefitmebackend.services.workout.WorkoutService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ProgramMapper {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private WorkoutService workoutService;

    @Mapping(target="workouts", source="workouts", qualifiedByName = "workoutsToIds")
    @Mapping(target="profiles", source="profiles", qualifiedByName = "profilesToIds")
    public abstract ProgramDto programToProgramDTO(Program program);

    public abstract Collection<ProgramDto> programsToProgramDTOs(Collection<Program> programs);

    @Mapping(target="workouts", source="workouts", qualifiedByName = "workoutIdsToWorkout")
    @Mapping(target="profiles", source="profiles", qualifiedByName = "profileIdsToProfile")
    public abstract Program programDtoToprogram(ProgramDto programDto);

    @Named("workoutIdsToWorkout")
    java.util.Set<Workout> mapIdsToWorkouts(java.util.Set<Integer> id) {
        if(id ==null)
            return null;
        return id.stream()
                .map(i -> workoutService.findById(i))
                .collect(Collectors.toSet());
    }
    @Named("profileIdsToProfile")
    java.util.Set<Profile> mapIdsToSets(java.util.Set<Integer> id) {
        if(id ==null)
            return null;
        return id.stream()
                .map(i -> profileService.findById(i))
                .collect(Collectors.toSet());
    }

    @Named("workoutsToIds")
    java.util.Set<Integer> mapWorkoutsToIds(java.util.Set<Workout> source) {
        if(source ==null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
    @Named("profilesToIds")
    java.util.Set<Integer> mapProfilesToIds(java.util.Set<Profile> source) {
        if(source ==null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
}
