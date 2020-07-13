package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PersonEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PersonEntity> findByFullNameContaining(String fullName) {
        return repository.findByFullNameContaining(fullName);
    }

    @Override
    public Optional<PersonEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PersonEntity create(PersonEntity person) {
        return repository.save(person);
    }

    @Override
    public PersonEntity update(PersonEntity person) {
        return repository.save(person);
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
