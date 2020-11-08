package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.User;
import com.neytor.timespannersoftware.model.UserEntity;
import com.neytor.timespannersoftware.service.UserService;
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
@Api("users")
public class UserController {

    public static final String NOT_USER_FOUND_WITH_ID = "Not user found with id: ";
    private final UserService service;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/user/all", produces = "application/json")
    @ApiOperation(value = "List all users", response = UserEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/user/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a user by id", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the user"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<User> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_USER_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/user/login/{login}", produces = "application/json")
    @ApiOperation(value = "Find a user by login", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the user"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<User> findByLogin(@PathVariable(value = "login") String login) {
        return ResponseEntity.ok().body(convertToDto(service.findByLogin(login).orElseThrow(() -> new EntityNotFoundException("Not user found with login: " + login))));
    }

    @GetMapping(path = "/v1/user/email/{email}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the user"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @ApiOperation(value = "Find a user by email", response = UserEntity.class)
    public ResponseEntity<User> findByEmail(@PathVariable(value = "email") String email) {
        return ResponseEntity.ok().body(convertToDto(service.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Not user found with email: " + email))));
    }

    @PostMapping(path = "/v1/user", produces = "application/json")
    @ApiOperation(value = "Create user", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create users"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<User> create(@RequestBody User dto) {
        UserEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/user", produces = "application/json")
    @ApiOperation(value = "Update user", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "User successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update users"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<User> update(@RequestBody User updateDto) {
        UserEntity entity = service.findById(updateDto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_USER_FOUND_WITH_ID + updateDto.getId()));
        entity.setName(updateDto.getName());
        entity.setEmail(updateDto.getEmail());
        entity.setPassword(updateDto.getPassword());
        entity.setActive(updateDto.getActive());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/user/{id}", produces = "application/json")
    @ApiOperation(value = "Delete user by id", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "User successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete users"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<User> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_USER_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private User convertToDto(UserEntity entity) {
        return modelMapper.map(entity, User.class);
    }

    private UserEntity convertToEntity(User dto) {
        return modelMapper.map(dto, UserEntity.class);
    }
}
