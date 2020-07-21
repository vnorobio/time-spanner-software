package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    Optional<ProjectEntity> findByCode(String code);
    List<ProjectEntity> findByCodeContaining(String code);
    List<ProjectEntity> findByDescriptionContaining(String description);
}
