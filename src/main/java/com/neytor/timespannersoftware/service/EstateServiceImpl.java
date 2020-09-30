package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstateServiceImpl implements EstateService {

    private final EstateRepository repository;

    @Autowired
    public EstateServiceImpl(EstateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstateEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<EstateEntity> findByCountry(CountryEntity entity) {
        return repository.findByCountry(entity);
    }

    @Override
    public Optional<EstateEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<EstateEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<EstateEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<EstateEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public EstateEntity create(EstateEntity entity) {
        return repository.save(entity);
    }

    @Override
    public EstateEntity update(EstateEntity entity) {
        return repository.save(entity);
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
