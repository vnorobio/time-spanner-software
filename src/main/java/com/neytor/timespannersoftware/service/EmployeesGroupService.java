package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.dto.EmployeesGroup;

import java.util.List;
import java.util.Optional;

public interface EmployeesGroupService {
    List<EmployeesGroup> findAll();

    Optional<EmployeesGroup> findById(Long id);

    Optional<EmployeesGroup> findByCode(String code);

    List<EmployeesGroup> findByCodeContaining(String code);

    List<EmployeesGroup> findByDescriptionContaining(String description);

    EmployeesGroup create(EmployeesGroup dto);

    EmployeesGroup update(EmployeesGroup dto);

    void delete(Long id);

    Boolean existsById(Long id);
}
