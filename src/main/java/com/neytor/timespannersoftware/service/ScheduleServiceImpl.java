package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.ScheduleEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements  ScheduleService{

    private final ScheduleRepository repository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ScheduleEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ScheduleEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ScheduleEntity> findBySpotAndDateIsGreaterThanEqualAndDateIsLessThanEqual(SpotEntity entity, LocalDate startDate, LocalDate endingDate) {
        return repository.findBySpotAndDateIsGreaterThanEqualAndDateIsLessThanEqual( entity, startDate, endingDate);
    }

    @Override
    public List<ScheduleEntity> findByPersonAndDateIsGreaterThanEqualAndDateIsLessThanEqual(PersonEntity entity, LocalDate startDate, LocalDate endingDate) {
        return repository.findByPersonAndDateIsGreaterThanEqualAndDateIsLessThanEqual( entity, startDate, endingDate);
    }

    @Override
    public List<ScheduleEntity> findByContractAndDateIsGreaterThanEqualAndDateIsLessThanEqual(ContractEntity entity, LocalDate startDate, LocalDate endingDate) {
        return repository.findByContractAndDateIsGreaterThanEqualAndDateIsLessThanEqual( entity, startDate, endingDate);
    }

    @Override
    public List<ScheduleEntity> findByTimeOffTypeAndDateIsGreaterThanEqualAndDateIsLessThanEqual(int timeOffType, LocalDate startDate, LocalDate endingDate) {
        return repository.findByTimeOffTypeAndDateIsGreaterThanEqualAndDateIsLessThanEqual(timeOffType, startDate, endingDate);
    }

    @Override
    public ScheduleEntity create(ScheduleEntity entity) {
        return repository.save(entity);
    }

    @Override
    public ScheduleEntity update(ScheduleEntity entity) {
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
