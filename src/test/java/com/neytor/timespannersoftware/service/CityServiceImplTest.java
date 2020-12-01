package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.repository.CityRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    void ShouldReturnCitiesListWhenFindAll() {
        List<CityEntity> entities = generator.objects(CityEntity.class,10).collect(Collectors.toList());
        when(repository.findAll()).thenReturn(entities);

        List<City> dtosList = service.findAll();

        verify(repository,atLeastOnce()).findAll();
        assertEquals(entities.size(),dtosList.size());
    }

    @Test
    void findByEstate() {
    }

    @Test
    void findByCountry() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByCode() {
    }

    @Test
    void findByCodeContaining() {
    }

    @Test
    void findByDescriptionContaining() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void existsById() {
    }
}