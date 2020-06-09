package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.Profile;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.service.ProfileService;
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
@Api("profiles")
public class ProfileController {

    public static final String NOT_PROFILE_FOUND_WITH_ID = "Not profile found with id: ";
    private final ProfileService service;
    private ModelMapper modelMapper;

    @Autowired
    public ProfileController(ProfileService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/profile/all", produces = "application/json")
    @ApiOperation(value = "List all profiles", response = ProfileEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Profile>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/profile/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a profile by id", response = ProfileEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the profile"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Profile> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_PROFILE_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/profile/login/{login}", produces = "application/json")
    @ApiOperation(value = "Find a profile by login", response = ProfileEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the profile"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Profile> findByLogin(@PathVariable(value = "login") String description) {
        return ResponseEntity.ok().body(convertToDto(service.findByDescription(description).orElseThrow(() -> new EntityNotFoundException("Not profile found with login: " + description))));
    }

    @PostMapping(path = "/v1/profile", produces = "application/json")
    @ApiOperation(value = "Create profile", response = ProfileEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "profile successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create profiles"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<Profile> create(@RequestBody Profile dto) {
        ProfileEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/profile", produces = "application/json")
    @ApiOperation(value = "Update profile", response = ProfileEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "profile successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update profiles"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Profile> update(@RequestBody Profile Updatedto) {
        ProfileEntity entity = service.findById(Updatedto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_PROFILE_FOUND_WITH_ID + Updatedto.getId()));
        entity.setDescription(Updatedto.getDescription());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/profile/{id}", produces = "application/json")
    @ApiOperation(value = "Delete profile by id", response = Profile.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "profile successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete profiles"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Profile> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_PROFILE_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private Profile convertToDto(ProfileEntity entity) {
        return modelMapper.map(entity, Profile.class);
    }

    private ProfileEntity convertToEntity(Profile dto) {
        return modelMapper.map(dto, ProfileEntity.class);
    }
}
