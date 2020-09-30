package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.TimeSpanEntity;

import java.util.List;
import java.util.Optional;

public interface TimeSpanService {

    List<TimeSpanEntity> findAll();

    Optional<TimeSpanEntity> findById(Long id);

    Optional<TimeSpanEntity> findByCode(String code);

    List<TimeSpanEntity> findByIdIn(List<Long> idList);

    List<TimeSpanEntity> findBySpanType(int spanType);

    TimeSpanEntity create(TimeSpanEntity entity);

    TimeSpanEntity update(TimeSpanEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
