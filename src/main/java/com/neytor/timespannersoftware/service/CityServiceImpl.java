package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.City;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.model.mapper.CityMapper;
import com.neytor.timespannersoftware.model.mapper.CountryMapper;
import com.neytor.timespannersoftware.model.mapper.EstateMapper;
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
        List<CityEntity> entities = repository.findAll( );
        return entities.stream().map( CityMapper::convertToDto ).collect( Collectors.toList() );
    }

    @Override
    public List<City> findByEstate(Estate dto) {
        EstateEntity entity = EstateMapper.convertToEntity(dto);
        return repository.findByEstate(entity).stream()
                .map( City -> CityMapper.convertToDto( City ) ).collect( Collectors.toList() );
    }

    @Override
    public List<City> findByCountry(Country dto) {
        CountryEntity entity = CountryMapper.convertToEntity(dto);
        return repository.findByCountry(entity).stream()
                .map( City -> CityMapper.convertToDto( City ) ).collect( Collectors.toList() );
    }

    @Override
    public Optional<City> findById(Long id) {
        CityEntity entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el id: " + id));
        return  Optional.of( CityMapper.convertToDto( entity ) );
    }

    @Override
    public Optional<City> findByCode(String code) {
        CityEntity entity = repository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el code: " + code));
        return  Optional.of( CityMapper.convertToDto( entity ) );
    }

    @Override
    public List<City> findByDescriptionContaining(String description) {
        List<CityEntity> cityList = repository.findByDescriptionContaining(description);
        return cityList.stream()
                .map( City -> CityMapper.convertToDto( City ) )
                .collect( Collectors.toList() );
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
