package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.IdentificationTypeEntity;
import com.neytor.timespannersoftware.repository.IdentificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentificationTypeServiceImpl implements IdentificationTypeService{

    private final IdentificationTypeRepository repository;

    @Autowired
    public IdentificationTypeServiceImpl(IdentificationTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IdentificationTypeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<IdentificationTypeEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<IdentificationTypeEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public Optional<IdentificationTypeEntity> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public Optional<IdentificationTypeEntity> findByShortenedForm(String shortenedForm) {
        return repository.findByShortenedForm(shortenedForm);
    }

    @Override
    public IdentificationTypeEntity create(IdentificationTypeEntity identificationType) {
        return repository.save(identificationType);
    }

    @Override
    public IdentificationTypeEntity update(IdentificationTypeEntity identificationType) {
        return repository.save(identificationType);
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
