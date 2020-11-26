package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.WorkingTimeLiquidationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkingTimeLiquidationRepository extends JpaRepository<WorkingTimeLiquidationEntity, Long> {
    List<WorkingTimeLiquidationEntity> findBySpotAndDateIsGreaterThanEqualAndDateIsLessThanEqual(SpotEntity entity, LocalDate startDate, LocalDate endingDate);

    List<WorkingTimeLiquidationEntity> findByPersonAndDateIsGreaterThanEqualAndDateIsLessThanEqual(PersonEntity entity, LocalDate startDate, LocalDate endingDate);

    List<WorkingTimeLiquidationEntity> findByContractAndDateIsGreaterThanEqualAndDateIsLessThanEqual(ContractEntity entity, LocalDate startDate, LocalDate endingDate);

}
