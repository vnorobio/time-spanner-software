package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.OperatingCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperatingCenterRepository extends JpaRepository<OperatingCenterEntity, Long> {
    Optional<OperatingCenterEntity> findByCode(String code);
    List<OperatingCenterEntity> findByCodeContaining(String code);
    List<OperatingCenterEntity> findByDescriptionContaining(String description);
}
