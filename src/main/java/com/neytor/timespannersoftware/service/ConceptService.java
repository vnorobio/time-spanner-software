package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ConceptEntity;

import java.util.List;
import java.util.Optional;

public interface ConceptService {
    List<ConceptEntity> findAll();

    Optional<ConceptEntity> findById(Long id);

    Optional<ConceptEntity> findByCode(String code);

    List<ConceptEntity> findByDescriptionContaining(String description);

    ConceptEntity create(ConceptEntity conceptEntity);

    ConceptEntity update(ConceptEntity conceptEntity);

    void delete(Long id);

    Boolean existsById(Long id);
}
