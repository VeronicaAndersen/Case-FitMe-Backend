package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.mapper.ProfileMapper;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@CrossOrigin(originPatterns = {"http://localhost:3000/", "https://case-mefit-frontend.herokuapp.com/"})
@RequestMapping(path = "api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    public ProfileController(ProfileService profileService, ProfileMapper profileMapper) {
        this.profileService = profileService;
        this.profileMapper = profileMapper;
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
        return ResponseEntity.ok(profileMapper.profileToProfileDto(profileService.findAll()));
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
        return ResponseEntity.ok(profileMapper.profileToProfileDto(profileService.findById(id)));
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
    public ResponseEntity add(@RequestBody ProfileDto profileDto) {
        var addedProfile = profileService.add(profileMapper.profileDtoToProfile(profileDto));
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
    public ResponseEntity<Profile> update(@RequestBody ProfileDto profileDto, @PathVariable int id) {
        if (profileDto.getId() != id)
            return ResponseEntity.badRequest().build();
        profileService.update(profileMapper.profileDtoToProfile(profileDto));
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
    @PreAuthorize("hasRole('app_user')")
    public ResponseEntity delete(@PathVariable int id) {
        profileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
