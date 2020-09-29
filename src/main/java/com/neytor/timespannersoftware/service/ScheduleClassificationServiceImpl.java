package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ScheduleClassificationEntity;
import com.neytor.timespannersoftware.model.ScheduleDetailEntity;
import com.neytor.timespannersoftware.repository.ScheduleClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleClassificationServiceImpl implements  ScheduleClassificationService{

    private final ScheduleClassificationRepository repository;

    @Autowired
    public ScheduleClassificationServiceImpl(ScheduleClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ScheduleClassificationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ScheduleClassificationEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ScheduleClassificationEntity> findByScheduleDetail(ScheduleDetailEntity entity) {
        return repository.findByScheduleDetail(entity);
    }

    @Override
    public ScheduleClassificationEntity create(ScheduleClassificationEntity entity) {
        return repository.save(entity);
    }

    @Override
    public ScheduleClassificationEntity update(ScheduleClassificationEntity entity) {
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
