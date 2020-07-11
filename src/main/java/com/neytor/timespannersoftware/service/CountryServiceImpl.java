package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Autowired
    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CountryEntity> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<CountryEntity> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<CountryEntity> findByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public Optional<CountryEntity> findByNumericCode(Integer numericCode) {
        return this.repository.findByNumericCode(numericCode);
    }

    @Override
    public Optional<CountryEntity> findByAlpha2Code(String alpha2Code) {
        return this.repository.findByAlpha2Code(alpha2Code);
    }

    @Override
    public Optional<CountryEntity> findByAlpha3Code(String alpha3Code) {
        return this.repository.findByAlpha3Code(alpha3Code);
    }

    @Override
    public CountryEntity create(CountryEntity country) {
        return this.repository.save(country);
    }

    @Override
    public CountryEntity update(CountryEntity country) {
        return this.repository.save(country);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return this.repository.existsById(id);
    }
}
