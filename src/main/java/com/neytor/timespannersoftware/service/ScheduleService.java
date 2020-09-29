package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.ScheduleEntity;
import com.neytor.timespannersoftware.model.SpotEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    List<ScheduleEntity> findAll();

    Optional<ScheduleEntity> findById(Long id);

    List<ScheduleEntity> findBySpotAndDateIsGreaterThanEqualAndDateIsLessThanEqual(SpotEntity entity, LocalDate startDate, LocalDate endingDate);

    List<ScheduleEntity> findByPersonAndDateIsGreaterThanEqualAndDateIsLessThanEqual(PersonEntity entity, LocalDate startDate, LocalDate endingDate);

    List<ScheduleEntity> findByContractAndDateIsGreaterThanEqualAndDateIsLessThanEqual(ContractEntity entity, LocalDate startDate, LocalDate endingDate);

    List<ScheduleEntity> findByTimeOffTypeAndDateIsGreaterThanEqualAndDateIsLessThanEqual(int timeOffType, LocalDate startDate, LocalDate endingDate);

    ScheduleEntity create(ScheduleEntity entity);

    ScheduleEntity update(ScheduleEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
