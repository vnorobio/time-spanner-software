package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.DateEntity;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DateService {
    Optional<DateEntity> findByDate(LocalDate date);
    List<DateEntity> findByCodeContaining(String code);
    List<DateEntity> findByYear(Integer year);
    List<DateEntity> findByYearAndWeekOfYear(Integer year, Integer weekOfYear);
    List<DateEntity> findByYearAndMonth(Integer year, Integer month);
    List<DateEntity> findByDateBetween(LocalDate startDate, LocalDate endingDate);
    DateEntity create(DateEntity date);
    List<DateEntity> create(List<DateEntity> dates);
    DateEntity update(DateEntity date);
    void delete(Long id);
    Boolean existsById(Long id);
}
