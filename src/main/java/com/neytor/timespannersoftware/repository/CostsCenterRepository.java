package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.CostsCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CostsCenterRepository extends JpaRepository<CostsCenterEntity, Long> {
    Optional<CostsCenterEntity> findByCode(String code);
    List<CostsCenterEntity> findByCodeContaining(String code);
    List<CostsCenterEntity> findByDescriptionContaining(String description);
}
