package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person > findAll();

    List<Person >  findByFullNameContaining(String fullName);

    List<Person > findByIdentificationNumberContaining(String identification);

    Optional<Person> findById(Long id);

    Person  create(Person  person);

    Person  update(Person  person);

    void delete(Long id);

    Boolean existsById(Long id);
}
