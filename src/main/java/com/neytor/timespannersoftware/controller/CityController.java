package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/configuration")
public class CityController {

    public static final String NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID = "Not territorial division found with id: ";
    private final CityService service;

    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping(path = "/cities", produces = "application/json")
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = "/cities/by-id/{id}", produces = "application/json")
    public ResponseEntity<City> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok()
                .body(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + id)));
    }

    @GetMapping(path = "/cities/by-description/{description}", produces = "application/json")
    public ResponseEntity<List<City>>findByDescription(@PathVariable(value = "description") String description) {
        return ResponseEntity.ok().body(service.findByDescriptionContaining(description));
    }

    @PostMapping(path = "/cities", produces = "application/json")
    public ResponseEntity<City> create(@RequestBody City dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping(path = "/cities", produces = "application/json")
    public ResponseEntity<City> update(@RequestBody City updateDto) {
         if (!service.existsById( updateDto.getId() )){
            throw new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + updateDto.getId());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(updateDto));
    }

    @DeleteMapping(path = "/cities/by-id/{id}", produces = "application/json")
    public ResponseEntity<City> delete(@PathVariable(value = "id") Long id) {
        if (!service.existsById(id)) {
            throw new EntityNotFoundException(NOT_TERRITORIAL_DIVISION_FOUND_WITH_ID + id);
        }
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
