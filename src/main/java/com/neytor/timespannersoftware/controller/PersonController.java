package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.Person;
import com.neytor.timespannersoftware.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/configuration")
public class PersonController {

    public static final String NOT_PERSON_FOUND_WITH_ID = "Not Person found with id: ";

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @Operation(summary = "to list all persons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/persons", produces = "application/json")
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().collect(Collectors.toList()));
    }

    @Operation(summary = "to find a person by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved person",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/persons/by-id/{id}", produces = "application/json")
    public ResponseEntity<Person> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok()
                .body(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_PERSON_FOUND_WITH_ID + id)));
    }

    @Operation(summary = "to list persons by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/persons/by-name/{name}", produces = "application/json")
    public ResponseEntity<List<Person>> findByLogin(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok().body(service.findByFullNameContaining(name).stream().collect(Collectors.toList()));
    }

    @Operation(summary = "to register a new person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successfully created country",
                    content = {@Content(mediaType = "application/json")}),
    })
    @PostMapping(path = "/persons", produces = "application/json")
    public ResponseEntity<Person> create(@RequestBody Person dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "to update a person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202",
                    description = "Changes where accepted",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to update is not available",
                    content = @Content)
    })
    @PutMapping(path = "/persons", produces = "application/json")
    public ResponseEntity<Person> update(@RequestBody Person updateDto) {
        if (!service.existsById(updateDto.getId())) {
            throw new EntityNotFoundException(NOT_PERSON_FOUND_WITH_ID + updateDto.getId());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(updateDto));
    }

    @Operation(summary = "to delete a person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Not content",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to delete is not available",
                    content = @Content)
    })
    @DeleteMapping(path = "/persons/by-id/{id}", produces = "application/json")
    public ResponseEntity<Person> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_PERSON_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
