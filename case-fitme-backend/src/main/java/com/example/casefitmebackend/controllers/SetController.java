package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.models.Set;
import com.example.casefitmebackend.models.dto.SetDto;
import com.example.casefitmebackend.services.set.SetService;
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
@RequestMapping(path = "api/v1/set")
public class SetController {

    private final SetService setService;

    public SetController(SetService setService) {
        this.setService = setService;
    }

    @Operation(summary = "Get all sets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = SetDto.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "No sets exist",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(setService.findAll());
    }

    @Operation(summary = "Get set by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SetDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Set with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(setService.findById(id));
    }

    @Operation(summary = "Add set")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201",
                    description = "Set successfully added",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PostMapping
    public ResponseEntity add(@RequestBody Set set) {
        var addedSet = setService.add(set);
        URI uri = URI.create("set/" + addedSet.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Update set")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Set successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Set with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Set> update(@RequestBody Set set, @PathVariable int id) {
        if (set.getId() != id)
            return ResponseEntity.badRequest().build();
        setService.update(set);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete set")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Set successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Set with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        setService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
