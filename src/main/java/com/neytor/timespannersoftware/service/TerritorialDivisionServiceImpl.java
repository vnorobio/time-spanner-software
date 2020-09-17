package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.TerritorialDivisionEntity;
import com.neytor.timespannersoftware.repository.TerritorialDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerritorialDivisionServiceImpl implements TerritorialDivisionService {

    private final TerritorialDivisionRepository repository;

    @Autowired
    public TerritorialDivisionServiceImpl(TerritorialDivisionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TerritorialDivisionEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TerritorialDivisionEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<TerritorialDivisionEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<TerritorialDivisionEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<TerritorialDivisionEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public TerritorialDivisionEntity create(TerritorialDivisionEntity businessUnit) {
        return repository.save(businessUnit);
    }

    @Override
    public TerritorialDivisionEntity update(TerritorialDivisionEntity businessUnit) {
        return repository.save(businessUnit);
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
