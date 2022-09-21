package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.mapper.GoalMapper;
import com.example.casefitmebackend.models.Goal;
import com.example.casefitmebackend.models.dto.GoalDto;
import com.example.casefitmebackend.services.goal.GoalService;
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
@CrossOrigin(originPatterns = {"http://localhost:3000/", "https://mefit-frontend-case.herokuapp.com/"})
@RequestMapping(path = "api/v1/goal")
public class GoalController {

    private final GoalService goalService;
    private final GoalMapper goalMapper;

    public GoalController(GoalService goalService, GoalMapper goalMapper) {
        this.goalService = goalService;
        this.goalMapper = goalMapper;
    }

    @Operation(summary = "Get all goals")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = GoalDto.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "No goals exist",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(goalMapper.goalToGoalDto(goalService.findAll()));
    }

    @Operation(summary = "Get goal by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoalDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Goal with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(goalMapper.goalToGoalDto(goalService.findById(id)));
    }

    @Operation(summary = "Add goal")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201",
                    description = "Goal successfully added",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PostMapping
    public ResponseEntity add(@RequestBody GoalDto goalDto) {
        var addedGoal = goalService.add(goalMapper.goalDtoToGoal(goalDto));
        URI uri = URI.create("goal/" + addedGoal.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Update goal")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Goal successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Goal with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Goal> update(@RequestBody GoalDto goalDto, @PathVariable int id) {
        if (goalDto.getId() != id)
            return ResponseEntity.badRequest().build();
        goalService.update(goalMapper.goalDtoToGoal(goalDto));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete goal")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Goal successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Goal with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        goalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
