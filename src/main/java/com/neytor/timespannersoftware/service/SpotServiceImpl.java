package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.dto.Location;
import com.neytor.timespannersoftware.model.dto.Spot;
import com.neytor.timespannersoftware.model.mapper.CityMapper;
import com.neytor.timespannersoftware.model.mapper.LocationMapper;
import com.neytor.timespannersoftware.model.mapper.SpotMapper;
import com.neytor.timespannersoftware.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpotServiceImpl implements SpotService {

    public static final String NONE_ENTITY_WAS_FOUND = "None entity was found";
    public static final String NONE_ENTITY_WAS_FOUND_WITH = "None entity was found with ";

    private final SpotRepository repository;

    @Autowired
    public SpotServiceImpl(SpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Spot> findAll() {
        List<SpotEntity> entities = repository.findAll();
        validateEmptyList(NONE_ENTITY_WAS_FOUND, "", entities);
        return getCollect(entities);
    }

    @Override
    public Optional<Spot> findById(Long id) {
        SpotEntity entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(NONE_ENTITY_WAS_FOUND_WITH + "id: " + id));
        return Optional.of(SpotMapper.convertToDto(entity));
    }

    @Override
    public Optional<Spot> findByCode(String code) {
        SpotEntity entity = repository.findByCode(code).orElseThrow(() -> new EntityNotFoundException(NONE_ENTITY_WAS_FOUND_WITH + "code: " + code));
        return Optional.of(SpotMapper.convertToDto(entity));
    }

    @Override
    public List<Spot> findByCodeContains(String code) {
        List<SpotEntity> entities = repository.findByCodeContains(code);
        validateEmptyList(NONE_ENTITY_WAS_FOUND_WITH + "code: ", code, entities);
        return getCollect(entities);
    }

    @Override
    public List<Spot> findByDescriptionContaining(String description) {
        List<SpotEntity> entities = repository.findByDescriptionContaining(description);
        validateEmptyList(NONE_ENTITY_WAS_FOUND_WITH + "description: ", description, entities);
        return getCollect(entities);
    }

    @Override
    public List<Spot> findByLocation(Location dto) {
        LocationEntity entity = LocationMapper.convertToEntity(dto);
        List<SpotEntity> entities = repository.findByLocation(entity);
        validateEmptyList(NONE_ENTITY_WAS_FOUND_WITH + "location: ", dto.getCode(), entities);
        return getCollect(entities);

    }

    @Override
    public List<Spot> findByCity(City dto) {
        CityEntity entity = CityMapper.convertToEntity(dto);
        List<SpotEntity> entities = repository.findByCity(entity);
        validateEmptyList(NONE_ENTITY_WAS_FOUND_WITH + "city: ", dto.getCode(), entities);
        return getCollect(entities);
    }

    @Override
    public Spot create(Spot dto) {
        SpotEntity entity = SpotMapper.convertToEntity(dto);
        return SpotMapper.convertToDto(repository.save(entity));
    }

    @Override
    public Spot update(Spot dto) {
        checkEntityExistence(dto.getId());
        SpotEntity entity = SpotMapper.convertToEntity(dto);
        return SpotMapper.convertToDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        checkEntityExistence(id);
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }

    private void validateEmptyList(String exMessage, String identifier, List<SpotEntity> entities) {
        if (entities.isEmpty()) {
            throw new EntityNotFoundException(exMessage + identifier);
        }
    }

    private List<Spot> getCollect(List<SpotEntity> entities) {
        return entities.stream().map(SpotMapper::convertToDto).collect(Collectors.toList());
    }

    private void checkEntityExistence(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(NONE_ENTITY_WAS_FOUND_WITH + "id: " + id);
        }
    }
}
