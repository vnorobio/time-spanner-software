package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<PersonEntity> findAll();

    List<PersonEntity>  findByFullNameContaining(String fullName);

    Optional<PersonEntity> findById(Long id);

    PersonEntity create(PersonEntity person);

    PersonEntity update(PersonEntity person);

    void delete(Long id);

    Boolean existsById(Long id);
}
