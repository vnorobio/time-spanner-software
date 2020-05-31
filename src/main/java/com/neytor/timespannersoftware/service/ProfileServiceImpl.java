package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    private final ProfileRepository repository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProfileEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProfileEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ProfileEntity> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public ProfileEntity create(ProfileEntity profile) {
        return repository.save(profile);
    }

    @Override
    public ProfileEntity update(ProfileEntity profile) {
        return repository.save(profile);
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
