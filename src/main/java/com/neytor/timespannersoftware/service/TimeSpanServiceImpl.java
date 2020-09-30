package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.TimeSpanEntity;
import com.neytor.timespannersoftware.repository.TimeSpanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeSpanServiceImpl implements TimeSpanService{

    private final TimeSpanRepository repository;

    @Autowired
    public TimeSpanServiceImpl(TimeSpanRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TimeSpanEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TimeSpanEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<TimeSpanEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<TimeSpanEntity> findByIdIn(List<Long> idList) {
        return repository.findAllById(idList);
    }

    @Override
    public List<TimeSpanEntity> findBySpanType(int spanType) {
        return repository.findBySpanType(spanType);
    }

    @Override
    public TimeSpanEntity create(TimeSpanEntity entity) {
        return repository.save(entity);
    }

    @Override
    public TimeSpanEntity update(TimeSpanEntity entity) {
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
