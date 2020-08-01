package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CompanyEntity;
import com.neytor.timespannersoftware.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CompanyEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<CompanyEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public Optional<CompanyEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<CompanyEntity> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public CompanyEntity create(CompanyEntity company) {
        return repository.save(company);
    }

    @Override
    public CompanyEntity update(CompanyEntity company) {
        return repository.save(company);
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
