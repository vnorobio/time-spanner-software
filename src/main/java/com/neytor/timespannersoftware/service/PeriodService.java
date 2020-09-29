package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.PeriodEntity;

import java.util.List;
import java.util.Optional;

public interface PeriodService {

    List<PeriodEntity> findAll();

    Optional<PeriodEntity> findById(Long id);

    Optional<PeriodEntity> findByCode(String code);

    List<PeriodEntity> findByCodeContaining(String code);

    List<PeriodEntity> findByYear(int year);

    List<PeriodEntity> findByYearAndPeriodicity(int year, int periodicity);

    PeriodEntity create(PeriodEntity periodEntity);

    PeriodEntity update(PeriodEntity periodEntity);

    void delete(Long id);

    Boolean existsById(Long id);
}
