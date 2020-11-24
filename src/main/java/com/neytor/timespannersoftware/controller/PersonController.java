package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.Person;
import com.neytor.timespannersoftware.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/configuration")
public class PersonController {

    public static final String NOT_PERSON_FOUND_WITH_ID = "Not Person found with id: ";

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping(path = "/persons", produces = "application/json")
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().collect(Collectors.toList()));
    }

    @GetMapping(path = "/person/by-id/{id}", produces = "application/json")
    public ResponseEntity<Person> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok()
                .body(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_PERSON_FOUND_WITH_ID + id)));
    }

    @GetMapping(path = "/persons/by-name/{name}", produces = "application/json")
    public ResponseEntity<List<Person>> findByLogin(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok().body(service.findByFullNameContaining(name).stream().collect(Collectors.toList()));
    }

    @PostMapping(path = "/person", produces = "application/json")
    public ResponseEntity<Person> create(@RequestBody Person dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping(path = "/person", produces = "application/json")
    public ResponseEntity<Person> update(@RequestBody Person updateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(updateDto));
    }

    @DeleteMapping(path = "/person/by-id/{id}", produces = "application/json")
    public ResponseEntity<Person> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_PERSON_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
