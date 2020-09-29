package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ConceptEntity;
import com.neytor.timespannersoftware.repository.ConceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConceptServiceImpl implements ConceptService{
    private final ConceptRepository repository;

    @Autowired
    public ConceptServiceImpl(ConceptRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ConceptEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ConceptEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<ConceptEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public ConceptEntity create(ConceptEntity conceptEntity) {
        return repository.save(conceptEntity);
    }

    @Override
    public ConceptEntity update(ConceptEntity conceptEntity) {
        return repository.save(conceptEntity);
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
