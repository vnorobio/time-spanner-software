package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.EmployeesGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesGroupRepository extends JpaRepository<EmployeesGroupEntity, Long> {
    Optional<EmployeesGroupEntity> findByCode(String code);
    List<EmployeesGroupEntity> findByCodeContaining(String code);
    List<EmployeesGroupEntity> findByDescriptionContaining(String description);
}
