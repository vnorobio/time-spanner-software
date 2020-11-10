package com.neytor.timespannersoftware.controller;

import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.mapper.CountryMapper;
import com.neytor.timespannersoftware.service.CountryService;
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
@RequestMapping( "/catalogs" )
@Api( "countries" )
public class CountryController {

    public static final String NOT_COUNTRY_FOUND_WITH_ID = "Not country found with id: ";
    public static final String NOT_COUNTRY_FOUND_WITH_NAME = "Not country found with name: ";
    private final CountryService service;
    private ModelMapper modelMapper;

    @Autowired
    public CountryController( CountryService service, ModelMapper modelMapper ) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping( path = "/v1/country/all", produces = "application/json" )
    @ApiOperation( value = "List all countries", response = CountryEntity[].class )
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "Successfully retrieved list" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" )
    } )
    public ResponseEntity< List< Country > > findAll( ) {
        return ResponseEntity.ok( ).body( service.findAll( ) );
    }

    @GetMapping( path = "/v1/country/id/{id}", produces = "application/json" )
    @ApiOperation( value = "Find a company by id", response = CountryEntity.class )
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "Successfully retrieved the company" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" )
    } )
    public ResponseEntity< Country > finById( @PathVariable( value = "id" ) Long id ) {
        return ResponseEntity.ok( )
                .body( service.findById( id ).orElseThrow( ( ) -> new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_ID + id ) ) );
    }

    @GetMapping( path = "/v1/country/name/{name}", produces = "application/json" )
    @ApiOperation( value = "Find a company by name", response = CountryEntity.class )
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "Successfully retrieved the company" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" )
    } )
    public ResponseEntity< List<Country > > findByName( @PathVariable( value = "name" ) String name ) {
        return ResponseEntity.ok( ).body( service.findByName( name) );
    }

    @GetMapping( path = "/v1/country/code/{code}", produces = "application/json" )
    @ApiOperation( value = "Find a company by numeric code", response = CountryEntity.class )
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "Successfully retrieved the company" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" )
    } )
    public ResponseEntity< Country > findByNumericCode( @PathVariable( value = "code" ) Integer code ) {
        return ResponseEntity.ok( )
                .body( service.findByNumericCode( code ).orElseThrow( ( ) -> new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_ID + code ) ) );
    }

    @GetMapping( path = "/v1/country/alpha2code/{code}", produces = "application/json" )
    @ApiOperation( value = "Find a company by alpha 2 code", response = CountryEntity.class )
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "Successfully retrieved the company" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" )
    } )
    public ResponseEntity< Country > findByAlpha2Code( @PathVariable( value = "code" ) String code ) {
        return ResponseEntity.ok( )
                .body( service.findByAlpha2Code( code ).orElseThrow( ( ) -> new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_NAME + code ) ) );
    }

    @GetMapping( path = "/v1/country/alpha3code/{code}", produces = "application/json" )
    @ApiOperation( value = "Find a company by alpha 3 code", response = CountryEntity.class )
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "Successfully retrieved the company" ),
            @ApiResponse( code = 401, message = "You are not authorized to view the resource" ),
            @ApiResponse( code = 403, message = "Accessing the resource you were trying to reach is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" )
    } )
    public ResponseEntity< Country > findByAlpha3Code( @PathVariable( value = "code" ) String code ) {
        return ResponseEntity.ok( )
                .body( service.findByAlpha3Code( code ).orElseThrow( ( ) -> new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_NAME + code ) ) );
    }


    @PostMapping( path = "/v1/country", produces = "application/json" )
    @ApiOperation( value = "Create country", response = CountryEntity.class )
    @ApiResponses( value = {
            @ApiResponse( code = 201, message = "company successfully created" ),
            @ApiResponse( code = 401, message = "You are not authorized to create companys" ),
            @ApiResponse( code = 403, message = "The Operation you were trying is forbidden" )
    } )
    public ResponseEntity< Country > create( @RequestBody Country dto ) {
        return ResponseEntity.status( HttpStatus.CREATED ).body( service.create( dto ) );
    }

    @PutMapping( path = "/v1/country", produces = "application/json" )
    @ApiOperation( value = "Update country", response = CountryEntity.class )
    @ApiResponses( value = {
            @ApiResponse( code = 202, message = "country successfully updated" ),
            @ApiResponse( code = 401, message = "You are not authorized to update countries" ),
            @ApiResponse( code = 403, message = "The Operation you were trying is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" )
    } )
    public ResponseEntity< Country > update( @RequestBody Country updateDto ) {

        if (service.existsById(updateDto.getId( ))){
            throw new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_ID + updateDto.getId( ) );
        }

        return ResponseEntity.status( HttpStatus.ACCEPTED ).body( service.update( updateDto ) );
    }

    @DeleteMapping( path = "/v1/country/{id}", produces = "application/json" )
    @ApiOperation( value = "Delete country by id", response = Country.class )
    @ApiResponses( value = {
            @ApiResponse( code = 204, message = "country successfully deleted" ),
            @ApiResponse( code = 401, message = "You are not authorized to delete countries" ),
            @ApiResponse( code = 403, message = "The Operation you were trying is forbidden" ),
            @ApiResponse( code = 404, message = "The resource you were trying to reach is not found" )
    } )
    public ResponseEntity< Country > delete( @PathVariable( value = "id" ) Long id ) {
        if ( !service.existsById( id ) ) {
            throw new EntityNotFoundException( NOT_COUNTRY_FOUND_WITH_ID + id );
        }
        service.delete( id );
        return ResponseEntity.status( HttpStatus.NO_CONTENT ).body( null );
    }

    private Country convertToDto( CountryEntity entity ) {
        return modelMapper.map( entity, Country.class );
    }

    private CountryEntity convertToEntity( Country dto ) {
        return modelMapper.map( dto, CountryEntity.class );
    }
}
