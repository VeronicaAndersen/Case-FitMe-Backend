package com.example.casefitmebackend.controllers;

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
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
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
        return ResponseEntity.ok(workoutService.findAll());
    }

    //TODO: OBSERVE, Should schemas also be present within the other methods responses? If so, add.

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
        return ResponseEntity.ok(workoutService.findById(id));
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
    public ResponseEntity add(@RequestBody Workout workout) {
        var addedWorkout = workoutService.add(workout);
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
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Workout> update(@RequestBody Workout workout, @PathVariable int id) {
        if (workout.getId() != id)
            return ResponseEntity.badRequest().build();
        workoutService.update(workout);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete workout")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Workout successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Workout with given ID does not exist",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        workoutService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
