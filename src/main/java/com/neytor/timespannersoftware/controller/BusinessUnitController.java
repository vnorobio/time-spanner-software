package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.BusinessUnit;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.BusinessUnitEntity;
import com.neytor.timespannersoftware.service.BusinessUnitService;
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
@Api("business_units")
public class BusinessUnitController {

    public static final String NOT_BUSINESS_UNIT_FOUND_WITH_ID = "Not business unit found with id: ";
    private final BusinessUnitService service;
    private ModelMapper modelMapper;

    @Autowired
    public BusinessUnitController(BusinessUnitService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/business_unit/all", produces = "application/json")
    @ApiOperation(value = "List all business unitS", response = BusinessUnitEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<BusinessUnit>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/business_unit/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a business unit by id", response = BusinessUnitEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the business_unit"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<BusinessUnit> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_BUSINESS_UNIT_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/business_unit/code/{code}", produces = "application/json")
    @ApiOperation(value = "Find a business_unit by code", response = BusinessUnitEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the business unit"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<BusinessUnit>>findByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok().body(service.findByCodeContaining(code).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/business_unit/description/{description}", produces = "application/json")
    @ApiOperation(value = "Find a business_unit by description", response = BusinessUnitEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the business_unit"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<BusinessUnit>>findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(service.findByDescriptionContaining(description).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @PostMapping(path = "/v1/business_unit", produces = "application/json")
    @ApiOperation(value = "Create business_unit", response = BusinessUnitEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "business_unit successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create business_units"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<BusinessUnit> create(@RequestBody BusinessUnit dto) {
        BusinessUnitEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/business_unit", produces = "application/json")
    @ApiOperation(value = "Update business_unit", response = BusinessUnitEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "business_unit successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update business_units"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<BusinessUnit> update(@RequestBody BusinessUnit Updatedto) {
        BusinessUnitEntity entity = service.findById(Updatedto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_BUSINESS_UNIT_FOUND_WITH_ID + Updatedto.getId()));
        entity.setDescription(Updatedto.getDescription());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/business_unit/{id}", produces = "application/json")
    @ApiOperation(value = "Delete business unit by id", response = BusinessUnit.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "business_unit successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete business_units"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<BusinessUnit> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_BUSINESS_UNIT_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private BusinessUnit convertToDto(BusinessUnitEntity entity) {
        return modelMapper.map(entity, BusinessUnit.class);
    }

    private BusinessUnitEntity convertToEntity(BusinessUnit dto) {
        return modelMapper.map(dto, BusinessUnitEntity.class);
    }
}
