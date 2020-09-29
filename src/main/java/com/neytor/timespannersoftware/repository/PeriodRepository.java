package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.PeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeriodRepository extends JpaRepository<PeriodEntity, Long> {

    Optional<PeriodEntity> findByCode(String code);

    List<PeriodEntity> findByCodeContaining(String code);

    List<PeriodEntity> findByYear(int year);

    List<PeriodEntity> findByYearAndPeriodicity(int year, int periodicity);
}
