package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.EmployeesGroupEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeesGroupService {
    List<EmployeesGroupEntity> findAll();

    Optional<EmployeesGroupEntity> findById(Long id);

    Optional<EmployeesGroupEntity> findByCode(String code);

    List<EmployeesGroupEntity> findByCodeContaining(String code);

    List<EmployeesGroupEntity> findByDescriptionContaining(String description);

    EmployeesGroupEntity create(EmployeesGroupEntity employeesGroupEntity);

    EmployeesGroupEntity update(EmployeesGroupEntity employeesGroupEntity);

    void delete(Long id);

    Boolean existsById(Long id);
}
