package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.TimeSpanClassificationEntity;
import com.neytor.timespannersoftware.model.TimeSpanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSpanClassificationRepository extends JpaRepository<TimeSpanClassificationEntity, Long> {

    List<TimeSpanClassificationEntity> findByTimeSpan(TimeSpanEntity entity);

}
