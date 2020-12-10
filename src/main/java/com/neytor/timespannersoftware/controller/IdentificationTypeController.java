package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.IdentificationType;
import com.neytor.timespannersoftware.service.IdentificationTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/configuration")
public class IdentificationTypeController {

    public static final String NOT_TYPE_FOUND_WITH_ID = "Not identification type found with id: ";

    private final IdentificationTypeService service;

    @Autowired
    public IdentificationTypeController(IdentificationTypeService service) {
        this.service = service;
    }

    @Operation(summary = "to list all identification types")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/identification-types", produces = "application/json")
    public ResponseEntity<List<IdentificationType>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Operation(summary = "to find a identification type by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved identification type",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/identification-types/by-id/{id}", produces = "application/json")
    public ResponseEntity<IdentificationType> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_TYPE_FOUND_WITH_ID + id)));
    }

    @Operation(summary = "to find a identification type by code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved identification type",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/identification-types/by-code/{code}", produces = "application/json")
    public ResponseEntity<IdentificationType> findByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok()
                .body(service.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Not identification type found with code: " + code)));
    }

    @Operation(summary = "to find a identification type by shortened form")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved identification type",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/identification-types/by-short/{shortenedForm}", produces = "application/json")
    public ResponseEntity<IdentificationType> findByShortenedForm(@PathVariable(value = "shortenedForm") String shortenedForm) {
        return ResponseEntity.ok()
                .body(service.findByShortenedForm(shortenedForm).orElseThrow(() -> new EntityNotFoundException("Not company found with code: " + shortenedForm)));
    }

}
