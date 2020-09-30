package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.model.UserEntity;
import com.neytor.timespannersoftware.model.UserProfileEntity;

import java.util.List;
import java.util.Optional;

public interface UserProfileService {

    List<UserProfileEntity> findAll();

    Optional<UserProfileEntity> findById(Long id);

    List<UserProfileEntity> findByUser(UserEntity user);

    List<UserProfileEntity> findByProfile (ProfileEntity profile);

    UserProfileEntity create(UserProfileEntity entity);

    UserProfileEntity update(UserProfileEntity entity);

    void delete(Long id);

    Boolean existsById(Long id);
}
