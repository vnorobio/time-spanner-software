package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.model.dto.Date;
import com.neytor.timespannersoftware.model.DateEntity;
import com.neytor.timespannersoftware.service.DateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
@Api("dates")
public class DateController {
    public static final String NOT_DATES_WERE_FOUND = "Not dates were found for the given parameters ";
    private final DateService service;
    private ModelMapper modelMapper;

    @Autowired
    public DateController(DateService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/v1/dates/code/{code}", produces = "application/json")
    @ApiOperation(value = "Find dates by string date", response = DateEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the business unit"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Date>> findByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok().body(service.findByCodeContaining(code).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/dates/year/{year}/week/{week}", produces = "application/json")
    @ApiOperation(value = "Find dates by week of year", response = DateEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the business unit"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Date>> findByYearAndWeekOfYear(@PathVariable(value = "year") Integer year, @PathVariable(value = "week") Integer week) {
        return ResponseEntity.ok().body(service.findByYearAndWeekOfYear(year,week).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/dates/year/{year}/month/{month}", produces = "application/json")
    @ApiOperation(value = "Find dates by month of year", response = DateEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the business unit"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Date>> findByYearAndMonth(@PathVariable(value = "year") Integer year, @PathVariable(value = "month") Integer month) {
        return ResponseEntity.ok().body(service.findByYearAndMonth(year,month).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping(path = "/v1/dates/between/{start}/and/{ending}", produces = "application/json")
    @ApiOperation(value = "Find dates by month of year", response = DateEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the business unit"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<List<Date>> findByDateBetween(@PathVariable(value = "start") String start, @PathVariable(value = "ending") String ending) {
        return ResponseEntity.ok().body(service.findByDateBetween(LocalDate.parse(start), LocalDate.parse(ending)).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    private Date convertToDto(DateEntity entity) {
        return modelMapper.map(entity, Date.class);
    }

    private DateEntity convertToEntity(Date dto) {
        return modelMapper.map(dto, DateEntity.class);
    }

}
