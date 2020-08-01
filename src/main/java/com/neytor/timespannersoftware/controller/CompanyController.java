package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.Company;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CompanyEntity;
import com.neytor.timespannersoftware.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
@Api("companies")
public class CompanyController {

    public static final String NOT_COMPANY_FOUND_WITH_ID = "Not company found with id: ";
    private final CompanyService service;
    private ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/company/all", produces = "application/json")
    @ApiOperation(value = "List all companies", response = CompanyEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/company/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a company by id", response = CompanyEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the company"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Company> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_COMPANY_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/company/description/{description}", produces = "application/json")
    @ApiOperation(value = "Find a company by description", response = CompanyEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the company"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Company> findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(convertToDto(service.findByDescription(description).orElseThrow(() -> new EntityNotFoundException("Not company found with description: " + description))));
    }

    @PostMapping(path = "/v1/company", produces = "application/json")
    @ApiOperation(value = "Create company", response = CompanyEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "company successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create companys"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<Company> create(@RequestBody Company dto) {
        CompanyEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/company", produces = "application/json")
    @ApiOperation(value = "Update company", response = CompanyEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "company successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update companys"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Company> update(@RequestBody Company updateDto) {
        CompanyEntity entity = service.findById(updateDto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_COMPANY_FOUND_WITH_ID + updateDto.getId()));
        entity.setDescription(updateDto.getDescription());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/company/{id}", produces = "application/json")
    @ApiOperation(value = "Delete company by id", response = Company.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "company successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete companys"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Company> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_COMPANY_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private Company convertToDto(CompanyEntity entity) {
        return modelMapper.map(entity, Company.class);
    }

    private CompanyEntity convertToEntity(Company dto) {
        return modelMapper.map(dto, CompanyEntity.class);
    }
}
