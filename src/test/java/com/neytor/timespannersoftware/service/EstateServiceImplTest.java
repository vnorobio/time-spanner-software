package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.model.mapper.EstateMapper;
import com.neytor.timespannersoftware.repository.EstateRepository;
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
public class EstateServiceImplTest {

    private final EasyRandom generator = new EasyRandom(  );

    @InjectMocks
    private EstateServiceImpl service;

    @Mock
    private EstateRepository repository;

    @BeforeEach
    public void setUp() {
        this.service = new EstateServiceImpl(repository);
    }

    @Test
    void shouldReturnCitiesListWhenFindAll() {
        List<EstateEntity> entityList = generator.objects(EstateEntity.class,10).collect(Collectors.toList());
        when(repository.findAll()).thenReturn(entityList);

        List<Estate> dtosList = service.findAll();

        verify(repository,atLeastOnce()).findAll();
        assertEquals(entityList.size(),dtosList.size());
    }

    @Test
    void shouldReturnCitiesListWhenFindByCountry() {
        Country dto = generator.nextObject(Country.class);
        List<EstateEntity> entityList = generator.objects(EstateEntity.class,10).collect(Collectors.toList());
        when(repository.findByCountry(any(CountryEntity.class))).thenReturn(entityList);

        List<Estate> dtoList = service.findByCountry(dto);

        verify(repository, atLeastOnce()).findByCountry(any(CountryEntity.class));
        assertEquals(entityList.size(), dtoList.size());
    }

    @Test
    void shouldReturnEstateWhenFindById() {
        EstateEntity entity = generator.nextObject(EstateEntity.class);
        when(repository.findById(anyLong())).thenReturn(Optional.of(entity));

        Optional<Estate> returnedDto = service.findById(1l);

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
    void shouldReturnCountryWhenFindByCode() {
        EstateEntity entity = generator.nextObject(EstateEntity.class);
        when(repository.findByCode(anyString())).thenReturn(Optional.of(entity));

        Optional<Estate> returnedDto = service.findByCode("1l");

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
    void shouldReturnCitiesListWhenFindByDescriptionContaining() {
        List<EstateEntity> entityList = generator.objects(EstateEntity.class, 10).collect(Collectors.toList());
        when(repository.findByDescriptionContaining(anyString())).thenReturn(entityList);

        List<Estate> dtoList = service.findByDescriptionContaining("1l");

        verify(repository, atLeastOnce()).findByDescriptionContaining(anyString());
        assertEquals(entityList.size(), dtoList.size());
    }

    @Test
    void shouldReturnCreatedEstateWhenCreate() {
        EstateEntity entity = generator.nextObject(EstateEntity.class);
        Estate inputDto = EstateMapper.convertToDto(entity);
        when(repository.save(any(EstateEntity.class))).thenReturn(entity);

        Estate resultDto = service.create(inputDto);

        verify(repository, atLeastOnce()).save(any(EstateEntity.class));
        assertEquals(entity.getId(), resultDto.getId());
    }

    @Test
    void shouldReturnUpdatedEstateWhenCreate() {
        EstateEntity entity = generator.nextObject(EstateEntity.class);
        Estate inputDto = EstateMapper.convertToDto(entity);
        when(repository.save(any(EstateEntity.class))).thenReturn(entity);

        Estate resultDto = service.update(inputDto);

        verify(repository, atLeastOnce()).save(any(EstateEntity.class));
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