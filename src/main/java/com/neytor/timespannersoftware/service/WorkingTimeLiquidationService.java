package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.WorkingTimeLiquidationEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WorkingTimeLiquidationService {

    List<WorkingTimeLiquidationEntity> findAll();

    Optional<WorkingTimeLiquidationEntity> findById(Long id);

    List<WorkingTimeLiquidationEntity> findBySpotAndDateIsGreaterThanEqualAndDateIsLessThanEqual(SpotEntity entity, LocalDate startDate, LocalDate endingDate);

    List<WorkingTimeLiquidationEntity> findByPersonAndDateIsGreaterThanEqualAndDateIsLessThanEqual(PersonEntity entity, LocalDate startDate, LocalDate endingDate);

    List<WorkingTimeLiquidationEntity> findByContractAndDateIsGreaterThanEqualAndDateIsLessThanEqual(ContractEntity entity, LocalDate startDate, LocalDate endingDate);

    WorkingTimeLiquidationEntity create(WorkingTimeLiquidationEntity entity);

    WorkingTimeLiquidationEntity update(WorkingTimeLiquidationEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
