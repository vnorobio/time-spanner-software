package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.Company;
import com.neytor.timespannersoftware.dto.IdentificationType;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.IdentificationTypeEntity;
import com.neytor.timespannersoftware.service.IdentificationTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
@Api("companies")
public class IdentificationTypeController {

    public static final String NOT_TYPE_FOUND_WITH_ID = "Not identification type found with id: ";
    private final IdentificationTypeService service;
    private ModelMapper modelMapper;

    @Autowired
    public IdentificationTypeController(IdentificationTypeService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/identification/type/all", produces = "application/json")
    @ApiOperation(value = "List all companies", response = IdentificationTypeEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<IdentificationType>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/identification/type/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a identification type by id", response = IdentificationTypeEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the identification type"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<IdentificationType> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_TYPE_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/identification/type/code/{code}", produces = "application/json")
    @ApiOperation(value = "Find a identification type by code", response = IdentificationTypeEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the identification type"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<IdentificationType> findByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok().body(convertToDto(service.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Not identification type found with code: " + code))));
    }

    @GetMapping(path = "/v1/identification/type/description/{description}", produces = "application/json")
    @ApiOperation(value = "Find a identification type by description", response = IdentificationTypeEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the identification type"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<IdentificationType> findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(convertToDto(service.findByDescription(description).orElseThrow(() -> new EntityNotFoundException("Not company found with login: " + description))));
    }

    @GetMapping(path = "/v1/identification/type/short/{shortenedForm}", produces = "application/json")
    @ApiOperation(value = "Find a identification type by code", response = IdentificationTypeEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the identification type"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<IdentificationType> findByShortenedForm(@PathVariable(value = "shortenedForm") String shortenedForm) {
        return ResponseEntity.ok().body(convertToDto(service.findByShortenedForm(shortenedForm).orElseThrow(() -> new EntityNotFoundException("Not company found with code: " + shortenedForm))));
    }

    @PostMapping(path = "/v1/identification/type", produces = "application/json")
    @ApiOperation(value = "Create identification type", response = IdentificationTypeEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "company successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create companys"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<IdentificationType> create(@RequestBody IdentificationType dto) {
        IdentificationTypeEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/identification/type", produces = "application/json")
    @ApiOperation(value = "Update identification type", response = IdentificationTypeEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "company successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update companys"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<IdentificationType> update(@RequestBody IdentificationType Updatedto) {
        IdentificationTypeEntity entity = service.findById(Updatedto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_TYPE_FOUND_WITH_ID + Updatedto.getId()));
        entity.setCode(Updatedto.getCode());
        entity.setDescription(Updatedto.getDescription());
        entity.setShortenedForm(Updatedto.getShortenedForm());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/identification/type/{id}", produces = "application/json")
    @ApiOperation(value = "Delete identification type by id", response = Company.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "company successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete companys"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<IdentificationType> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_TYPE_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private IdentificationType convertToDto(IdentificationTypeEntity entity) {
        return modelMapper.map(entity, IdentificationType.class);
    }

    private IdentificationTypeEntity convertToEntity(IdentificationType dto) {
        return modelMapper.map(dto, IdentificationTypeEntity.class);
    }
}
