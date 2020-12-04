package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.dto.Person;
import com.neytor.timespannersoftware.model.mapper.PersonMapper;
import com.neytor.timespannersoftware.repository.PersonRepository;
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
public class PersonServiceImplTest {

    private final EasyRandom generator = new EasyRandom(  );

    @InjectMocks
    PersonServiceImpl service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUp() {
        this.service = new PersonServiceImpl(repository);
    }

    @Test
    void findAllShouldReturnPersonsList() {
        List<PersonEntity> entities = generator.objects( PersonEntity.class, 10 ).collect( Collectors.toList());
        when(repository.findAll()).thenReturn(entities);

        List<Person> dtos = service.findAll();

        verify(repository,atLeastOnce()).findAll();
        assertEquals(entities.size(), dtos.size());
    }

    @Test
    void findByFullNameContainingShouldReturnPersonsList() {
        List<PersonEntity> entities = generator.objects( PersonEntity.class, 10 ).collect( Collectors.toList());
        when(repository.findByFullNameContaining(anyString())).thenReturn(entities);

        List<Person> dtos = service.findByFullNameContaining(anyString());

        verify(repository,atLeastOnce()).findByFullNameContaining(anyString());
        assertEquals(entities.size(), dtos.size());
    }

    @Test
    void findByIdentificationNumberContainingShouldReturnPersonsList() {
        List<PersonEntity> entities = generator.objects( PersonEntity.class, 10 ).collect( Collectors.toList());
        when(repository.findByIdentificationNumberContaining(anyString())).thenReturn(entities);

        List<Person> dtos = service.findByIdentificationNumberContaining(anyString());

        verify(repository,atLeastOnce()).findByIdentificationNumberContaining(anyString());
        assertEquals(entities.size(), dtos.size());
    }

    @Test
    void findByIdShouldReturnResult() {
        PersonEntity entity = generator.nextObject( PersonEntity.class );
        when(repository.findById(anyLong())).thenReturn(Optional.of(entity));

        Optional<Person> dto = service.findById(anyLong());

        verify(repository,atLeastOnce()).findById(anyLong());
        assertEquals(entity.getFullName(), dto.get().getFullName());
    }

    @Test
    void findByIdShouldThrowEntityNotFoundException() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            service.findById(anyLong());
        });

    }

    @Test
    void createShouldReturnPersonInformation() {
        PersonEntity entity = generator.nextObject( PersonEntity.class );

        when(repository.save(any())).thenReturn(entity);

        Person dto = service.create(PersonMapper.convertToDto(entity));

        verify(repository,atLeastOnce()).save(any());
        assertEquals(entity.getFullName(), dto.getFullName());
    }

    @Test
    void update() {
        PersonEntity entity = generator.nextObject( PersonEntity.class );

        when(repository.save(any())).thenReturn(entity);

        Person dto = service.update(PersonMapper.convertToDto(entity));

        verify(repository,atLeastOnce()).save(any());
        assertEquals(entity.getFullName(), dto.getFullName());
    }

    @Test
    void deleteShouldCallRepositoryDeleteById() {
        doNothing().when(repository).deleteById(anyLong());

        service.delete(anyLong());

        verify(repository,atLeastOnce()).deleteById(anyLong());
    }

    @Test
    void existsById() {
        when(repository.existsById(anyLong())).thenReturn(Boolean.TRUE);
        boolean response = service.existsById(anyLong());
        assertTrue(response);
    }
}