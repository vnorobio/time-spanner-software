package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.exception.EntityNotFoundException;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.dto.Country;
import com.neytor.timespannersoftware.model.mapper.CountryMapper;
import com.neytor.timespannersoftware.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Autowired
    public CountryServiceImpl( CountryRepository repository ) {
        this.repository = repository;
    }

    @Override
    public List< Country > findAll( ) {
        List<CountryEntity> entities = repository.findAll( );
        return entities.stream( ).map( CountryMapper::convertToDto ).collect( Collectors.toList( ) );
    }

    @Override
    public Optional< Country > findById( Long id ) {
        CountryEntity entity = repository.findById( id )
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el id: " + id));
        return Optional.of( CountryMapper.convertToDto( entity ) );
    }

    @Override
    public List< Country > findByName( String name ) {
        List<CountryEntity> entities = this.repository.findByNameContaining( name );
        return entities.stream( ).map( CountryMapper::convertToDto ).collect( Collectors.toList( ) );
    }

    @Override
    public Optional< Country > findByNumericCode( Integer numericCode ) {
        CountryEntity entity = repository.findByNumericCode( numericCode )
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el codigo: " + numericCode));
        return Optional.of( CountryMapper.convertToDto( entity ) );
    }

    @Override
    public Optional< Country > findByAlpha2Code( String alpha2Code ) {
        CountryEntity entity = repository.findByAlpha2Code( alpha2Code )
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el codigo: " + alpha2Code));
        return Optional.of( CountryMapper.convertToDto( entity ) );
    }

    @Override
    public Optional< Country > findByAlpha3Code( String alpha3Code ) {
        CountryEntity entity = repository.findByAlpha3Code( alpha3Code )
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la entidad con el codigo: " + alpha3Code));
        return Optional.of( CountryMapper.convertToDto( entity ) );
    }

    @Override
    public Country create( Country country ) {
        CountryEntity entity = this.repository.save(CountryMapper.convertToEntity( country ));
        return CountryMapper.convertToDto(entity);

    }

    @Override
    public Country update( Country country ) {
        CountryEntity entity = this.repository.save(CountryMapper.convertToEntity( country ));
        return CountryMapper.convertToDto(entity);
    }

    @Override
    public void delete( Long id ) {
        this.repository.deleteById( id );
    }

    @Override
    public Boolean existsById( Long id ) {
        return this.repository.existsById( id );
    }
}
