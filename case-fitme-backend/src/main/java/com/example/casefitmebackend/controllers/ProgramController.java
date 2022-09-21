package com.example.casefitmebackend.controllers;

import com.example.casefitmebackend.mapper.ProgramMapper;
import com.example.casefitmebackend.models.Program;
import com.example.casefitmebackend.models.dto.ProgramDto;
import com.example.casefitmebackend.services.program.ProgramService;
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
@RequestMapping(path = "api/v1/program")
public class ProgramController {

    private final ProgramService programService;
    private final ProgramMapper programMapper;

    public ProgramController(ProgramService programService, ProgramMapper programMapper) {
        this.programService = programService;
        this.programMapper = programMapper;
    }

    @Operation(summary = "Get all programs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProgramDto.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "No programs exist",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(programMapper.programsToProgramDTOs(programService.findAll()));
    }

    @Operation(summary = "Get program by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProgramDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Program with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(programMapper.programToProgramDTO(programService.findById(id)));
    }

    @Operation(summary = "Add program")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201",
                    description = "Program successfully added",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PostMapping
    public ResponseEntity add(@RequestBody ProgramDto programDto) {
        var addedProgram = programService.add(programMapper.programDtoToprogram(programDto));
        URI uri = URI.create("program/" + addedProgram.getId());
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Update program")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Program successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Program with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Program> update(@RequestBody ProgramDto programDto, @PathVariable int id) {
        if (programDto.getId() != id)
            return ResponseEntity.badRequest().build();
        programService.update(programMapper.programDtoToprogram(programDto));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete program")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Program successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Program with given ID does not exist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        programService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
