package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ProgrammationTemplateEntity;
import com.neytor.timespannersoftware.repository.ProgrammationTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammationTemplateServiceImpl implements  ProgrammationTemplateService{

    private final ProgrammationTemplateRepository repository;

    @Autowired
    public ProgrammationTemplateServiceImpl(ProgrammationTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProgrammationTemplateEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProgrammationTemplateEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ProgrammationTemplateEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<ProgrammationTemplateEntity> findByCodeContains(String code) {
        return repository.findByCodeContains(code);
    }

    @Override
    public List<ProgrammationTemplateEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public List<ProgrammationTemplateEntity> findByTimeOffType(int timeOffType) {
        return repository.findByTimeOffType(timeOffType);
    }

    @Override
    public ProgrammationTemplateEntity create(ProgrammationTemplateEntity entity) {
        return repository.save(entity);
    }

    @Override
    public ProgrammationTemplateEntity update(ProgrammationTemplateEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
