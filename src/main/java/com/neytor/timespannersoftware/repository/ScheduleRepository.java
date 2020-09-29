package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    List<ScheduleEntity> findBySpotAndDateIsGreaterThanEqualAndDateIsLessThanEqual(SpotEntity entity, LocalDate startDate, LocalDate endingDate);

    List<ScheduleEntity> findByPersonAndDateIsGreaterThanEqualAndDateIsLessThanEqual(PersonEntity entity, LocalDate startDate, LocalDate endingDate);

    List<ScheduleEntity> findByContractAndDateIsGreaterThanEqualAndDateIsLessThanEqual(ContractEntity entity, LocalDate startDate, LocalDate endingDate);

    List<ScheduleEntity> findByTimeOffTypeAndDateIsGreaterThanEqualAndDateIsLessThanEqual(int timeOffType, LocalDate startDate, LocalDate endingDate);

}
