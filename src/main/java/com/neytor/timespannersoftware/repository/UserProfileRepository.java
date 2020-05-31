package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    List<UserProfileEntity> findByUserId(Long userId);
}
