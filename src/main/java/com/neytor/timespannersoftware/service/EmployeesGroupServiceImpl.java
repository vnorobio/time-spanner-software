package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.EmployeesGroupEntity;
import com.neytor.timespannersoftware.repository.EmployeesGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesGroupServiceImpl implements EmployeesGroupService{

    private final EmployeesGroupRepository repository;

    @Autowired
    public EmployeesGroupServiceImpl(EmployeesGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeesGroupEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<EmployeesGroupEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<EmployeesGroupEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<EmployeesGroupEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<EmployeesGroupEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public EmployeesGroupEntity create(EmployeesGroupEntity employeesGroupEntity) {
        return repository.save(employeesGroupEntity);
    }

    @Override
    public EmployeesGroupEntity update(EmployeesGroupEntity employeesGroupEntity) {
        return repository.save(employeesGroupEntity);
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
