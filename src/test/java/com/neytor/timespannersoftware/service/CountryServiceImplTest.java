package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.mapper.CountryMapper;
import com.neytor.timespannersoftware.repository.CountryRepository;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CountryServiceImplTest {

    private final EasyRandom generator = new EasyRandom(  );

    @InjectMocks
    private CountryServiceImpl service;

    @Mock
    private CountryRepository repository;

    @BeforeEach
    public void setUp() {
        this.service = new CountryServiceImpl(repository);
    }

    @Test
    void shouldReturnCitiesListWhenFindAll() {
        List<CountryEntity> entityList = generator.objects(CountryEntity.class,10).collect(Collectors.toList());
        when(repository.findAll()).thenReturn(entityList);

        List<Country> dtosList = service.findAll();

        verify(repository,atLeastOnce()).findAll();
        assertEquals(entityList.size(),dtosList.size());
    }


    @Test
    void shouldReturnCountryWhenFindById() {
        CountryEntity entity = generator.nextObject(CountryEntity.class);
        when(repository.findById(anyLong())).thenReturn(Optional.of(entity));

        Optional<Country> returnedDto = service.findById(1l);

        verify(repository, atLeastOnce()).findById(anyLong());
        assertEquals(entity.getNumericCode(), returnedDto.get().getNumericCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionFindById() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findById(anyLong());
        });

    }

    @Test
    void shouldReturnCountryWhenFindByNumericCode() {
        CountryEntity entity = generator.nextObject(CountryEntity.class);
        when(repository.findByNumericCode(anyInt())).thenReturn(Optional.of(entity));

        Optional<Country> returnedDto = service.findByNumericCode(entity.getNumericCode());

        verify(repository, atLeastOnce()).findByNumericCode(anyInt());
        assertEquals(entity.getNumericCode(), returnedDto.get().getNumericCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionFindByNumericCode() {
        when(repository.findByNumericCode(anyInt())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByNumericCode(anyInt());
        });

    }

    @Test
    void shouldReturnCountryWhenFindByAlpha2Code() {
        CountryEntity entity = generator.nextObject(CountryEntity.class);
        when(repository.findByAlpha2Code(anyString())).thenReturn(Optional.of(entity));

        Optional<Country> returnedDto = service.findByAlpha2Code(entity.getAlpha2Code());

        verify(repository, atLeastOnce()).findByAlpha2Code(anyString());
        assertEquals(entity.getNumericCode(), returnedDto.get().getNumericCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionFindByAlpha2Code() {
        when(repository.findByAlpha2Code(anyString())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByAlpha2Code(anyString());
        });

    }

    @Test
    void shouldReturnCountryWhenFindByAlpha3Code() {
        CountryEntity entity = generator.nextObject(CountryEntity.class);
        when(repository.findByAlpha3Code(anyString())).thenReturn(Optional.of(entity));

        Optional<Country> returnedDto = service.findByAlpha3Code(entity.getAlpha3Code());

        verify(repository, atLeastOnce()).findByAlpha3Code(anyString());
        assertEquals(entity.getNumericCode(), returnedDto.get().getNumericCode());
    }

    @Test
    void shouldYieldWhenEntityNotFoundExceptionFindByAlpha3Code() {
        when(repository.findByAlpha3Code(anyString())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findByAlpha3Code(anyString());
        });

    }

    @Test
    void shouldReturnCitiesListWhenFindByDescriptionContaining() {
        List<CountryEntity> entityList = generator.objects(CountryEntity.class, 10).collect(Collectors.toList());
        when(repository.findByNameContaining(anyString())).thenReturn(entityList);

        List<Country> dtoList = service.findByName("1l");

        verify(repository, atLeastOnce()).findByNameContaining(anyString());
        assertEquals(entityList.size(), dtoList.size());
    }

    @Test
    void shouldReturnCreatedCountryWhenCreate() {
        CountryEntity entity = generator.nextObject(CountryEntity.class);
        Country inputDto = CountryMapper.convertToDto(entity);
        when(repository.save(any(CountryEntity.class))).thenReturn(entity);

        Country resultDto = service.create(inputDto);

        verify(repository, atLeastOnce()).save(any(CountryEntity.class));
        assertEquals(entity.getId(), resultDto.getId());
    }

    @Test
    void shouldReturnUpdatedCountryWhenCreate() {
        CountryEntity entity = generator.nextObject(CountryEntity.class);
        Country inputDto = CountryMapper.convertToDto(entity);
        when(repository.save(any(CountryEntity.class))).thenReturn(entity);

        Country resultDto = service.update(inputDto);

        verify(repository, atLeastOnce()).save(any(CountryEntity.class));
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