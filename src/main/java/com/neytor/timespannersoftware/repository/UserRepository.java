package com.neytor.timespannersoftware.repository;

import com.neytor.timespannersoftware.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

     Optional<UserEntity> findByLogin(String login);

     Optional<UserEntity> findByEmail(String email);

}
