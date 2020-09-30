package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CityEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<CityEntity> findByEstate(EstateEntity entity) {
        return repository.findByEstate(entity);
    }

    @Override
    public List<CityEntity> findByCountry(CountryEntity entity) {
        return repository.findByCountry(entity);
    }

    @Override
    public Optional<CityEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<CityEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<CityEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<CityEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public CityEntity create(CityEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CityEntity update(CityEntity entity) {
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
