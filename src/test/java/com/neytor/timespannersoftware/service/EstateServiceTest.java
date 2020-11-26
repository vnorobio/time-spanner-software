package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.factory.EstateFactory;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.model.mapper.EstateMapper;
import com.neytor.timespannersoftware.repository.EstateRepository;
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

@ExtendWith( MockitoExtension.class )
@ExtendWith( SpringExtension.class )
public class EstateServiceTest {

    private EstateFactory factory;

    @InjectMocks
    private EstateServiceImpl service;

    @MockBean
    private EstateRepository repository;

    @BeforeEach
    private void setup(){
        factory = new EstateFactory();
        service = new EstateServiceImpl( repository );
    }

    @Test
    @DisplayName("Test findAll Success")
    void testFindAll(){
        // Setup our mock repository
        List<EstateEntity> list = factory.generateEstateEntityList( 10 );
        doReturn(list).when(repository).findAll();

        // Execute the service call
        List<Estate> entities = service.findAll();

        // Assert the response
        Assertions.assertEquals(10, entities.size(), "findAll should return 2 widgets");
    }

    @Test
    @DisplayName("Test findById Success")
    void testFindById(){
        // Setup our mock repository
        EstateEntity entity = factory.generateEstateEntity( );
        doReturn(Optional.of(entity)).when(repository).findById(any());

        // Execute the service call
        Optional<Estate> returnedEntity = service.findById(any());

        // Assert the response
        Assertions.assertTrue(returnedEntity.isPresent(), "EstateEntity was not found");
        Assertions.assertSame(returnedEntity.get().getId(), entity.getId(), "The entity returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(any());

        // Execute the service call
        Optional<Estate> returnedEntity = service.findById(any());

        // Assert the response
        Assertions.assertFalse(returnedEntity.isPresent(), "Widget should not be found");
    }

    @Test
    @DisplayName("Test create entity")
    void testCreate() {
        // Setup our mock repository
        Estate dto = factory.generateEstateDto( );
        EstateEntity entity = EstateMapper.convertToEntity( dto );
        doReturn(entity).when(repository).save(org.mockito.ArgumentMatchers.any());

        // Execute the service call
        Estate returnedDto = service.create(dto);

        // Assert the response
        Assertions.assertNotNull(returnedDto, "The saved widget should not be null");
        Assertions.assertSame(entity.getId(), returnedDto.getId(), "The version should be incremented");
    }

    @Test
    @DisplayName( "Test update" )
    void testUpdate(){
        // Setup our mock repository
        EstateEntity entity = factory.generateEstateEntity( );
        Estate dto = EstateMapper.convertToDto( entity );
        Mockito.when( repository.save( Mockito.any( ) ) ).thenReturn( entity );

        // Execute the service call
        Estate returnedEntity = service.update( dto );

        // Assert the response
        Assertions.assertNotNull( returnedEntity, "The returned entity should not be null" );
        Assertions.assertEquals( returnedEntity.getId( ), entity.getId( ), "The id should be the same" );
    }

    @Test
    @DisplayName( "Test exists by id " )
    void testNotExistsById(){
        // Setup our mock repository
        Optional< EstateEntity > entity = Optional.of( factory.generateEstateEntity( ) );
        Long id = Mockito.anyLong( );
        Mockito.when( repository.existsById( id ) ).thenReturn( Boolean.FALSE );

        // Execute the service call
        boolean exist = service.existsById( id );

        // Assert the response
        Assertions.assertFalse( exist, "Estate entity do not exist" );
    }

    @Test
    @DisplayName( "Test exists by id " )
    void testExistsById(){
        // Setup our mock repository
        Optional< EstateEntity > entity = Optional.of( factory.generateEstateEntity( ) );
        Long id = Mockito.anyLong( );
        Mockito.when( repository.existsById( id ) ).thenReturn( Boolean.TRUE );

        // Execute the service call
        boolean exist = service.existsById( id );

        // Assert the response
        Assertions.assertTrue( exist, "Estate entity do not exist" );
    }
}
