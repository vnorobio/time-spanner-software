package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ScheduleClassificationEntity;
import com.neytor.timespannersoftware.model.ScheduleDetailEntity;

import java.util.List;
import java.util.Optional;

public interface ScheduleClassificationService {
    
    List<ScheduleClassificationEntity> findAll();

    Optional<ScheduleClassificationEntity> findById(Long id);

    List<ScheduleClassificationEntity> findByScheduleDetail(ScheduleDetailEntity entity);

    ScheduleClassificationEntity create(ScheduleClassificationEntity entity);

    ScheduleClassificationEntity update(ScheduleClassificationEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
