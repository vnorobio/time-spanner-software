package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.Project;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.ProjectEntity;
import com.neytor.timespannersoftware.service.ProjectService;
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
@Api("projects")
public class ProjectController {

    public static final String NOT_PROJECT_FOUND_WITH_ID = "Not project found with id: ";
    private final ProjectService service;
    private ModelMapper modelMapper;

    @Autowired
    public ProjectController(ProjectService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/project/all", produces = "application/json")
    @ApiOperation(value = "List all projects", response = ProjectEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Project>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/project/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a project by id", response = ProjectEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the project"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Project> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_PROJECT_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/project/code/{code}", produces = "application/json")
    @ApiOperation(value = "Find a project by code", response = ProjectEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the project"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Project>>  findByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok().body(service.findByCodeContaining(code).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/project/description/{description}", produces = "application/json")
    @ApiOperation(value = "Find a project by description", response = ProjectEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the project"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Project>>  findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(service.findByDescriptionContaining(description).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @PostMapping(path = "/v1/project", produces = "application/json")
    @ApiOperation(value = "Create project", response = ProjectEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "project successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create projects"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<Project> create(@RequestBody Project dto) {
        ProjectEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/project", produces = "application/json")
    @ApiOperation(value = "Update project", response = ProjectEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "project successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update projects"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Project> update(@RequestBody Project Updatedto) {
        ProjectEntity entity = service.findById(Updatedto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_PROJECT_FOUND_WITH_ID + Updatedto.getId()));
        entity.setDescription(Updatedto.getDescription());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/project/{id}", produces = "application/json")
    @ApiOperation(value = "Delete project by id", response = Project.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "project successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete projects"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Project> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_PROJECT_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private Project convertToDto(ProjectEntity entity) {
        return modelMapper.map(entity, Project.class);
    }

    private ProjectEntity convertToEntity(Project dto) {
        return modelMapper.map(dto, ProjectEntity.class);
    }
}
