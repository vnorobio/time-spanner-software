package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.TimeClassificationEntity;

import java.util.List;
import java.util.Optional;

public interface TimeClassificationService {

    List<TimeClassificationEntity> findAll();

    List<TimeClassificationEntity> findByIdIn(List<Long> idList);

    Optional<TimeClassificationEntity> findById(Long id);

    TimeClassificationEntity create(TimeClassificationEntity entity);

    TimeClassificationEntity update(TimeClassificationEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
