package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.Contract;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.model.mapper.ContractMapper;
import com.neytor.timespannersoftware.repository.ContractRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContractServiceImplTest {

    private final EasyRandom generator = new EasyRandom(  );

    @InjectMocks
    private ContractServiceImpl service;

    @Mock
    private ContractRepository repository;

    @BeforeEach
    public void setUp() {
        this.service = new ContractServiceImpl(repository);
    }

    @Test
    void shouldReturnCitiesListWhenFindAll() {
        List<ContractEntity> entityList = generator.objects(ContractEntity.class,10).collect(Collectors.toList());
        when(repository.findAll()).thenReturn(entityList);

        List<Contract> dtosList = service.findAll();

        verify(repository,atLeastOnce()).findAll();
        assertEquals(entityList.size(),dtosList.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindAll() {
        List<ContractEntity> entityList = new ArrayList<>();
        when(repository.findAll()).thenReturn(entityList);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findAll();
        });

    }

    @Test
    void shouldReturnContractListWhenFindByIdentificationNumber() {
        List<ContractEntity> entityList = generator.objects(ContractEntity.class,10).collect(Collectors.toList());
        when(repository.findByPersonIdentificationNumber(anyString())).thenReturn(entityList);

        List<Contract> dtoList = service.findByIdentificationNumber("idNumber");

        verify(repository, atLeastOnce()).findByPersonIdentificationNumber(anyString());
        assertEquals(entityList.size(), dtoList.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenWhenFindByIdentificationNumber() {
        List<ContractEntity> entityList = new ArrayList<>();
        when(repository.findByPersonIdentificationNumber(anyString())).thenReturn(entityList);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByIdentificationNumber("idNumber");
        });

    }

    @Test
    void shouldReturnContractListWhenFindByIdentificationNumberContaining() {
        List<ContractEntity> entityList = generator.objects(ContractEntity.class,10).collect(Collectors.toList());
        when(repository.findByPersonIdentificationNumberContaining(anyString())).thenReturn(entityList);

        List<Contract> dtoList = service.findByIdentificationNumberContaining("idNumber");

        verify(repository, atLeastOnce()).findByPersonIdentificationNumberContaining(anyString());
        assertEquals(entityList.size(), dtoList.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByIdentificationNumberContaining() {
        List<ContractEntity> entityList = new ArrayList<>();
        when(repository.findByPersonIdentificationNumberContaining(anyString())).thenReturn(entityList);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByIdentificationNumberContaining("idNumber");
        });

    }

    @Test
    void shouldReturnContractListWhenFindByFullNameContaining() {
        List<ContractEntity> entityList = generator.objects(ContractEntity.class,10).collect(Collectors.toList());
        when(repository.findByPersonFullNameContaining(anyString())).thenReturn(entityList);

        List<Contract> dtoList = service.findByFullNameContaining("idNumber");

        verify(repository, atLeastOnce()).findByPersonFullNameContaining(anyString());
        assertEquals(entityList.size(), dtoList.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByFullNameContaining() {
        List<ContractEntity> entityList = new ArrayList<>();
        when(repository.findByPersonFullNameContaining(anyString())).thenReturn(entityList);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByFullNameContaining("idNumber");
        });

    }

    @Test
    void shouldReturnCountryWhenFindByReference() {
        ContractEntity entity = generator.nextObject(ContractEntity.class);
        when(repository.findByReference(anyString())).thenReturn(Optional.of(entity));

        Optional<Contract> returnedDto = service.findByReference("1l");

        verify(repository, atLeastOnce()).findByReference(anyString());
        assertEquals(entity.getReference(), returnedDto.get().getReference());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionFindByReference() {
        when(repository.findByReference(anyString())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByReference(anyString());
        });

    }

    @Test
    void shouldReturnCountryWhenFindById() {
        ContractEntity entity = generator.nextObject(ContractEntity.class);
        when(repository.findById(anyLong())).thenReturn(Optional.of(entity));

        Optional<Contract> returnedDto = service.findById(1l);

        verify(repository, atLeastOnce()).findById(anyLong());
        assertEquals(entity.getReference(), returnedDto.get().getReference());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindById() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findById(anyLong());
        });

    }

    @Test
    void shouldReturnCreatedContractWhenCreate() {
        ContractEntity entity = generator.nextObject(ContractEntity.class);
        Contract inputDto = ContractMapper.convertToDto(entity);
        when(repository.save(any(ContractEntity.class))).thenReturn(entity);

        Contract resultDto = service.create(inputDto);

        verify(repository, atLeastOnce()).save(any(ContractEntity.class));
        assertEquals(entity.getId(), resultDto.getId());
    }

    @Test
    void shouldReturnUpdatedContractWhenUpdate() {
        ContractEntity entity = generator.nextObject(ContractEntity.class);
        Contract inputDto = ContractMapper.convertToDto(entity);
        when(repository.save(any(ContractEntity.class))).thenReturn(entity);
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        Contract resultDto = service.update(inputDto);

        verify(repository, atLeastOnce()).save(any(ContractEntity.class));
        assertEquals(entity.getId(), resultDto.getId());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenUpdate() {
        ContractEntity entity = generator.nextObject(ContractEntity.class);
        Contract inputDto = ContractMapper.convertToDto(entity);
        when(repository.existsById(anyLong())).thenReturn(Boolean.FALSE);

        assertThrows(EntityNotFoundException.class, () -> {
            service.update(inputDto);
        });

    }

    @Test
    void shouldCallRepositoryWhenDelete() {
        doNothing().when(repository).deleteById(anyLong());
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        service.delete(1l);

        verify(repository, atLeastOnce()).deleteById(anyLong());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenDelete() {
        when(repository.existsById(anyLong())).thenReturn(Boolean.FALSE);

        assertThrows(EntityNotFoundException.class, () -> {
            service.delete(anyLong());
        });

    }

    @Test
    void existsById() {
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        boolean response = service.existsById(1l);

        assertTrue(response);
    }
}