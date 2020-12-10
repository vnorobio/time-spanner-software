package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/configuration")
public class CountryController {

    public static final String NOT_COUNTRY_FOUND_WITH_ID = "Not country found with id: ";
    public static final String NOT_COUNTRY_FOUND_WITH_NAME = "Not country found with name: ";

    private final CountryService service;

    @Autowired
    public CountryController( CountryService service) {
        this.service = service;
    }

    @Operation(summary = "to list all countries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping( path = "/countries")
    public ResponseEntity< List< Country > > findAll( ) {
        return ResponseEntity.ok( ).body( service.findAll( ) );
    }

    @Operation(summary = "to find a country by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved country",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping( path = "/countries/by-id/{id}", produces = "application/json" )
    public ResponseEntity< Country > finById( @PathVariable( value = "id" ) Long id ) {
        return ResponseEntity.ok( )
                .body( service.findById( id ).orElseThrow( ( ) -> new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_ID + id ) ) );
    }

    @Operation(summary = "to list countries by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved list",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping( path = "/countries/by-name/{name}", produces = "application/json" )
    public ResponseEntity< List<Country > > findByName( @PathVariable( value = "name" ) String name ) {
        return ResponseEntity.ok( ).body( service.findByName( name) );
    }

    @Operation(summary = "to find a country by code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved country",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping( path = "/countries/by-code/{code}", produces = "application/json" )
    public ResponseEntity< Country > findByNumericCode( @PathVariable( value = "code" ) Integer code ) {
        return ResponseEntity.ok( )
                .body( service.findByNumericCode( code ).orElseThrow( ( ) -> new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_ID + code ) ) );
    }

    @Operation(summary = "to find a country by alpha 2 code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved country",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping( path = "/countries/by-alpha2code/{code}", produces = "application/json" )
    public ResponseEntity< Country > findByAlpha2Code( @PathVariable( value = "code" ) String code ) {
        return ResponseEntity.ok( )
                .body( service.findByAlpha2Code( code ).orElseThrow( ( ) -> new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_NAME + code ) ) );
    }

    @Operation(summary = "to find a country by alpha 3 code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved country",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to access is not available",
                    content = @Content)
    })
    @GetMapping( path = "/countries/by-alpha3code/{code}", produces = "application/json" )
    public ResponseEntity< Country > findByAlpha3Code( @PathVariable( value = "code" ) String code ) {
        return ResponseEntity.ok( )
                .body( service.findByAlpha3Code( code ).orElseThrow( ( ) -> new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_NAME + code ) ) );
    }

    @Operation(summary = "to register a new country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successfully created country",
                    content = {@Content(mediaType = "application/json")}),
    })
    @PostMapping( path = "/countries", produces = "application/json" )
    public ResponseEntity< Country > create( @RequestBody Country dto ) {
        return ResponseEntity.status( HttpStatus.CREATED ).body( service.create( dto ) );
    }

    @Operation(summary = "to update a country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202",
                    description = "Changes where accepted",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to update is not available",
                    content = @Content)
    })
    @PutMapping( path = "/countries", produces = "application/json" )
    public ResponseEntity< Country > update( @RequestBody Country updateDto ) {

        if (!service.existsById(updateDto.getId( ))){
            throw new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_ID + updateDto.getId( ) );
        }

        return ResponseEntity.status( HttpStatus.ACCEPTED ).body( service.update( updateDto ) );
    }

    @Operation(summary = "to delete a country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Not content",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The resource you were trying to delete is not available",
                    content = @Content)
    })
    @DeleteMapping( path = "/countries/by-id/{id}", produces = "application/json" )
    public ResponseEntity< Country > delete( @PathVariable( value = "id" ) Long id ) {
        if ( !service.existsById( id ) ) {
            throw new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_ID + id );
        }
        service.delete( id );
        return ResponseEntity.status( HttpStatus.NO_CONTENT ).body( null );
    }

}
