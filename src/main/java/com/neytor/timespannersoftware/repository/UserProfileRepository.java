package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.model.UserEntity;
import com.neytor.timespannersoftware.model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {

    List<UserProfileEntity> findByUser(UserEntity user);

    List<UserProfileEntity> findByProfile(ProfileEntity profile);
}
