package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.models.Profile;
import com.example.casefitmebackend.models.dto.ProfileDto;
import com.example.casefitmebackend.services.profile.ProfileService;
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
@RequestMapping(path = "api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Operation(summary = "Get all profiles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProfileDto.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "No profiles exist",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(profileService.findAll());
    }

    @Operation(summary = "Get profile by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfileDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Profile with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(profileService.findById(id));
    }

    @Operation(summary = "Add profile")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201",
                    description = "Profile successfully added",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PostMapping
    public ResponseEntity add(@RequestBody Profile profile) {
        var addedProfile = profileService.add(profile);
        URI uri = URI.create("profile/" + addedProfile.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Update profile")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Profile successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Profile with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Profile> update(@RequestBody Profile profile, @PathVariable int id) {
        if (profile.getId() != id)
            return ResponseEntity.badRequest().build();
        profileService.update(profile);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete profile")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Profile successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Profile with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        profileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}