package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.PeriodEntity;
import com.neytor.timespannersoftware.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodServiceImpl implements PeriodService{

    private final PeriodRepository repository;

    @Autowired
    public PeriodServiceImpl(PeriodRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PeriodEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PeriodEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<PeriodEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<PeriodEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<PeriodEntity> findByYear(int year) {
        return repository.findByYear(year);
    }

    @Override
    public List<PeriodEntity> findByYearAndPeriodicity(int year, int periodicity) {
        return repository.findByYearAndPeriodicity(year, periodicity);
    }

    @Override
    public PeriodEntity create(PeriodEntity periodEntity) {
        return repository.save(periodEntity);
    }

    @Override
    public PeriodEntity update(PeriodEntity periodEntity) {
        return repository.save(periodEntity);
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
