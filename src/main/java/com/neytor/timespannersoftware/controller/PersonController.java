package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.dto.Person;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.service.PersonService;
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
@Api("persons")
public class PersonController {

    public static final String NOT_PERSON_FOUND_WITH_ID = "Not Person found with id: ";
    private final PersonService service;
    private ModelMapper modelMapper;

    @Autowired
    public PersonController(PersonService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/person/all", produces = "application/json")
    @ApiOperation(value = "List all persons", response = PersonEntity[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/person/id/{id}", produces = "application/json")
    @ApiOperation(value = "Find a person by id", response = PersonEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the person"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Person> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(convertToDto(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_PERSON_FOUND_WITH_ID + id))));
    }

    @GetMapping(path = "/v1/person/name/{name}", produces = "application/json")
    @ApiOperation(value = "List persons by name", response = PersonEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Person"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Person>> findByLogin(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok().body(service.findByFullNameContaining(name).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @PostMapping(path = "/v1/Person", produces = "application/json")
    @ApiOperation(value = "Create Person", response = PersonEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Person successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create Persons"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden")
    })
    public ResponseEntity<Person> create(@RequestBody Person dto) {
        PersonEntity entity = convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(service.create(entity)));
    }

    @PutMapping(path = "/v1/Person", produces = "application/json")
    @ApiOperation(value = "Update Person", response = PersonEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Person successfully updated"),
            @ApiResponse(code = 401, message = "You are not authorized to update Persons"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Person> update(@RequestBody Person updateDto) {
        PersonEntity entity = service.findById(updateDto.getId()).orElseThrow(() -> new EntityNotFoundException(NOT_PERSON_FOUND_WITH_ID + updateDto.getId()));
        entity.setAddress(updateDto.getAddress());
        entity.setEmail(updateDto.getEmail());
        entity.setFirstName(updateDto.getFirstName());
        entity.setSecondName(updateDto.getSecondName());
        entity.setFirstSurname(updateDto.getFirstSurname());
        entity.setSecondSurname(updateDto.getSecondSurname());
        entity.setGender(updateDto.getGender());
        entity.setMaritalStatus(updateDto.getMaritalStatus());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(convertToDto(service.update(entity)));
    }

    @DeleteMapping(path = "/v1/person/{id}", produces = "application/json")
    @ApiOperation(value = "Delete person by id", response = Person.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Person successfully deleted"),
            @ApiResponse(code = 401, message = "You are not authorized to delete Persons"),
            @ApiResponse(code = 403, message = "The Operation you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Person> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_PERSON_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private Person convertToDto(PersonEntity entity) {
        return modelMapper.map(entity, Person.class);
    }

    private PersonEntity convertToEntity(Person dto) {
        return modelMapper.map(dto, PersonEntity.class);
    }
}
