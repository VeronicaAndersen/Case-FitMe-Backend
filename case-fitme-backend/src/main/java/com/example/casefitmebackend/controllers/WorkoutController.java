package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.mapper.WorkoutMapper;
import com.example.casefitmebackend.models.Workout;
import com.example.casefitmebackend.models.dto.WorkoutDto;
import com.example.casefitmebackend.services.workout.WorkoutService;
import com.example.casefitmebackend.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@CrossOrigin(originPatterns = {"http://localhost:3000/", "https://mefit-frontend-case.herokuapp.com/"})
@RequestMapping(path = "api/v1/workout")
public class WorkoutController {

    private final WorkoutService workoutService;
    private final WorkoutMapper workoutMapper;

    public WorkoutController(WorkoutService workoutService, WorkoutMapper workoutMapper) {
        this.workoutService = workoutService;
        this.workoutMapper = workoutMapper;
    }

    @Operation(summary = "Get all workouts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = WorkoutDto.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "No workouts exist",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(workoutMapper.workoutsToWorkoutDTOs(workoutService.findAll()));
    }

    @Operation(summary = "Get workout by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = WorkoutDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Workout with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(workoutMapper.workoutToWorkoutDTO(workoutService.findById(id)));
    }

    @Operation(summary = "Add workout")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201",
                    description = "Workout successfully added",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PostMapping
    @PreAuthorize("hasRole('app_contributor')")
    public ResponseEntity add(@RequestBody WorkoutDto workoutDto) {
        var addedWorkout = workoutService.add(workoutMapper.workoutDTOToWorkout(workoutDto));
        URI uri = URI.create("workout/" + addedWorkout.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Update workout")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Workout successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Workout with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('app_contributor')")
    public ResponseEntity<Workout> update(@RequestBody WorkoutDto workoutDto, @PathVariable int id) {
        if (workoutDto.getId() != id)
            return ResponseEntity.badRequest().build();
        workoutService.update(workoutMapper.workoutDTOToWorkout(workoutDto));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete workout")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Workout successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Workout with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('app_contributor')")
    public ResponseEntity delete(@PathVariable int id) {
        workoutService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
