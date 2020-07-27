package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ContractEntity;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<ContractEntity> findAll();

    Optional<ContractEntity> findById(Long id);

    Optional<ContractEntity> findByReference(String reference);

    List<ContractEntity> findByIdentificationNumber(String identificationNumber);

    List<ContractEntity> findByIdentificationNumberContaining(String identificationNumber);

    List<ContractEntity> findByFullNameContaining(String fullName);

    ContractEntity create(ContractEntity contractEntity);

    ContractEntity update(ContractEntity contractEntity);

    void delete(Long id);

    Boolean existsById(Long id);
}
