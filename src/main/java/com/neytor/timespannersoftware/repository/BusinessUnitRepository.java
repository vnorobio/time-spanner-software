package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.BusinessUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessUnitRepository extends JpaRepository<BusinessUnitEntity, Long> {
    Optional<BusinessUnitEntity> findByCode(String code);
    List<BusinessUnitEntity> findByCodeContaining(String code);
    List<BusinessUnitEntity> findByDescriptionContaining(String description);
}
