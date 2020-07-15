package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.IdentificationEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IdentificationRepository extends JpaRepository<IdentificationEntity, Long> {
    Optional<IdentificationEntity> findByIdentificationNumber(String identificationNumber);
    List<PersonEntity> findByIdentificationNumberContaining(String identificationNumber);
}
