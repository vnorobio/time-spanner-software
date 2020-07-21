package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.BusinessUnitEntity;
import com.neytor.timespannersoftware.repository.BusinessUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessUnitServiceImpl implements BusinessUnitService{

    private final BusinessUnitRepository repository;

    @Autowired
    public BusinessUnitServiceImpl(BusinessUnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BusinessUnitEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<BusinessUnitEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<BusinessUnitEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<BusinessUnitEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<BusinessUnitEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public BusinessUnitEntity create(BusinessUnitEntity BusinessUnit) {
        return repository.save(BusinessUnit);
    }

    @Override
    public BusinessUnitEntity update(BusinessUnitEntity BusinessUnit) {
        return repository.save(BusinessUnit);
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
