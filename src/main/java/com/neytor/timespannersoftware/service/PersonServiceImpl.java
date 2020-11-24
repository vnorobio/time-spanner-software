package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.dto.Person;
import com.neytor.timespannersoftware.model.mapper.PersonMapper;
import com.neytor.timespannersoftware.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> findAll() {
        List<PersonEntity> entities = repository.findAll();
        return entities.stream().map(entity -> PersonMapper.convertToDto(entity)).collect(Collectors.toList());
    }

    @Override
    public List<Person > findByFullNameContaining(String fullName) {
        List<PersonEntity> entities = repository.findByFullNameContaining(fullName);
        return entities.stream().map(entity -> PersonMapper.convertToDto(entity)).collect(Collectors.toList());
    }

    @Override
    public List<Person > findByIdentificationNumberContaining(String identification) {
        List<PersonEntity> entities = repository.findByIdentificationNumberContaining(identification);
        return entities.stream().map(entity -> PersonMapper.convertToDto(entity)).collect(Collectors.toList());
    }

    @Override
    public Optional<Person > findById(Long id) {
        PersonEntity entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el id: " + id));
        Person dto = PersonMapper.convertToDto(entity);
        return Optional.of(dto);
    }

    @Override
    public Person  create(Person  person) {
        PersonEntity entity = repository.save(PersonMapper.convertToEntity(person));
        Person dto = PersonMapper.convertToDto(entity);
        return dto;
    }

    @Override
    public Person  update(Person  person) {
        PersonEntity entity = repository.save(PersonMapper.convertToEntity(person));
        Person dto = PersonMapper.convertToDto(entity);
        return dto;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
