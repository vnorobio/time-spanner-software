package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.TimeClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeClassificationRepository extends JpaRepository<TimeClassificationEntity, Long> {

    List<TimeClassificationEntity> findByIdIn(List<Long> idList);

}
