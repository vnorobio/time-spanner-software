package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.model.UserEntity;
import com.neytor.timespannersoftware.model.UserProfileEntity;
import com.neytor.timespannersoftware.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    private final UserProfileRepository repository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserProfileEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UserProfileEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserProfileEntity> findByUser(UserEntity user) {
        return repository.findByUser(user);
    }

    @Override
    public List<UserProfileEntity> findByProfile(ProfileEntity profile) {
        return repository.findByProfile(profile);
    }

    @Override
    public UserProfileEntity create(UserProfileEntity entity) {
        return repository.save(entity);
    }

    @Override
    public UserProfileEntity update(UserProfileEntity entity) {
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
