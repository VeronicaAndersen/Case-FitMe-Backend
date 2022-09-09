//package com.example.casefitmebackend.mapper;
//
//import com.example.casefitmebackend.models.Workout;
//import com.example.casefitmebackend.models.dto.WorkoutDto;
//import com.example.casefitmebackend.services.set.SetService;
//import com.example.casefitmebackend.services.workout.WorkoutService;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Mapper(componentModel = "spring")
//public abstract class WorkoutMapper {
//
//    @Autowired
//    SetService setService;
//
////    @Mapping(source = "sets", target = "sets", qualifiedByName = "workoutsToIds")
////    public abstract WorkoutDto workoutToWorkoutDTO(Workout workout);
//
//    @Mapping(source = "sets", target = "sets.id", qualifiedByName = "setsToIds")
//    public abstract java.util.Set<WorkoutDto> workoutToWorkoutDTO(Set<Workout> workouts);
//
////    @Mapping(source = "sets", target = "sets", qualifiedByName = "workoutIdsToWorkout")
////    public abstract Workout workoutToWorkoutDTO(WorkoutDto workoutDto);
//
//      @Mapping(source = "sets", target = "sets", qualifiedByName = "setIdsToSet")
//      public abstract java.util.Set<Workout> workoutDTOToWorkout(Set<WorkoutDto> workoutDtos);
//
//    @Named("setIdsToSet")
//        java.util.Set<com.example.casefitmebackend.models.Set> mapIdsToSets(java.util.Set<Integer> id) {
//        return id.stream()
//                .map(i -> setService.findById(i))
//                .collect(Collectors.toSet());
//    }
//
//    @Named("setsToIds")
//    java.util.Set<Integer> mapSetsToIds(java.util.Set<com.example.casefitmebackend.models.Set> source) {
//        if(source ==null)
//            return null;
//        return source.stream()
//                .map(s -> s.getId()).collect(Collectors.toSet());
//    }
//}
