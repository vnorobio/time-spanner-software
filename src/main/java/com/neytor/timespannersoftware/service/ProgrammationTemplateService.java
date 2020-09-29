package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ProgrammationTemplateEntity;

import java.util.List;
import java.util.Optional;

public interface ProgrammationTemplateService {

    List<ProgrammationTemplateEntity> findAll();

    Optional<ProgrammationTemplateEntity> findById(Long id);

    Optional<ProgrammationTemplateEntity> findByCode(String code);

    List<ProgrammationTemplateEntity> findByCodeContains(String code);

    List<ProgrammationTemplateEntity> findByDescriptionContaining(String description);

    List<ProgrammationTemplateEntity> findByTimeOffType(int timeOffType);

    ProgrammationTemplateEntity create(ProgrammationTemplateEntity entity);

    ProgrammationTemplateEntity update(ProgrammationTemplateEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
