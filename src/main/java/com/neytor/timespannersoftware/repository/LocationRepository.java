package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    Optional<LocationEntity> findByCode(String code);

    List<LocationEntity> findByCodeContaining(String code);

    List<LocationEntity> findByDescriptionContaining(String description);

}
