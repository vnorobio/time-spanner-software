package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.TimeSpanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimeSpanRepository extends JpaRepository<TimeSpanEntity, Long> {

    Optional<TimeSpanEntity> findByCode(String code);

    List<TimeSpanEntity> findByIdIn(List<Long> idList);

    List<TimeSpanEntity> findBySpanType(int spanType);

}
