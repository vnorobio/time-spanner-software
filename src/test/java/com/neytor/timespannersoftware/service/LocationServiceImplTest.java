package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.model.dto.Location;
import com.neytor.timespannersoftware.model.mapper.LocationMapper;
import com.neytor.timespannersoftware.repository.LocationRepository;
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
class LocationServiceImplTest {

    private final EasyRandom generator = new EasyRandom();

    @InjectMocks
    private LocationServiceImpl service;

    @Mock
    private LocationRepository repository;

    @BeforeEach
    void setUp() {
        service = new LocationServiceImpl(repository);
    }

    @Test
    void shouldReturnLocationListWhenFindAll() {
        List<LocationEntity> entities = generator.objects(LocationEntity.class,10 ).collect(Collectors.toList());
        when(repository.findAll()).thenReturn(entities);

        List<Location> dtoList = service.findAll();

        verify(repository,atLeastOnce()).findAll();
        assertEquals(entities.size(),dtoList.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindAll() {
        List<LocationEntity> entities = Arrays.asList();
        when(repository.findAll()).thenReturn(entities);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findAll();
        });
    }

    @Test
    void shouldReturnLocationWhenFindById() {
        Location dto = generator.nextObject(Location.class);
        LocationEntity entity = LocationMapper.convertToEntity(dto);
        BDDMockito.when(repository.findById(anyLong())).thenReturn(Optional.of(entity));

        Optional<Location> responseDto = service.findById(dto.getId());

        verify(repository,atLeastOnce()).findById(anyLong());
        assertEquals(dto.getCode(), responseDto.get().getCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindById() {
        Location dto = generator.nextObject(Location.class);
        BDDMockito.when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findById(dto.getId());
        });
    }

    @Test
    void shouldReturnLocationWhenFindByCode() {
        Location dto = generator.nextObject(Location.class);
        LocationEntity entity = LocationMapper.convertToEntity(dto);
        BDDMockito.when(repository.findByCode(anyString())).thenReturn(Optional.of(entity));

        Optional<Location> responseDto = service.findByCode(dto.getCode());

        verify(repository,atLeastOnce()).findByCode(anyString());
        assertEquals(dto.getCode(), responseDto.get().getCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByCode() {
        Location dto = generator.nextObject(Location.class);
        BDDMockito.when(repository.findByCode(anyString())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByCode(dto.getCode());
        });
    }

    @Test
    void shouldReturnLocationWhenFindByCodeContaining() {
        String code = "1L";
        List<LocationEntity> entities = generator.objects(LocationEntity.class,10 ).collect(Collectors.toList());
        BDDMockito.when(repository.findByCodeContaining(anyString())).thenReturn(entities);

        List<Location> dtoList = service.findByCodeContaining(code);

        verify(repository,atLeastOnce()).findByCodeContaining(anyString());
        assertEquals(dtoList.size(), entities.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByCodeContaining() {
        List<LocationEntity> entities = Arrays.asList();
        BDDMockito.when(repository.findByCodeContaining(anyString())).thenReturn(entities);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByCodeContaining(anyString());
        });
    }

    @Test
    void shouldReturnLocationWhenFindByDescriptionContaining() {
        String description = "1L";
        List<LocationEntity> entities = generator.objects(LocationEntity.class,10 ).collect(Collectors.toList());
        BDDMockito.when(repository.findByDescriptionContaining(anyString())).thenReturn(entities);

        List<Location> dtoList = service.findByDescriptionContaining(description);

        verify(repository,atLeastOnce()).findByDescriptionContaining(anyString());
        assertEquals(dtoList.size(), entities.size());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenFindByDescriptionContaining() {
        List<LocationEntity> entities = Arrays.asList();
        BDDMockito.when(repository.findByDescriptionContaining(anyString())).thenReturn(entities);

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByDescriptionContaining(anyString());
        });
    }

    @Test
    void shouldReturnLocationWhenCreate() {
        LocationEntity entity = generator.nextObject(LocationEntity.class);
        Location inputDto = LocationMapper.convertToDto(entity);
        when(repository.save(any(LocationEntity.class))).thenReturn(entity);

        Location resultDto = service.create(inputDto);

        verify(repository, atLeastOnce()).save(any(LocationEntity.class));
        assertEquals(resultDto.getCode(),entity.getCode());
    }

    @Test
    void shouldReturnLocationWhenUpdate() {
        LocationEntity entity = generator.nextObject(LocationEntity.class);
        Location inputDto = LocationMapper.convertToDto(entity);
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);
        when(repository.save(any(LocationEntity.class))).thenReturn(entity);

        Location resultDto = service.update(inputDto);

        verify(repository, atLeastOnce()).save(any(LocationEntity.class));
        assertEquals(resultDto.getCode(),entity.getCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionWhenUpdate() {
        Location inputDto = generator.nextObject(Location.class);
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