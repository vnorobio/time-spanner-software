package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.ConceptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConceptRepository extends JpaRepository <ConceptEntity, Long> {
    Optional<ConceptEntity> findByCode(String description);
    List<ConceptEntity> findByDescriptionContaining(String description);
}
