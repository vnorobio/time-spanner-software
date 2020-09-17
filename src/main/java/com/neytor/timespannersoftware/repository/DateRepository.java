package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.DateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DateRepository extends JpaRepository<DateEntity, Long> {
    Optional<DateEntity> findByDate(LocalDate date);
    List<DateEntity> findByCodeContaining(String code);
    List<DateEntity> findByYear(Integer year);
    List<DateEntity> findByYearAndWeekOfYear(Integer year, Integer week);
    List<DateEntity> findByYearAndMonth(Integer year, Integer month);
    List<DateEntity> findByDateBetween(LocalDate startDate, LocalDate endingDate);
}
