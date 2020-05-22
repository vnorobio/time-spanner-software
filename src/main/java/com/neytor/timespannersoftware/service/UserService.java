package com.neytor.timespannersoftware.service;

import com.neytor.timespannersoftware.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

 public interface UserService{

     List<UserEntity> findAll();

     Optional<UserEntity> findById(Long id);

     Optional<UserEntity> findByLogin(String login);

     Optional<UserEntity> findByEmail(String email);

     UserEntity create(UserEntity user);

     UserEntity update(UserEntity user);

     void delete(Long id);

     Boolean existsById(Long id);

}
