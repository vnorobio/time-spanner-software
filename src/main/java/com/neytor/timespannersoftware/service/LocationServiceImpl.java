package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.model.dto.Location;
import com.neytor.timespannersoftware.model.mapper.LocationMapper;
import com.neytor.timespannersoftware.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    public static final String NONE_ENTITY_WAS_FOUND = "None entity was found";
    public static final String NONE_ENTITY_WAS_FOUND_WITH = "None entity was found with ";
    private final LocationRepository repository;

    @Autowired
    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Location> findAll() {
        List<LocationEntity> entities = repository.findAll();
        if(entities.isEmpty()){
            throw  new EntityNotFoundException("None entity was found");
        }
        return getCollect(entities);
    }

    @Override
    public Optional<Location> findById(Long id) {
        LocationEntity entity = repository.findById(id).orElseThrow(() ->new EntityNotFoundException(NONE_ENTITY_WAS_FOUND_WITH + "id: " + id));
        return Optional.of(LocationMapper.convertToDto(entity));
    }

    @Override
    public Optional<Location> findByCode(String code) {
        LocationEntity entity = repository.findByCode(code).orElseThrow(() ->new EntityNotFoundException(NONE_ENTITY_WAS_FOUND_WITH + "code: " + code));
        return Optional.of(LocationMapper.convertToDto(entity));
    }

    @Override
    public List<Location> findByCodeContaining(String code) {
        List<LocationEntity> entities = repository.findByCodeContaining(code);
        if(entities.isEmpty()){
            throw  new EntityNotFoundException(NONE_ENTITY_WAS_FOUND);
        }
        return getCollect(entities);
    }

    private List<Location> getCollect(List<LocationEntity> entities) {
        return entities.stream().map(LocationMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<Location> findByDescriptionContaining(String description) {
        List<LocationEntity> entities = repository.findByDescriptionContaining(description);
        validateEmptyList(NONE_ENTITY_WAS_FOUND_WITH + "description",description, entities);
        return getCollect(entities);
    }

    private void validateEmptyList(String exMessage, String identifier, List<LocationEntity> entities) {
        if(entities.isEmpty()){
            throw  new EntityNotFoundException(exMessage + identifier);
        }
    }

    @Override
    public Location create(Location dto) {
        LocationEntity entity = LocationMapper.convertToEntity(dto);
        return LocationMapper.convertToDto(repository.save(entity));
    }

    @Override
    public Location update(Location dto) {
        checkEntityExistence(dto.getId());
        LocationEntity entity = LocationMapper.convertToEntity(dto);
        return LocationMapper.convertToDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        checkEntityExistence(id);

        repository.deleteById(id);
    }

    private void checkEntityExistence(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(NONE_ENTITY_WAS_FOUND_WITH + "id: " + id);
        }
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
