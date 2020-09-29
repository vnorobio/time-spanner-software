package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.TerritorialDivisionEntity;
import com.neytor.timespannersoftware.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpotServiceImpl implements SpotService{


    private final SpotRepository repository;

    @Autowired
    public SpotServiceImpl(SpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SpotEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SpotEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<SpotEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<SpotEntity> findByCodeContains(String code) {
        return repository.findByCodeContains(code);
    }

    @Override
    public List<SpotEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public List<SpotEntity> findByLocation(LocationEntity entity) {
        return repository.findByLocation(entity);
    }

    @Override
    public List<SpotEntity> findByTerritorialDivision(TerritorialDivisionEntity entity) {
        return repository.findByTerritorialDivision(entity);
    }

    @Override
    public SpotEntity create(SpotEntity entity) {
        return repository.save(entity);
    }

    @Override
    public SpotEntity update(SpotEntity entity) {
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
