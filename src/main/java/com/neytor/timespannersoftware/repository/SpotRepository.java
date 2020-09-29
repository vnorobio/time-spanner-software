package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.TerritorialDivisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpotRepository extends JpaRepository<SpotEntity, Long> {

    Optional<SpotEntity> findByCode(String code);

    List<SpotEntity> findByCodeContains(String code);

    List<SpotEntity>  findByDescriptionContaining(String description);

    List<SpotEntity> findByLocation(LocationEntity entity);

    List<SpotEntity> findByTerritorialDivision(TerritorialDivisionEntity entity);
}
