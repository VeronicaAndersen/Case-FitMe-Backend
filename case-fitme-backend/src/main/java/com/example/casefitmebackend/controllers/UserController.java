
package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.models.User;
import com.example.casefitmebackend.models.dto.UserDto;
import com.example.casefitmebackend.services.user.UserService;
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
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "No users exist",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    //TODO: OBSERVE, Should schemas also be present within the other methods responses? If so, add.

    @Operation(summary = "Get user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "User with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Operation(summary = "Add user")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201",
                    description = "User successfully added",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PostMapping
    public ResponseEntity add(@RequestBody User user) {
        var addedUser = userService.add(user);
        URI uri = URI.create("user/" + addedUser.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Update user")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "User successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "User with given ID does not exist",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable int id) {
        if (user.getId() != id)
            return ResponseEntity.badRequest().build();
        userService.update(user);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete user")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "User successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "User with given ID does not exist",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
