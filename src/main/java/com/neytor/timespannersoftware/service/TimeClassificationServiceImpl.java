package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.TimeClassificationEntity;
import com.neytor.timespannersoftware.repository.TimeClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeClassificationServiceImpl implements  TimeClassificationService{

    private final TimeClassificationRepository repository;

    @Autowired
    public TimeClassificationServiceImpl(TimeClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TimeClassificationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<TimeClassificationEntity> findByIdIn(List<Long> idList) {
        return repository.findByIdIn(idList);
    }

    @Override
    public Optional<TimeClassificationEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public TimeClassificationEntity create(TimeClassificationEntity entity) {
        return repository.save(entity);
    }

    @Override
    public TimeClassificationEntity update(TimeClassificationEntity entity) {
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
