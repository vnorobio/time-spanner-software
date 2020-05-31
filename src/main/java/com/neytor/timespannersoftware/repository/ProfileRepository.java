package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository  extends JpaRepository<ProfileEntity, Long> {
    Optional<ProfileEntity> findByDescription(String description);
}
