package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.City;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.service.CityService;
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
@Api("territorial_divisions")
public class CityController {

    public static final String NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID = "Not territorial division found with id: ";
    private final CityService service;
    private ModelMapper modelMapper;

    @Autowired
    public CityController(CityService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/territorial_division/all", produces = "application/json")
    @ApiOperation(value = "List all territorial divisions", response = CityEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/territorial_division/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a territorial division by id", response = CityEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the territorial division"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<City> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/territorial_division/code/{code}", produces = "application/json")
    @ApiOperation(value = "Find a territorial_division by code", response = CityEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the territorial division"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<City>>findByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok().body(service.findByCodeContaining(code).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/territorial_division/description/{description}", produces = "application/json")
    @ApiOperation(value = "Find a territorial_division by description", response = CityEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the territorial_division"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<City>>findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(service.findByDescriptionContaining(description).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @PostMapping(path = "/v1/territorial_division", produces = "application/json")
    @ApiOperation(value = "Create territorial_division", response = CityEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "territorial division successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create territorial_divisions"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<City> create(@RequestBody City dto) {
        CityEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/territorial_division", produces = "application/json")
    @ApiOperation(value = "Update territorial division", response = CityEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "territorial division successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update territorial_divisions"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<City> update(@RequestBody City updateDto) {
        CityEntity entity = service.findById(updateDto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + updateDto.getId()));
        entity.setDescription(updateDto.getDescription());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/territorial_division/{id}", produces = "application/json")
    @ApiOperation(value = "Delete territorial division by id", response = City.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "territorial division successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete territorial_divisions"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<City> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private City convertToDto(CityEntity entity) {
        return modelMapper.map(entity, City.class);
    }

    private CityEntity convertToEntity(City dto) {
        return modelMapper.map(dto, CityEntity.class);
    }
}
