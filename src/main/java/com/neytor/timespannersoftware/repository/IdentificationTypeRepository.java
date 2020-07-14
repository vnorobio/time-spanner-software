package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.IdentificationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationTypeEntity, Long> {
    Optional<IdentificationTypeEntity> findByCode(String code);
    Optional<IdentificationTypeEntity> findByDescription(String description);
    Optional<IdentificationTypeEntity> findByShortenedForm(String shortenedForm);
}
