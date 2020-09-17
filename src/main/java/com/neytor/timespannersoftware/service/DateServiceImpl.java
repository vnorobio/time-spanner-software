package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.DateEntity;
import com.neytor.timespannersoftware.repository.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DateServiceImpl implements DateService{

    private final DateRepository repository;

    @Autowired
    public DateServiceImpl(DateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<DateEntity> findByDate(LocalDate date) {
        return repository.findByDate(date);
    }

    @Override
    public List<DateEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<DateEntity> findByYear(Integer year) {
        return repository.findByYear(year);
    }

    @Override
    public List<DateEntity> findByYearAndWeekOfYear(Integer year, Integer weekOfYear) {
        return repository.findByYearAndWeekOfYear(year,weekOfYear);
    }

    @Override
    public List<DateEntity> findByYearAndMonth(Integer year, Integer month) {
        return repository.findByYearAndMonth(year,month);
    }

    @Override
    public List<DateEntity> findByDateBetween(LocalDate startDate, LocalDate endingDate) {
        return repository.findByDateBetween(startDate,endingDate);
    }

    @Override
    public DateEntity create(DateEntity date) {
        return repository.save(date);
    }

    @Override
    public List<DateEntity> create(List<DateEntity> dates) {
        return repository.saveAll(dates);
    }

    @Override
    public DateEntity update(DateEntity date) {
        return repository.save(date);
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
