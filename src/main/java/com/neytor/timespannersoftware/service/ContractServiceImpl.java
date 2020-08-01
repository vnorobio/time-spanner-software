package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository repository;

    @Autowired
    public ContractServiceImpl(ContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ContractEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ContractEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ContractEntity> findByReference(String reference) {
        return repository.findByReference(reference);
    }

    @Override
    public List<ContractEntity> findByIdentificationNumber(String identificationNumber) {
        return repository.findByPersonIdentificationNumber(identificationNumber);
    }

    @Override
    public List<ContractEntity> findByIdentificationNumberContaining(String identificationNumber) {
        return repository.findByPersonIdentificationNumberContaining(identificationNumber);
    }

    @Override
    public List<ContractEntity> findByFullNameContaining(String fullName) {
        return repository.findByPersonFullNameContaining(fullName);
    }

    @Override
    public ContractEntity create(ContractEntity contractEntity) {
        return repository.save(contractEntity);
    }

    @Override
    public ContractEntity update(ContractEntity contractEntity) {
        return repository.save(contractEntity);
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
