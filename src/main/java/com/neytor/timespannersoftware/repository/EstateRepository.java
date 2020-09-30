package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.EstateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstateRepository extends JpaRepository<EstateEntity, Long> {
    Optional<EstateEntity> findByCode(String code);
    List<EstateEntity> findByCountry(CountryEntity entity);
    List<EstateEntity> findByCodeContaining(String code);
    List<EstateEntity> findByDescriptionContaining(String description);
}
