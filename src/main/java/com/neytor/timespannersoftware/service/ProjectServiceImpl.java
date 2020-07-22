package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ProjectEntity;
import com.neytor.timespannersoftware.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository repository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProjectEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProjectEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ProjectEntity> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<ProjectEntity> findByCodeContaining(String code) {
        return repository.findByCodeContaining(code);
    }

    @Override
    public List<ProjectEntity> findByDescriptionContaining(String description) {
        return repository.findByDescriptionContaining(description);
    }

    @Override
    public ProjectEntity create(ProjectEntity project) {
        return repository.save(project);
    }

    @Override
    public ProjectEntity update(ProjectEntity project) {
        return repository.save(project);
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
