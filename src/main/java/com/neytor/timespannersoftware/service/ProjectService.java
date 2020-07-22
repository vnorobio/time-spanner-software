package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ProjectEntity;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectEntity> findAll();

    Optional<ProjectEntity> findById(Long id);

    Optional<ProjectEntity> findByCode(String code);

    List<ProjectEntity> findByCodeContaining(String code);

    List<ProjectEntity> findByDescriptionContaining(String description);

    ProjectEntity create(ProjectEntity project);

    ProjectEntity update(ProjectEntity project);

    void delete(Long id);

    Boolean existsById(Long id);
}
