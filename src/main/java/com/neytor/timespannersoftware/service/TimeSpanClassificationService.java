package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.TimeSpanClassificationEntity;
import com.neytor.timespannersoftware.model.TimeSpanEntity;

import java.util.List;
import java.util.Optional;

public interface TimeSpanClassificationService {
    
    List<TimeSpanClassificationEntity> findAll();

    Optional<TimeSpanClassificationEntity> findById(Long id);

    List<TimeSpanClassificationEntity> findByTimeSpan(TimeSpanEntity entity);

    TimeSpanClassificationEntity create(TimeSpanClassificationEntity entity);

    TimeSpanClassificationEntity update(TimeSpanClassificationEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
