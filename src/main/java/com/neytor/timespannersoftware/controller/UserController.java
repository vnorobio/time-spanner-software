package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.NoneUserFoundException;
import com.neytor.timespannersoftware.model.UserEntity;
import com.neytor.timespannersoftware.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/catalogs")
@Api("users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/v1/user/all", produces = "application/json")
    @ApiOperation(value = "List all users", response = UserEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<UserEntity>> findAll() throws RuntimeException {
        List<UserEntity> users = service.findAll();
        if(users.isEmpty()) throw new NoneUserFoundException("None users where found");
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(path = "/v1/user/{id}", produces = "application/json")
    @ApiOperation(value = "Find a user by id", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the user"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<UserEntity> finById(@PathVariable(value = "id") Long id) throws RuntimeException {
        return ResponseEntity.ok().body(service.findById(id).orElseThrow(() -> new NoneUserFoundException("Not user found with id: " + id)));
    }

    @GetMapping(path = "/v1/user/{login}", produces = "application/json")
    @ApiOperation(value = "Find a user by login", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the user"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<UserEntity> finByLogin(@PathVariable(value = "login") String login) throws RuntimeException {
        return ResponseEntity.ok().body(service.findByLogin(login).orElseThrow(() -> new NoneUserFoundException("Not user found with login: " + login)));
    }

    @GetMapping(path = "/v1/user/{email}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the user"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @ApiOperation(value = "Find a user by email", response = UserEntity.class)
    public ResponseEntity<UserEntity> finByEmail(@PathVariable(value = "email") String email) throws RuntimeException {
        return ResponseEntity.ok().body(service.findByEmail(email).orElseThrow(() -> new NoneUserFoundException("Not user found with email: " + email)));
    }

    @PostMapping(path = "/v1/user", produces = "application/json")
    @ApiOperation(value = "Create user", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create users"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping(path = "/v1/user", produces = "application/json")
    @ApiOperation(value = "Update user", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "User successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update users"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity UpdateEntity) throws RuntimeException {
        UserEntity entity = service.findById(UpdateEntity.getId()).orElseThrow(() -> new NoneUserFoundException("Not user found with id: " + UpdateEntity.getId()));
        entity.setName(UpdateEntity.getName());
        entity.setEmail(UpdateEntity.getEmail());
        entity.setPassword(UpdateEntity.getPassword());
        entity.setActive(UpdateEntity.getActive());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(entity));
    }

    @DeleteMapping(path = "/v1/user/{id}", produces = "application/json")
    @ApiOperation(value = "Delete user by email", response = UserEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "User successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete users"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<UserEntity> delete(@PathVariable(value = "id") Long id) throws RuntimeException {
        if (!service.existsById(id)) {
            throw new NoneUserFoundException("Not user found with id: " + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
