package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/configuration")
public class CityController {

    public static final String NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID = "Not territorial division found with id: ";
    private final CityService service;

    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    @Operation(summary = "to list all cities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/cities", produces = "application/json")
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Operation(summary = "to find a city by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved city",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/cities/by-id/{id}", produces = "application/json")
    public ResponseEntity<City> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok()
                .body(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + id)));
    }

    @Operation(summary = "to list cities by description")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/cities/by-description/{description}", produces = "application/json")
    public ResponseEntity<List<City>>findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(service.findByDescriptionContaining(description));
    }

    @Operation(summary = "to register a new city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successfully created city",
                    content = {@Content(mediaType = "application/json")}),
    })
    @PostMapping(path = "/cities", produces = "application/json")
    public ResponseEntity<City> create(@RequestBody City dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "to update a city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202",
                    description = "Changes where accepted",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to update is not available",
                    content = @Content)
    })
    @PutMapping(path = "/cities", produces = "application/json")
    public ResponseEntity<City> update(@RequestBody City updateDto) {
         if (!service.existsById( updateDto.getId() )){
            throw new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + updateDto.getId());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(updateDto));
    }

    @Operation(summary = "to delete a city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Not content",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to delete is not available",
                    content = @Content)
    })
    @DeleteMapping(path = "/cities/by-id/{id}", produces = "application/json")
    public ResponseEntity<City> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
