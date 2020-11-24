package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.IdentificationType;
import com.neytor.timespannersoftware.service.IdentificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/configuration")
public class IdentificationTypeController {

    public static final String NOT_TYPE_FOUND_WITH_ID = "Not identification type found with id: ";

    private final IdentificationTypeService service;

    @Autowired
    public IdentificationTypeController(IdentificationTypeService service) {
        this.service = service;
    }

    @GetMapping(path = "/identification-types", produces = "application/json")
    public ResponseEntity<List<IdentificationType>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = "/identification-type/by-id/{id}", produces = "application/json")
    public ResponseEntity<IdentificationType> finById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_TYPE_FOUND_WITH_ID + id)));
    }

    @GetMapping(path = "/identification-type/by-code/{code}", produces = "application/json")
    public ResponseEntity<IdentificationType> findByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok()
                .body(service.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Not identification type found with code: " + code)));
    }

    @GetMapping(path = "/identification-type/by-short/{shortenedForm}", produces = "application/json")
    public ResponseEntity<IdentificationType> findByShortenedForm(@PathVariable(value = "shortenedForm") String shortenedForm) {
        return ResponseEntity.ok()
                .body(service.findByShortenedForm(shortenedForm).orElseThrow(() -> new EntityNotFoundException("Not company found with code: " + shortenedForm)));
    }

}
