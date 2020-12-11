package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.dto.Location;
import com.neytor.timespannersoftware.model.dto.Spot;
import com.neytor.timespannersoftware.model.mapper.SpotMapper;
import com.neytor.timespannersoftware.repository.SpotRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpotServiceImplTest {

    private final EasyRandom generator = new EasyRandom();

    @InjectMocks
    private SpotServiceImpl service;

    @Mock
    private SpotRepository repository;

    @BeforeEach
    void setUp() {
        service = new SpotServiceImpl(repository);
    }

    @Test
    void shouldReturnSpotListWhenFindAll() {
        List<SpotEntity> entities = generator.objects(SpotEntity.class,10 ).collect(Collectors.toList());
        when(repository.findAll()).thenReturn(entities);

        List<Spot> dtoList = service.findAll();

        verify(repository,atLeastOnce()).findAll();
        assertEquals(entities.size(),dtoList.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindAll() {
        List<SpotEntity> entities = Arrays.asList();
        when(repository.findAll()).thenReturn(entities);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findAll();
        });
    }

    @Test
    void shouldReturnSpotWhenFindById() {
        Spot dto = generator.nextObject(Spot.class);
        SpotEntity entity = SpotMapper.convertToEntity(dto);
        BDDMockito.when(repository.findById(anyLong())).thenReturn(Optional.of(entity));

        Optional<Spot> responseDto = service.findById(dto.getId());

        verify(repository,atLeastOnce()).findById(anyLong());
        assertEquals(dto.getCode(), responseDto.get().getCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindById() {
        Spot dto = generator.nextObject(Spot.class);
        BDDMockito.when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findById(dto.getId());
        });
    }

    @Test
    void shouldReturnSpotWhenFindByCode() {
        Spot dto = generator.nextObject(Spot.class);
        SpotEntity entity = SpotMapper.convertToEntity(dto);
        BDDMockito.when(repository.findByCode(anyString())).thenReturn(Optional.of(entity));

        Optional<Spot> responseDto = service.findByCode(dto.getCode());

        verify(repository,atLeastOnce()).findByCode(anyString());
        assertEquals(dto.getCode(), responseDto.get().getCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByCode() {
        Spot dto = generator.nextObject(Spot.class);
        BDDMockito.when(repository.findByCode(anyString())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByCode(dto.getCode());
        });
    }

    @Test
    void shouldReturnSpotWhenFindByCodeContaining() {
        String code = "1L";
        List<SpotEntity> entities = generator.objects(SpotEntity.class,10 ).collect(Collectors.toList());
        BDDMockito.when(repository.findByCodeContains(anyString())).thenReturn(entities);

        List<Spot> dtoList = service.findByCodeContains(code);

        verify(repository,atLeastOnce()).findByCodeContains(anyString());
        assertEquals(dtoList.size(), entities.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByCodeContaining() {
        List<SpotEntity> entities = Arrays.asList();
        BDDMockito.when(repository.findByCodeContains(anyString())).thenReturn(entities);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByCodeContains(anyString());
        });
    }

    @Test
    void shouldReturnSpotWhenFindByDescriptionContaining() {
        String description = "1L";
        List<SpotEntity> entities = generator.objects(SpotEntity.class,10 ).collect(Collectors.toList());
        BDDMockito.when(repository.findByDescriptionContaining(anyString())).thenReturn(entities);

        List<Spot> dtoList = service.findByDescriptionContaining(description);

        verify(repository,atLeastOnce()).findByDescriptionContaining(anyString());
        assertEquals(dtoList.size(), entities.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByDescriptionContaining() {
        List<SpotEntity> entities = Arrays.asList();
        BDDMockito.when(repository.findByDescriptionContaining(anyString())).thenReturn(entities);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByDescriptionContaining(anyString());
        });
    }

    @Test
    void shouldReturnSpotWhenFindByCity() {
        Location location = generator.nextObject(Location.class);
        City city = generator.nextObject(City.class);
        Spot dto = Spot.builder()
                .id(1L)
                .code("code")
                .description("description")
                .location(location)
                .city(city)
                .build();
        List<SpotEntity> entities = Arrays.asList(SpotMapper.convertToEntity(dto));
        BDDMockito.when(repository.findByCity(any(CityEntity.class))).thenReturn(entities);

        List<Spot> dtoList = service.findByCity(city);

        verify(repository,atLeastOnce()).findByCity(any(CityEntity.class));
        assertEquals(dtoList.size(), 1);
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByCity() {
        City city = generator.nextObject(City.class);
        List<SpotEntity> entities = Arrays.asList();
        BDDMockito.when(repository.findByCity(any(CityEntity.class))).thenReturn(entities);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByCity(city);
        });
    }

    @Test
    void shouldReturnSpotWhenFindByLocation() {
        Location location = generator.nextObject(Location.class);
        City city = generator.nextObject(City.class);
        Spot dto = Spot.builder()
                .id(1L)
                .code("code")
                .description("description")
                .location(location)
                .city(city)
                .build();
        List<SpotEntity> entities = Arrays.asList(SpotMapper.convertToEntity(dto));
        BDDMockito.when(repository.findByLocation(any(LocationEntity.class))).thenReturn(entities);

        List<Spot> dtoList = service.findByLocation(location);

        verify(repository,atLeastOnce()).findByLocation(any(LocationEntity.class));
        assertEquals(dtoList.size(), 1);
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByLocation() {
        Location location = generator.nextObject(Location.class);
        List<SpotEntity> entities = Arrays.asList();
        BDDMockito.when(repository.findByLocation(any(LocationEntity.class))).thenReturn(entities);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByLocation(location);
        });
    }

    @Test
    void shouldReturnSpotWhenCreate() {
        SpotEntity entity = generator.nextObject(SpotEntity.class);
        Spot inputDto = SpotMapper.convertToDto(entity);
        when(repository.save(any(SpotEntity.class))).thenReturn(entity);

        Spot resultDto = service.create(inputDto);

        verify(repository, atLeastOnce()).save(any(SpotEntity.class));
        assertEquals(resultDto.getCode(),entity.getCode());
    }

    @Test
    void shouldReturnSpotWhenUpdate() {
        SpotEntity entity = generator.nextObject(SpotEntity.class);
        Spot inputDto = SpotMapper.convertToDto(entity);
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);
        when(repository.save(any(SpotEntity.class))).thenReturn(entity);

        Spot resultDto = service.update(inputDto);

        verify(repository, atLeastOnce()).save(any(SpotEntity.class));
        assertEquals(resultDto.getCode(),entity.getCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenUpdate() {
        Spot inputDto = generator.nextObject(Spot.class);
        when(repository.existsById(anyLong())).thenReturn(Boolean.FALSE);

        assertThrows(EntityNotFoundException.class, () -> {
            service.update(inputDto);
        });

    }

    @Test
    void shouldCallRepositoryWhenDelete() {
        Long id = 1L;
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);
        doNothing().when(repository).deleteById(anyLong());

        service.delete(id);

        verify(repository, atLeastOnce()).deleteById(anyLong());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenDelete() {
        Long id = 1L;
        when(repository.existsById(anyLong())).thenReturn(Boolean.FALSE);
        assertThrows(EntityNotFoundException.class, () -> {
            service.delete(id);
        });
    }

    @Test
    void existsById() {
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);

        boolean response = service.existsById(1l);

        assertTrue(response);
    }
}