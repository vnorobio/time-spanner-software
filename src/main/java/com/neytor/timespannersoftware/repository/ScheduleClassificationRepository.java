package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.ScheduleClassificationEntity;
import com.neytor.timespannersoftware.model.ScheduleDetailEntity;
import com.neytor.timespannersoftware.model.TimeClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleClassificationRepository extends JpaRepository<ScheduleClassificationEntity, Long> {

    List<ScheduleClassificationEntity> findByScheduleDetail(ScheduleDetailEntity entity);

}
