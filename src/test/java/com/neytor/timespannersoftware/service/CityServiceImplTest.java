package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.model.mapper.CityMapper;
import com.neytor.timespannersoftware.repository.CityRepository;
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
public class CityServiceImplTest {

    private final EasyRandom generator = new EasyRandom(  );

    @InjectMocks
    private CityServiceImpl service;

    @Mock
    private CityRepository repository;

    @BeforeEach
    public void setUp() {
        this.service = new CityServiceImpl(repository);
    }

    @Test
    void shouldReturnCitiesListWhenFindAll() {
        List<CityEntity> entityList = generator.objects(CityEntity.class,10).collect(Collectors.toList());
        when(repository.findAll()).thenReturn(entityList);

        List<City> dtosList = service.findAll();

        verify(repository,atLeastOnce()).findAll();
        assertEquals(entityList.size(),dtosList.size());
    }

    @Test
    void shouldReturnCitiesListWhenFindByEstate() {
        Estate dto = generator.nextObject(Estate.class);
        List<CityEntity> entityList = generator.objects(CityEntity.class,10).collect(Collectors.toList());
        when(repository.findByEstate(any(EstateEntity.class))).thenReturn(entityList);

        List<City> dtoList = service.findByEstate(dto);

        verify(repository, atLeastOnce()).findByEstate(any(EstateEntity.class));
        assertEquals(entityList.size(), dtoList.size());
    }

    @Test
    void shouldReturnCitiesListWhenFindByCountry() {
        Country dto = generator.nextObject(Country.class);
        List<CityEntity> entityList = generator.objects(CityEntity.class,10).collect(Collectors.toList());
        when(repository.findByCountry(any(CountryEntity.class))).thenReturn(entityList);

        List<City> dtoList = service.findByCountry(dto);

        verify(repository, atLeastOnce()).findByCountry(any(CountryEntity.class));
        assertEquals(entityList.size(), dtoList.size());
    }

    @Test
    void shouldReturnCountryWhenFindById() {
        CityEntity entity = generator.nextObject(CityEntity.class);
        when(repository.findById(anyLong())).thenReturn(Optional.of(entity));

        Optional<City> returnedDto = service.findById(1l);

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
        CityEntity entity = generator.nextObject(CityEntity.class);
        when(repository.findByCode(anyString())).thenReturn(Optional.of(entity));

        Optional<City> returnedDto = service.findByCode("1l");

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
        List<CityEntity> entityList = generator.objects(CityEntity.class, 10).collect(Collectors.toList());
        when(repository.findByDescriptionContaining(anyString())).thenReturn(entityList);

        List<City> dtoList = service.findByDescriptionContaining("1l");

        verify(repository, atLeastOnce()).findByDescriptionContaining(anyString());
        assertEquals(entityList.size(), dtoList.size());
    }

    @Test
    void shouldReturnCreatedCityWhenCreate() {
        CityEntity entity = generator.nextObject(CityEntity.class);
        City inputDto = CityMapper.convertToDto(entity);
        when(repository.save(any(CityEntity.class))).thenReturn(entity);

        City resultDto = service.create(inputDto);

        verify(repository, atLeastOnce()).save(any(CityEntity.class));
        assertEquals(entity.getId(), resultDto.getId());
    }

    @Test
    void shouldReturnUpdatedCityWhenCreate() {
        CityEntity entity = generator.nextObject(CityEntity.class);
        City inputDto = CityMapper.convertToDto(entity);
        when(repository.save(any(CityEntity.class))).thenReturn(entity);

        City resultDto = service.update(inputDto);

        verify(repository, atLeastOnce()).save(any(CityEntity.class));
        assertEquals(entity.getId(), resultDto.getId());
    }

    @Test
    void delete() {
        doNothing().when(repository).deleteById(anyLong());

        service.delete(1l);

        verify(repository, atLeastOnce()).deleteById(anyLong());
    }

    @Test
    void existsById() {
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        boolean response = service.existsById(1l);

        assertTrue(response);
    }
}