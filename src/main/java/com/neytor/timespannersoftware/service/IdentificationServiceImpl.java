package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.IdentificationEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.repository.IdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentificationServiceImpl implements  IdentificationService{

    private final IdentificationRepository repository;

    @Autowired
    public IdentificationServiceImpl(IdentificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IdentificationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PersonEntity> findByIdentificationNumberContaining(String identificationNumber) {
        return repository.findByIdentificationNumberContaining(identificationNumber);
    }

    @Override
    public Optional<IdentificationEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<IdentificationEntity> findByIdentificationNumber(String identificationNumber) {
        return repository.findByIdentificationNumber(identificationNumber);
    }

    @Override
    public IdentificationEntity create(IdentificationEntity identification) {
        return repository.save(identification);
    }

    @Override
    public IdentificationEntity update(IdentificationEntity identification) {
        return repository.save(identification);
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
