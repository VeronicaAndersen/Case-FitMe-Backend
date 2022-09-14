package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.mapper.ExerciseMapper;
import com.example.casefitmebackend.models.Exercise;
import com.example.casefitmebackend.models.dto.ExerciseDto;
import com.example.casefitmebackend.services.exercise.ExerciseService;
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
@CrossOrigin(originPatterns = {"http://localhost:3000"})
@RequestMapping(path = "api/v1/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final ExerciseMapper exerciseMapper;

    public ExerciseController(ExerciseService exerciseService, ExerciseMapper exerciseMapper) {
        this.exerciseService = exerciseService;
        this.exerciseMapper = exerciseMapper;
    }

    @Operation(summary = "Get all exercises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ExerciseDto.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "No exercises exist",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(exerciseMapper.exercisesToExerciseDTOs(exerciseService.findAll()));
    }

    @Operation(summary = "Get exercise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExerciseDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Exercise with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(exerciseMapper.exerciseToExerciseDTO(exerciseService.findById(id)));
    }

    @Operation(summary = "Add exercise")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201",
                    description = "Exercise successfully added",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PostMapping
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity add(@RequestBody ExerciseDto exerciseDto) {
        var addedExercise = exerciseService.add(exerciseMapper.exerciseDtoToExercise(exerciseDto));
        URI uri = URI.create("exercise/" + addedExercise.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Update exercise")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Exercise successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Exercise with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PutMapping("/{id}")
    @PreAuthorize("hasRole(Contributor)")
    public ResponseEntity<Exercise> update(@RequestBody ExerciseDto exerciseDto, @PathVariable int id) {
        if (exerciseDto.getId() != id)
            return ResponseEntity.badRequest().build();
        exerciseService.update(exerciseMapper.exerciseDtoToExercise(exerciseDto));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete exercise")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Exercise successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Exercise with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole(Contributor)")
    public ResponseEntity delete(@PathVariable int id) {
        exerciseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
