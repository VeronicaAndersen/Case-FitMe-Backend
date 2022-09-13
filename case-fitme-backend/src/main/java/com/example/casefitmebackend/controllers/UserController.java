
package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.mapper.UserMapper;
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
@CrossOrigin(originPatterns = {"http://localhost:3000"})
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
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
        return ResponseEntity.ok(userMapper.userToUserDto(userService.findAll()));
    }

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
        return ResponseEntity.ok(userMapper.userToUserDto(userService.findById(id)));
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
    public ResponseEntity add(@RequestBody UserDto userDto) {
        var addedUser = userService.add(userMapper.userDtoToUser(userDto));
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
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable int id) {
        if (userDto.getId() != id)
            return ResponseEntity.badRequest().build();
        userService.update(userMapper.userDtoToUser(userDto));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete user")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "User successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "User with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
