package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.ProgrammationTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgrammationTemplateRepository extends JpaRepository<ProgrammationTemplateEntity, Long> {

    Optional<ProgrammationTemplateEntity> findByCode(String code);

    List<ProgrammationTemplateEntity> findByCodeContains(String code);

    List<ProgrammationTemplateEntity> findByDescriptionContaining(String description);

    List<ProgrammationTemplateEntity> findByTimeOffType(int timeOffType);

}
