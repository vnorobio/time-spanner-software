package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.CompanyEntity;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<CompanyEntity> findAll();

    List<CompanyEntity> findByDescriptionContaining(String description);

    Optional<CompanyEntity> findById(Long id);

    Optional<CompanyEntity> findByDescription(String description);

    CompanyEntity create(CompanyEntity company);

    CompanyEntity update(CompanyEntity company);

    void delete(Long id);

    Boolean existsById(Long id);
}
