package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository repository;

    @Autowired
    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LocationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<LocationEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<LocationEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<LocationEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<LocationEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public LocationEntity create(LocationEntity locationEntity) {
        return repository.save(locationEntity);
    }

    @Override
    public LocationEntity update(LocationEntity locationEntity) {
        return repository.save(locationEntity);
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
