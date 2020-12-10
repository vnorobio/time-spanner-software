package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<Contract> findAll();

    Optional<Contract> findById(Long id);

    Optional<Contract> findByReference(String reference);

    List<Contract> findByIdentificationNumber(String identificationNumber);

    List<Contract> findByIdentificationNumberContaining(String identificationNumber);

    List<Contract> findByFullNameContaining(String fullName);

    Contract create(Contract dto);

    Contract update(Contract dto);

    void delete(Long id);

    Boolean existsById(Long id);
}
