package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByDescription(String description);
    List<CompanyEntity> findByDescriptionContaining(String description);
}
