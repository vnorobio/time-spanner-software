package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ProfileEntity;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    List<ProfileEntity> findAll();

    Optional<ProfileEntity> findById(Long id);

    Optional<ProfileEntity> findByDescription(String description);

    ProfileEntity create(ProfileEntity profile);

    ProfileEntity update(ProfileEntity profile);

    void delete(Long id);

    Boolean existsById(Long id);
}
