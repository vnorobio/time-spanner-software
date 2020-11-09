package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.EmployeesGroupEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.repository.EmployeesGroupRepository;
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
public class EmployeesGroupServiceTest {

    @Autowired
    private EmployeesGroupService service;

    @MockBean
    private EmployeesGroupRepository repository;

    @Test
    @DisplayName("Test findAll Success")
    void testFindAll(){
        // Setup our mock repository
        EasyRandom generator = new EasyRandom();
        EmployeesGroupEntity entity = generator.nextObject( EmployeesGroupEntity.class );
        EmployeesGroupEntity entity2 = generator.nextObject( EmployeesGroupEntity.class );
        doReturn(Arrays.asList(entity, entity2)).when(repository).findAll();

        // Execute the service call
        List<EmployeesGroupEntity> entities = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, entities.size(), "findAll should return 2 widgets");
    }

    @Test
    @DisplayName("Test findById Success")
    void testFindById(){
        // Setup our mock repository
        EasyRandom generator = new EasyRandom();
        EmployeesGroupEntity entity = generator.nextObject( EmployeesGroupEntity.class );
        doReturn(Optional.of(entity)).when(repository).findById(1l);

        // Execute the service call
        Optional<EmployeesGroupEntity> returnedEntity = service.findById(1l);

        // Assert the response
        Assertions.assertTrue(returnedEntity.isPresent(), "EmployeesGroupEntity was not found");
        Assertions.assertSame(returnedEntity.get(), entity, "The entity returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(1l);

        // Execute the service call
        Optional<EmployeesGroupEntity> returnedEntity = service.findById(1l);

        // Assert the response
        Assertions.assertFalse(returnedEntity.isPresent(), "Widget should not be found");
    }

    @Test
    @DisplayName("Test create entity")
    void testCreate() {
        // Setup our mock repository
        EasyRandom generator = new EasyRandom();
        EmployeesGroupEntity entity = generator.nextObject( EmployeesGroupEntity.class );
        doReturn(entity).when(repository).save(org.mockito.ArgumentMatchers.any());

        // Execute the service call
        EmployeesGroupEntity returnedEntity = service.create(entity);

        // Assert the response
        Assertions.assertNotNull(returnedEntity, "The saved widget should not be null");
        Assertions.assertEquals(2L, returnedEntity.getId(), "The version should be incremented");
    }
}
