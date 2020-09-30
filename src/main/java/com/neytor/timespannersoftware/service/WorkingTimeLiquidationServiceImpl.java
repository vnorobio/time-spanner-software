package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.WorkingTimeLiquidationEntity;
import com.neytor.timespannersoftware.repository.WorkingTimeLiquidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WorkingTimeLiquidationServiceImpl implements WorkingTimeLiquidationService{

    private final WorkingTimeLiquidationRepository repository;

    @Autowired
    public WorkingTimeLiquidationServiceImpl(WorkingTimeLiquidationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WorkingTimeLiquidationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<WorkingTimeLiquidationEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<WorkingTimeLiquidationEntity> findBySpotAndDateIsGreaterThanEqualAndDateIsLessThanEqual(SpotEntity entity, LocalDate startDate, LocalDate endingDate) {
        return repository.findBySpotAndDateIsGreaterThanEqualAndDateIsLessThanEqual(entity,startDate,endingDate);
    }

    @Override
    public List<WorkingTimeLiquidationEntity> findByPersonAndDateIsGreaterThanEqualAndDateIsLessThanEqual(PersonEntity entity, LocalDate startDate, LocalDate endingDate) {
        return repository.findByPersonAndDateIsGreaterThanEqualAndDateIsLessThanEqual(entity,startDate,endingDate);
    }

    @Override
    public List<WorkingTimeLiquidationEntity> findByContractAndDateIsGreaterThanEqualAndDateIsLessThanEqual(ContractEntity entity, LocalDate startDate, LocalDate endingDate) {
        return repository.findByContractAndDateIsGreaterThanEqualAndDateIsLessThanEqual(entity,startDate,endingDate);
    }

    @Override
    public WorkingTimeLiquidationEntity create(WorkingTimeLiquidationEntity entity) {
        return repository.save(entity);
    }

    @Override
    public WorkingTimeLiquidationEntity update(WorkingTimeLiquidationEntity entity) {
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
