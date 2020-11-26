package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.factory.CityFactory;
import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.mapper.CityMapper;
import com.neytor.timespannersoftware.repository.CityRepository;
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

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

//@SpringBootTest
@ExtendWith( MockitoExtension.class )
@ExtendWith( SpringExtension.class )
public class CityServiceTest {

    private CityFactory factory;

    @InjectMocks
    private CityServiceImpl service;

    @MockBean
    private CityRepository repository;

    @BeforeEach
    private void setup( ) {
        this.service = new CityServiceImpl( repository );
        this.factory = new CityFactory( );

    }

    @Test
    @DisplayName("Test findAll Success")
    void testFindAll(){
        // Setup our mock repository
        List< CityEntity > entities = factory.generateCityEntityList( 10);
        doReturn(entities).when(repository).findAll();

        // Execute the service call
        List<City> cities = service.findAll();

        // Assert the response
        Assertions.assertEquals(10, cities.size(), "findAll should return 2 widgets");
    }

    @Test
    @DisplayName("Test findById Success")
    void testFindById(){
        // Setup our mock repository

        Optional<CityEntity> entity = Optional.of( factory.generateCityEntity());
        doReturn(entity).when(repository).findById(any());

        // Execute the service call
        Optional<City> returnedEntity = service.findById(any());

        // Assert the response
        Assertions.assertTrue(returnedEntity.isPresent(), "City Entity was not found");
        Assertions.assertSame(returnedEntity.get().getId(), entity.get().getId(), "The entity returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(any());

        // Execute the service call
        Optional<City> returnedEntity = service.findById(any());

        // Assert the response
        Assertions.assertFalse(returnedEntity.isPresent(), "Entity should not be found");
    }

    @Test
    @DisplayName("Test create entity")
    void testCreate() {
        // Setup our mock repository
        CityEntity entity = factory.generateCityEntity( );
        City dto = CityMapper.convertToDto( entity );
        doReturn(entity).when(repository).save(any());

        // Execute the service call
        City returnedEntity = service.create(dto);

        // Assert the response
        Assertions.assertNotNull(returnedEntity, "The saved widget should not be null");
        Assertions.assertSame(entity.getId(), returnedEntity.getId(), "The version should be incremented");
    }

    @Test
    @DisplayName( "Test update" )
    void testUpdate(){
        // Setup our mock repository
        CityEntity entity = factory.generateCityEntity( );
        City dto = CityMapper.convertToDto( entity );
        Mockito.when( repository.save( Mockito.any( ) ) ).thenReturn( entity );

        // Execute the service call
        City returnedEntity = service.update( dto );

        // Assert the response
        Assertions.assertNotNull( returnedEntity, "The returned entity should not be null" );
        Assertions.assertEquals( returnedEntity.getId( ), entity.getId( ), "The id should be the same" );
    }

    @Test
    @DisplayName( "Test exists by id " )
    void testNotExistsById(){
        // Setup our mock repository
        Optional< CityEntity > entity = Optional.of( factory.generateCityEntity( ) );
        Long id = Mockito.anyLong( );
        Mockito.when( repository.existsById( id ) ).thenReturn( Boolean.FALSE );

        // Execute the service call
        boolean exist = service.existsById( id );

        // Assert the response
        Assertions.assertFalse( exist, "City entity do not exist" );
    }

    @Test
    @DisplayName( "Test exists by id " )
    void testExistsById(){
        // Setup our mock repository
        Optional< CityEntity > entity = Optional.of( factory.generateCityEntity( ) );
        Long id = Mockito.anyLong( );
        Mockito.when( repository.existsById( id ) ).thenReturn( Boolean.TRUE );

        // Execute the service call
        boolean exist = service.existsById( id );

        // Assert the response
        Assertions.assertTrue( exist, "City entity do not exist" );
    }

}
