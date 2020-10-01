package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.EmployeesGroupEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.repository.ContractRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ContractServiceTest {

    @Autowired
    private ContractService service;

    @MockBean
    private ContractRepository repository;

    @Test
    @DisplayName("Test findAll Success")
    void testFindAll(){
        // Setup our mock repository
        CityEntity city = new CityEntity();
        PersonEntity person = new PersonEntity();
        EmployeesGroupEntity employees = new EmployeesGroupEntity();
        ContractEntity entity = new ContractEntity(1L, "reference", person, 1, new Date(), null, new BigDecimal(200), 1, employees, city);
        ContractEntity entity2 = new ContractEntity(2L, "reference", person, 1, new Date(), null, new BigDecimal(200), 1, employees, city);
        doReturn(Arrays.asList(entity, entity2)).when(repository).findAll();

        // Execute the service call
        List<ContractEntity> entities = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, entities.size(), "findAll should return 2 widgets");
    }

    @Test
    @DisplayName("Test findById Success")
    void testFindById(){
        // Setup our mock repository
        CityEntity city = new CityEntity();
        PersonEntity person = new PersonEntity();
        EmployeesGroupEntity employees = new EmployeesGroupEntity();
        ContractEntity entity = new ContractEntity(1L, "reference", person, 1, new Date(), null, new BigDecimal(200), 1, employees, city);
        doReturn(Optional.of(entity)).when(repository).findById(1l);

        // Execute the service call
        Optional<ContractEntity> returnedEntity = service.findById(1l);

        // Assert the response
        Assertions.assertTrue(returnedEntity.isPresent(), "ContractEntity was not found");
        Assertions.assertSame(returnedEntity.get(), entity, "The entity returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(1l);

        // Execute the service call
        Optional<ContractEntity> returnedEntity = service.findById(1l);

        // Assert the response
        Assertions.assertFalse(returnedEntity.isPresent(), "Widget should not be found");
    }

    @Test
    @DisplayName("Test create entity")
    void testCreate() {
        // Setup our mock repository
        CityEntity city = new CityEntity();
        PersonEntity person = new PersonEntity();
        EmployeesGroupEntity employees = new EmployeesGroupEntity();
        ContractEntity entity = new ContractEntity(2L, "reference", person, 1, new Date(), null, new BigDecimal(200), 1, employees, city);
        doReturn(entity).when(repository).save(org.mockito.ArgumentMatchers.any());

        // Execute the service call
        ContractEntity returnedEntity = service.create(entity);

        // Assert the response
        Assertions.assertNotNull(returnedEntity, "The saved widget should not be null");
        Assertions.assertEquals(2L, returnedEntity.getId(), "The version should be incremented");
    }
}
