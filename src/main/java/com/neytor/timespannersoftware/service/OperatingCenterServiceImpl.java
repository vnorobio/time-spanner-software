package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.OperatingCenterEntity;
import com.neytor.timespannersoftware.repository.OperatingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperatingCenterServiceImpl implements OperatingCenterService{

    private final OperatingCenterRepository repository;

    @Autowired
    public OperatingCenterServiceImpl(OperatingCenterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OperatingCenterEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<OperatingCenterEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<OperatingCenterEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<OperatingCenterEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<OperatingCenterEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public OperatingCenterEntity create(OperatingCenterEntity operatingCenter) {
        return repository.save(operatingCenter);
    }

    @Override
    public OperatingCenterEntity update(OperatingCenterEntity operatingCenter) {
        return repository.save(operatingCenter);
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
