package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.factory.CountryFactory;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.mapper.CountryMapper;
import com.neytor.timespannersoftware.repository.CountryRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@SpringBootTest
@ExtendWith( MockitoExtension.class )
@ExtendWith( SpringExtension.class )
public class CountryServiceTest {

    private CountryFactory factory;
    private List< CountryEntity > countryDtoList;

    @MockBean
    private CountryRepository repository;

    @InjectMocks
    private CountryServiceImpl service;

    @BeforeEach
    private void setup( ) {
        this.service = new CountryServiceImpl( repository );
        this.factory = new CountryFactory( );

    }


    @Test
    @DisplayName( "Test findAll Success" )
    void testFindAll( ) {
        // Setup our mock repository
        List< CountryEntity > entities = this.factory.generateCountryEntityList( 10 );
        Mockito.when( repository.findAll( ) ).thenReturn( entities );


        // Execute the service call
        List< Country > countries = service.findAll( );

        // Assert the response
        Assertions.assertEquals( 10, countries.size( ), "findAll should return 10 Countries" );
    }

    @Test
    @DisplayName( "Test findById Success" )
    void testFindById( ) {
        // Setup our mock repository
        Optional< CountryEntity > entity = Optional.of( factory.generateCountryEntity( ) );
        Long id = Mockito.anyLong( );
        Mockito.when( repository.findById( id ) ).thenReturn( entity );

        // Execute the service call
        Optional< Country > returnedEntity = service.findById( id );

        // Assert the response
        Assertions.assertTrue( returnedEntity.isPresent( ), "Country entity was not found" );
        Assertions.assertSame( returnedEntity.get( ).getId( ), entity.get( ).getId( ), "The entity returned was not the same as the mock" );
    }

    @Test
    @DisplayName( "Test findById Not Found" )
    void testFindByIdNotFound( ) {
        // Setup our mock repository
        Long id = Mockito.anyLong( );
        Mockito.when( repository.findById( id ) ).thenReturn( Optional.empty( ) );

        // Execute the service call
        Optional< Country > returnedEntity = service.findById( id );

        // Assert the response
        Assertions.assertFalse( returnedEntity.isPresent( ), "Country should not be found" );
    }

    @Test
    @DisplayName( "Test findByName Success" )
    void testFindByName( ) {
        // Setup our mock repository
        String name = Mockito.anyString( );
        List< CountryEntity > entities = this.factory.generateCountryEntityList( 10 );
        Mockito.when( repository.findByNameContaining( name ) ).thenReturn( entities );

        // Execute the service call
        List< Country > countries = service.findByName( name );

        // Assert the response
        Assertions.assertEquals( 10, countries.size( ), "findAll should return 10 Countries" );

    }

    @Test
    @DisplayName( "Test findByNumericCode Success" )
    void testFindByNumericCode( ) {
        // Setup our mock repository
        Optional< CountryEntity > entity = Optional.of( factory.generateCountryEntity( ) );
        Integer code = entity.get( ).getNumericCode( );
        Mockito.when( repository.findByNumericCode( code ) ).thenReturn( entity );

        // Execute the service call
        Optional< Country > returnedEntity = service.findByNumericCode( code );

        // Assert the response
        Assertions.assertTrue( returnedEntity.isPresent( ), "Country entity was not found" );
        Assertions.assertSame( returnedEntity.get( ).getNumericCode( ), entity.get( ).getNumericCode( ), "The entity returned was not the same as the mock" );

    }

    @Test
    @DisplayName( "Test findByAlpha2Code Success" )
    void testFindByAlpha2Code( ) {
        // Setup our mock repository
        Optional< CountryEntity > entity = Optional.of( factory.generateCountryEntity( ) );
        String code = entity.get( ).getAlpha2Code( );
        Mockito.when( repository.findByAlpha2Code( code ) ).thenReturn( entity );

        // Execute the service call
        Optional< Country > returnedEntity = service.findByAlpha2Code( code );

        // Assert the response
        Assertions.assertTrue( returnedEntity.isPresent( ), "Country entity was not found" );
        Assertions.assertSame( returnedEntity.get( ).getAlpha2Code( ), entity.get( ).getAlpha2Code( ), "The entity returned was not the same as the mock" );

    }

    @Test
    @DisplayName( "Test findByAlpha3Code Success" )
    void testFindByAlpha3Code( ) {
        // Setup our mock repository
        Optional< CountryEntity > entity = Optional.of( factory.generateCountryEntity( ) );
        String code = entity.get( ).getAlpha3Code( );
        Mockito.when( repository.findByAlpha3Code( code ) ).thenReturn( entity );

        // Execute the service call
        Optional< Country > returnedEntity = service.findByAlpha3Code( code );

        // Assert the response
        Assertions.assertTrue( returnedEntity.isPresent( ), "Country entity was not found" );
        Assertions.assertSame( returnedEntity.get( ).getAlpha3Code( ), entity.get( ).getAlpha3Code( ), "The entity returned was not the same as the mock" );

    }


    @Test
    @DisplayName( "Test create entity" )
    void testCreate( ) {
        // Setup our mock repository
        CountryEntity entity = factory.generateCountryEntity( );
        Country dto = CountryMapper.convertToDto( entity );
        Mockito.when( repository.save( Mockito.any( ) ) ).thenReturn( entity );

        // Execute the service call
        Country returnedEntity = service.create( dto );

        // Assert the response
        Assertions.assertNotNull( returnedEntity, "The returned entity should not be null" );
        Assertions.assertEquals( returnedEntity.getId( ), entity.getId( ), "The id should be the same" );
    }

    @Test
    @DisplayName( "Test update" )
    void testUpdate(){
        // Setup our mock repository
        CountryEntity entity = factory.generateCountryEntity( );
        Country dto = CountryMapper.convertToDto( entity );
        Mockito.when( repository.save( Mockito.any( ) ) ).thenReturn( entity );

        // Execute the service call
        Country returnedEntity = service.update( dto );

        // Assert the response
        Assertions.assertNotNull( returnedEntity, "The returned entity should not be null" );
        Assertions.assertEquals( returnedEntity.getId( ), entity.getId( ), "The id should be the same" );
    }

    @Test
    @DisplayName( "Test exists by id " )
    void testNotExistsById(){
        // Setup our mock repository
        Optional< CountryEntity > entity = Optional.of( factory.generateCountryEntity( ) );
        Long id = Mockito.anyLong( );
        Mockito.when( repository.existsById( id ) ).thenReturn( Boolean.FALSE );

        // Execute the service call
        boolean exist = service.existsById( id );

        // Assert the response
        Assertions.assertFalse( exist, "Country entity do not exist" );
    }

    @Test
    @DisplayName( "Test exists by id " )
    void testExistsById(){
        // Setup our mock repository
        Optional< CountryEntity > entity = Optional.of( factory.generateCountryEntity( ) );
        Long id = Mockito.anyLong( );
        Mockito.when( repository.existsById( id ) ).thenReturn( Boolean.TRUE );

        // Execute the service call
        boolean exist = service.existsById( id );

        // Assert the response
        Assertions.assertTrue( exist, "Country entity do not exist" );
    }
}
