package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.TimeSpanClassificationEntity;
import com.neytor.timespannersoftware.model.TimeSpanEntity;
import com.neytor.timespannersoftware.repository.TimeSpanClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeSpanClassificationServiceImpl implements TimeSpanClassificationService {

    private final TimeSpanClassificationRepository repository;

    @Autowired
    public TimeSpanClassificationServiceImpl(TimeSpanClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TimeSpanClassificationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TimeSpanClassificationEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TimeSpanClassificationEntity> findByTimeSpan(TimeSpanEntity entity) {
        return repository.findByTimeSpan(entity);
    }

    @Override
    public TimeSpanClassificationEntity create(TimeSpanClassificationEntity entity) {
        return repository.save(entity);
    }

    @Override
    public TimeSpanClassificationEntity update(TimeSpanClassificationEntity entity) {
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
