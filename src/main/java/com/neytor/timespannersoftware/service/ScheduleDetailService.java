package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ScheduleDetailEntity;
import com.neytor.timespannersoftware.model.ScheduleEntity;

import java.util.List;
import java.util.Optional;

public interface ScheduleDetailService {

    List<ScheduleDetailEntity> findAll();

    Optional<ScheduleDetailEntity> findById(Long id);

    List<ScheduleDetailEntity> findBySchedule(ScheduleEntity entity);

    List<ScheduleDetailEntity> findByScheduleIn(List<ScheduleEntity> entities);

    ScheduleDetailEntity create(ScheduleDetailEntity entity);

    ScheduleDetailEntity update(ScheduleDetailEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
