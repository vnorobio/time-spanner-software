package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CostsCenterEntity;
import com.neytor.timespannersoftware.repository.CostsCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostsCenterServiceImpl implements CostsCenterService{

    private final CostsCenterRepository repository;

    @Autowired
    public CostsCenterServiceImpl(CostsCenterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CostsCenterEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CostsCenterEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<CostsCenterEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<CostsCenterEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<CostsCenterEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public CostsCenterEntity create(CostsCenterEntity costsCenter) {
        return repository.save(costsCenter);
    }

    @Override
    public CostsCenterEntity update(CostsCenterEntity costsCenter) {
        return repository.save(costsCenter);
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
