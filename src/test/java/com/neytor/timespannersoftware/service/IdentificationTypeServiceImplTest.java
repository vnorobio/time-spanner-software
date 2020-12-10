package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.IdentificationTypeEntity;
import com.neytor.timespannersoftware.model.dto.IdentificationType;
import com.neytor.timespannersoftware.model.mapper.IdentificationTypeMapper;
import com.neytor.timespannersoftware.repository.IdentificationTypeRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
public class IdentificationTypeServiceImplTest {

    private final EasyRandom generator = new EasyRandom(  );

    @InjectMocks
    private IdentificationTypeServiceImpl service;

    @Mock
    private IdentificationTypeRepository repository;

    @BeforeEach
    public void setUp() {
        this.service = new IdentificationTypeServiceImpl(repository);
    }

    @Test
    void shouldReturnCitiesListWhenFindAll() {
        List<IdentificationTypeEntity> entityList = generator.objects(IdentificationTypeEntity.class,10).collect(Collectors.toList());
        when(repository.findAll()).thenReturn(entityList);

        List<IdentificationType> dtosList = service.findAll();

        verify(repository,atLeastOnce()).findAll();
        assertEquals(entityList.size(),dtosList.size());
    }

    @Test
    void shouldReturnIdentificationTypeWhenFindById() {
        IdentificationTypeEntity entity = generator.nextObject(IdentificationTypeEntity.class);
        when(repository.findById(anyLong())).thenReturn(Optional.of(entity));

        Optional<IdentificationType> returnedDto = service.findById(1l);

        verify(repository, atLeastOnce()).findById(anyLong());
        assertEquals(entity.getCode(), returnedDto.get().getCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionFindById() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findById(anyLong());
        });

    }

    @Test
    void shouldReturnCountryWhenFindByShortenedForm() {
        IdentificationTypeEntity entity = generator.nextObject(IdentificationTypeEntity.class);
        when(repository.findByShortenedForm(anyString())).thenReturn(Optional.of(entity));

        Optional<IdentificationType> returnedDto = service.findByShortenedForm("1l");

        verify(repository, atLeastOnce()).findByShortenedForm(anyString());
        assertEquals(entity.getCode(), returnedDto.get().getCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionFindByShortenedForm() {
        when(repository.findByShortenedForm(anyString())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByShortenedForm(anyString());
        });

    }

    @Test
    void shouldReturnCountryWhenFindByCode() {
        IdentificationTypeEntity entity = generator.nextObject(IdentificationTypeEntity.class);
        when(repository.findByCode(anyString())).thenReturn(Optional.of(entity));

        Optional<IdentificationType> returnedDto = service.findByCode("1l");

        verify(repository, atLeastOnce()).findByCode(anyString());
        assertEquals(entity.getCode(), returnedDto.get().getCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionFindByCode() {
        when(repository.findByCode(anyString())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByCode(anyString());
        });

    }

    @Test
    void shouldReturnCreatedIdentificationTypeWhenCreate() {
        IdentificationTypeEntity entity = generator.nextObject(IdentificationTypeEntity.class);
        IdentificationType inputDto = IdentificationTypeMapper.convertToDto(entity);
        when(repository.save(any(IdentificationTypeEntity.class))).thenReturn(entity);

        IdentificationType resultDto = service.create(inputDto);

        verify(repository, atLeastOnce()).save(any(IdentificationTypeEntity.class));
        assertEquals(entity.getId(), resultDto.getId());
    }

    @Test
    void shouldReturnUpdatedIdentificationTypeWhenCreate() {
        IdentificationTypeEntity entity = generator.nextObject(IdentificationTypeEntity.class);
        IdentificationType inputDto = IdentificationTypeMapper.convertToDto(entity);
        when(repository.save(any(IdentificationTypeEntity.class))).thenReturn(entity);

        IdentificationType resultDto = service.update(inputDto);

        verify(repository, atLeastOnce()).save(any(IdentificationTypeEntity.class));
        assertEquals(entity.getId(), resultDto.getId());
    }

    @Test
    void shouldCallRepositoryWhenDeleteById() {
        doNothing().when(repository).deleteById(anyLong());

        service.delete(1l);

        verify(repository, atLeastOnce()).deleteById(anyLong());
    }

    @Test
    void shouldCallRepositoryWhenExistsById() {
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        boolean response = service.existsById(1l);

        assertTrue(response);
        verify(repository, atLeastOnce()).existsById(anyLong());
    }
}