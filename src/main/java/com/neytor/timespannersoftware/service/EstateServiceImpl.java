package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.dto.Estate;
import com.neytor.timespannersoftware.model.mapper.CountryMapper;
import com.neytor.timespannersoftware.model.mapper.EstateMapper;
import com.neytor.timespannersoftware.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EstateServiceImpl implements EstateService {

    private final EstateRepository repository;

    @Autowired
    public EstateServiceImpl(EstateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estate> findAll() {
        List<EstateEntity> list = repository.findAll();
        return  EstateMapper.convertToDtoList(  list);
    }

    @Override
    public List< Estate > findByCountry( Country dto) {
        return  EstateMapper.convertToDtoList( repository.findByCountry( CountryMapper.convertToEntity( dto ) ) );

    }

    @Override
    public Optional<Estate> findById(Long id) {
        Optional<EstateEntity> optEntity = repository.findById(id);
        Optional<Estate> optEstate =  optEntity.isPresent()
                ? Optional.ofNullable( EstateMapper.convertToDto( optEntity.get( ) ) )
                : Optional.empty();
        return optEstate;
    }

    @Override
    public Optional<Estate> findByCode(String code) {
        Optional<EstateEntity> optEntity = repository.findByCode(code);
        Optional<Estate> optEstate =  optEntity.isPresent()
                ? Optional.ofNullable( EstateMapper.convertToDto( optEntity.get( ) ) )
                : Optional.empty();
        return optEstate;
    }

    @Override
    public List<Estate> findByCodeContaining(String code) {
        return  EstateMapper.convertToDtoList( repository.findByCodeContaining(code));
    }

    @Override
    public List<Estate> findByDescriptionContaining(String description) {
        return  EstateMapper.convertToDtoList( repository.findByDescriptionContaining(description));
    }

    @Override
    public Estate create(Estate dto) {
        EstateEntity entity = EstateMapper.convertToEntity( dto);
        Estate estate = EstateMapper.convertToDto( repository.save(entity));
        return estate;
    }

    @Override
    public Estate update(Estate dto) {
        EstateEntity entity = EstateMapper.convertToEntity( dto);
        return EstateMapper.convertToDto( repository.save(entity));
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
