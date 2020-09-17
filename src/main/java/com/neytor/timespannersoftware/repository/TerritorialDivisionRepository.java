package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.TerritorialDivisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TerritorialDivisionRepository extends JpaRepository<TerritorialDivisionEntity, Long> {
    Optional<TerritorialDivisionEntity> findByCode(String code);
    List<TerritorialDivisionEntity> findByCodeContaining(String code);
    List<TerritorialDivisionEntity> findByDescriptionContaining(String description);
}
