package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.OperatingCenter;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.OperatingCenterEntity;
import com.neytor.timespannersoftware.service.OperatingCenterService;
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
@Api("operating_centers")
public class OperatingCenterController {

    public static final String NOT_OPERATING_CENTER_FOUND_WITH_ID = "Not operating center found with id: ";
    private final OperatingCenterService service;
    private ModelMapper modelMapper;

    @Autowired
    public OperatingCenterController(OperatingCenterService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/operating_center/all", produces = "application/json")
    @ApiOperation(value = "List all operatings centerS", response = OperatingCenterEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<OperatingCenter>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/operating_center/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a operating center by id", response = OperatingCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the operating center"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<OperatingCenter> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_OPERATING_CENTER_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/operating_center/code/{code}", produces = "application/json")
    @ApiOperation(value = "Find a operating_center by code", response = OperatingCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the operating center"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<OperatingCenter>>findByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok().body(service.findByCodeContaining(code).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/operating_center/description/{description}", produces = "application/json")
    @ApiOperation(value = "Find a operating_center by description", response = OperatingCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the operating center"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<OperatingCenter>>findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(service.findByDescriptionContaining(description).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @PostMapping(path = "/v1/operating_center", produces = "application/json")
    @ApiOperation(value = "Create operating_center", response = OperatingCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "operating_center successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create operatings centers"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<OperatingCenter> create(@RequestBody OperatingCenter dto) {
        OperatingCenterEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/operating_center", produces = "application/json")
    @ApiOperation(value = "Update operating_center", response = OperatingCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "operating_center successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update operating centers"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<OperatingCenter> update(@RequestBody OperatingCenter Updatedto) {
        OperatingCenterEntity entity = service.findById(Updatedto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_OPERATING_CENTER_FOUND_WITH_ID + Updatedto.getId()));
        entity.setDescription(Updatedto.getDescription());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/operating_center/{id}", produces = "application/json")
    @ApiOperation(value = "Delete operatings center by id", response = OperatingCenter.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "operating_center successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete operating centers"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<OperatingCenter> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_OPERATING_CENTER_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private OperatingCenter convertToDto(OperatingCenterEntity entity) {
        return modelMapper.map(entity, OperatingCenter.class);
    }

    private OperatingCenterEntity convertToEntity(OperatingCenter dto) {
        return modelMapper.map(dto, OperatingCenterEntity.class);
    }
}
