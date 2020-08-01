package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.CostsCenter;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CostsCenterEntity;
import com.neytor.timespannersoftware.service.CostsCenterService;
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
@Api("costs_centers")
public class CostsCenterController {

    public static final String NOT_COST_CENTER_FOUND_WITH_ID = "Not costs center found with id: ";
    private final CostsCenterService service;
    private ModelMapper modelMapper;

    @Autowired
    public CostsCenterController(CostsCenterService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/costs_center/all", produces = "application/json")
    @ApiOperation(value = "List all costs centerS", response = CostsCenterEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<CostsCenter>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/costs_center/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a costs center by id", response = CostsCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the costs center"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<CostsCenter> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_COST_CENTER_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/costs_center/code/{code}", produces = "application/json")
    @ApiOperation(value = "Find a costs_center by code", response = CostsCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the costs center"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<CostsCenter>>findByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok().body(service.findByCodeContaining(code).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/costs_center/description/{description}", produces = "application/json")
    @ApiOperation(value = "Find a costs_center by description", response = CostsCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the costs center"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<CostsCenter>>findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(service.findByDescriptionContaining(description).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @PostMapping(path = "/v1/costs_center", produces = "application/json")
    @ApiOperation(value = "Create costs_center", response = CostsCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "costs_center successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create costs centers"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<CostsCenter> create(@RequestBody CostsCenter dto) {
        CostsCenterEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/costs_center", produces = "application/json")
    @ApiOperation(value = "Update costs_center", response = CostsCenterEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "costs_center successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update costs centers"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<CostsCenter> update(@RequestBody CostsCenter updateDto) {
        CostsCenterEntity entity = service.findById(updateDto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_COST_CENTER_FOUND_WITH_ID + updateDto.getId()));
        entity.setDescription(updateDto.getDescription());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/costs_center/{id}", produces = "application/json")
    @ApiOperation(value = "Delete costs center by id", response = CostsCenter.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "costs_center successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete costs centers"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<CostsCenter> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_COST_CENTER_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private CostsCenter convertToDto(CostsCenterEntity entity) {
        return modelMapper.map(entity, CostsCenter.class);
    }

    private CostsCenterEntity convertToEntity(CostsCenter dto) {
        return modelMapper.map(dto, CostsCenterEntity.class);
    }
}
