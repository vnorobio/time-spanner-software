package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
    Optional<CityEntity> findByCode(String code);
    List<CityEntity> findByEstate(EstateEntity entity);
    List<CityEntity> findByCountry(CountryEntity entity);
    List<CityEntity> findByCodeContaining(String code);
    List<CityEntity> findByDescriptionContaining(String description);
}
