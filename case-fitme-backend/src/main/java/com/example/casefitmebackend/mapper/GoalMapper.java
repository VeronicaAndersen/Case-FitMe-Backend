//package com.example.casefitmebackend.mapper;
//
//import com.example.casefitmebackend.models.Goal;
//import com.example.casefitmebackend.models.Workout;
//import com.example.casefitmebackend.models.dto.GoalDto;
//import com.example.casefitmebackend.services.workout.WorkoutService;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Mapper(componentModel = "spring")
//public abstract class GoalMapper {
//
//    @Autowired
//    private WorkoutService workoutService;
//
//    @Mapping(target = "workouts", source = "workouts", qualifiedByName = "mapWorkoutsToIds")
//    public abstract GoalDto goalToGoalDto(Goal goal);
//
//    @Mapping(target = "workouts", source = "workouts", qualifiedByName = "mapWorkoutsFromDTO")
//    public abstract Goal goalDtoToGoal(GoalDto goalDto);
//
//    @Mapping(target = "goal", source = "goal")
//    public abstract Collection<GoalDto> goalToGoalDto(Collection<Goal> goals);
//
//    @Named("mapWorkoutsFromDTO")
//    java.util.Set<Workout> mapWorkoutFromDTO(Set<Integer> workoutIds){
//        if (workoutIds == null) return null;
//        return workoutIds.stream().map(i -> workoutService.findById(i)).collect(Collectors.toSet());
//    }
//
//    @Named("mapWorkoutsToIds")
//    Set<Integer> mapWorkoutsToIds(Set<Workout> workouts){
//        if (workouts == null) return null;
//        return workouts.stream().map(w -> w.getId()).collect(Collectors.toSet());
//    }
//}
