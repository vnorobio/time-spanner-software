package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ScheduleDetailEntity;
import com.neytor.timespannersoftware.model.ScheduleEntity;
import com.neytor.timespannersoftware.repository.ScheduleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleDetailServiceImpl implements ScheduleDetailService {

    private final ScheduleDetailRepository repository;

    @Autowired
    public ScheduleDetailServiceImpl(ScheduleDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ScheduleDetailEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ScheduleDetailEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ScheduleDetailEntity> findBySchedule(ScheduleEntity entity) {
        return repository.findBySchedule(entity);
    }

    @Override
    public List<ScheduleDetailEntity> findByScheduleIn(List<ScheduleEntity> entities) {
        return repository.findByScheduleIn(entities);
    }

    @Override
    public ScheduleDetailEntity create(ScheduleDetailEntity entity) {
        return repository.save(entity);
    }

    @Override
    public ScheduleDetailEntity update(ScheduleDetailEntity entity) {
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
