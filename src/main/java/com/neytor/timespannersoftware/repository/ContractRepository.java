package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
    Optional<ContractEntity> findByReference(String reference);
    List<ContractEntity> findByPersonIdentificationNumber(String identificationNumber);
    List<ContractEntity> findByPersonIdentificationNumberContaining(String identificationNumber);
    List<ContractEntity> findByPersonFullNameContaining(String fullName);
}
