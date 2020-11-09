package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.repository.CityRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService service;

    @MockBean
    private CityRepository repository;

    @Test
    @DisplayName("Test findAll Success")
    void testFindAll(){
        // Setup our mock repository
        EasyRandom generator = new EasyRandom();
        City entity = generator.nextObject( City.class );
        City entity2 = generator.nextObject( City.class );
        doReturn(Arrays.asList(entity, entity2)).when(repository).findAll();

        // Execute the service call
        List<City> entities = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, entities.size(), "findAll should return 2 widgets");
    }

    @Test
    @DisplayName("Test findById Success")
    void testFindById(){
        // Setup our mock repository
        EasyRandom generator = new EasyRandom();
        City entity = generator.nextObject( City.class );
        doReturn(Optional.of(entity)).when(repository).findById(1l);

        // Execute the service call
        Optional<City> returnedEntity = service.findById(1l);

        // Assert the response
        Assertions.assertTrue(returnedEntity.isPresent(), "CityEntity was not found");
        Assertions.assertSame(returnedEntity.get(), entity, "The entity returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(1l);

        // Execute the service call
        Optional<City> returnedEntity = service.findById(1l);

        // Assert the response
        Assertions.assertFalse(returnedEntity.isPresent(), "Widget should not be found");
    }

    @Test
    @DisplayName("Test create entity")
    void testCreate() {
        // Setup our mock repository
        EasyRandom generator = new EasyRandom();
        City entity = generator.nextObject( City.class );
        doReturn(entity).when(repository).save(org.mockito.ArgumentMatchers.any());

        // Execute the service call
        City returnedEntity = service.create(entity);

        // Assert the response
        Assertions.assertNotNull(returnedEntity, "The saved widget should not be null");
        Assertions.assertEquals(2L, returnedEntity.getId(), "The version should be incremented");
    }
}
