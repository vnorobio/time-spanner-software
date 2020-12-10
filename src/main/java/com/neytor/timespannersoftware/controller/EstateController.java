package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.service.EstateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/configuration")
public class EstateController {

    public static final String NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID = "Not territorial division found with id: ";
    private final EstateService service;

    @Autowired
    public EstateController(EstateService service) {
        this.service = service;
    }

    @Operation(summary = "to list all estates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/estates", produces = "application/json")
    public ResponseEntity<List<Estate>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Operation(summary = "to find a estate by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved estate",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/estates/by-id/{id}", produces = "application/json")
    public ResponseEntity<Estate> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok()
                .body(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + id)));
    }

    @Operation(summary = "to list estates by description")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/estates/by-description/{description}", produces = "application/json")
    public ResponseEntity<List<Estate>>findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(service.findByDescriptionContaining(description));
    }

    @Operation(summary = "to register a new estate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successfully created estate",
                    content = {@Content(mediaType = "application/json")}),
    })
    @PostMapping(path = "/estates", produces = "application/json")
    public ResponseEntity<Estate> create(@RequestBody Estate dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "to update a estate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202",
                    description = "Changes where accepted",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to update is not available",
                    content = @Content)
    })
    @PutMapping(path = "/estates", produces = "application/json")
    public ResponseEntity<Estate> update(@RequestBody Estate updateDto) {
         if (!service.existsById( updateDto.getId() )){
            throw new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + updateDto.getId());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(updateDto));
    }

    @Operation(summary = "to delete a estate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Not content",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to delete is not available",
                    content = @Content)
    })
    @DeleteMapping(path = "/estates/by-id/{id}", produces = "application/json")
    public ResponseEntity<Estate> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
