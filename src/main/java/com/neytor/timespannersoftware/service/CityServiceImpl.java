package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.mapper.CityMapper;
import com.neytor.timespannersoftware.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> findAll() {
        return repository.findAll().stream()
                .map( City -> CityMapper.convertToDto( City ) ).collect( Collectors.toList() );
    }

    @Override
    public List<City> findByEstate(EstateEntity entity) {
        return repository.findByEstate(entity).stream()
                .map( City -> CityMapper.convertToDto( City ) ).collect( Collectors.toList() );
    }

    @Override
    public List<City> findByCountry(CountryEntity entity) {
        return repository.findByCountry(entity).stream()
                .map( City -> CityMapper.convertToDto( City ) ).collect( Collectors.toList() );
    }

    @Override
    public Optional<City> findById(Long id) {
        return repository.findById(id).flatMap( cityEntity -> Optional.of( CityMapper.convertToDto( cityEntity ) ) );
    }

    @Override
    public Optional<City> findByCode(String code) {
        return repository.findByCode(code).flatMap( cityEntity -> Optional.of( CityMapper.convertToDto( cityEntity ) ) );
    }

    @Override
    public List<City> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code).stream()
                .map( City -> CityMapper.convertToDto( City ) ).collect( Collectors.toList() );
    }

    @Override
    public List<City> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description).stream()
                .map( City -> CityMapper.convertToDto( City ) ).collect( Collectors.toList() );
    }

    @Override
    public City create( City entity) {
        CityEntity cityEntity = this.repository.save(CityMapper.convertToEntity( entity ));
        return CityMapper.convertToDto(cityEntity);
    }

    @Override
    public City update(City entity) {
        CityEntity cityEntity = this.repository.save(CityMapper.convertToEntity( entity ));
        return CityMapper.convertToDto(cityEntity);
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
