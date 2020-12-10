package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.Contract;
import com.neytor.timespannersoftware.service.ContractService;
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
public class ContractController {

    public static final String NOT_CONTRACT_FOUND_WITH_ID = "Not contract found with id: ";
    private final ContractService service;

    @Autowired
    public ContractController(ContractService service) {
        this.service = service;
    }

    @Operation(summary = "to list all contracts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/contracts", produces = "application/json")
    public ResponseEntity<List<Contract>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Operation(summary = "to find a contract by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved contract",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/contracts/by-id/{id}", produces = "application/json")
    public ResponseEntity<Contract> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findById(id).get());
    }

    @Operation(summary = "to list contracts by identification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/contracts/by-identification/{identification}", produces = "application/json")
    public ResponseEntity<List<Contract>>findByIdentification(@PathVariable(value = "identification") String identification) {
        return ResponseEntity.ok().body(service.findByIdentificationNumber(identification));
    }

    @Operation(summary = "to list contracts by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping(path = "/contracts/by-name/{name}", produces = "application/json")
    public ResponseEntity<List<Contract>>findByName(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok().body(service.findByFullNameContaining(name));
    }

    @Operation(summary = "to register a new contract")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successfully created contract",
                    content = {@Content(mediaType = "application/json")}),
    })
    @PostMapping(path = "/contracts", produces = "application/json")
    public ResponseEntity<Contract> create(@RequestBody Contract dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "to update a contract")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202",
                    description = "Changes where accepted",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to update is not available",
                    content = @Content)
    })
    @PutMapping(path = "/contracts", produces = "application/json")
    public ResponseEntity<Contract> update(@RequestBody Contract updateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(updateDto));
    }

    @Operation(summary = "to delete a contract")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Not content",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to delete is not available",
                    content = @Content)
    })
    @DeleteMapping(path = "/contracts/by-id/{id}", produces = "application/json")
    public ResponseEntity<Contract> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
