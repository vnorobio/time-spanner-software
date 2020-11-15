package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.UserEntity;
import com.neytor.timespannersoftware.model.dto.User;
import org.modelmapper.ModelMapper;

public class UserMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static User convertToDto( UserEntity entity ) {
        return modelMapper.map(entity, User.class);
    }

    public static UserEntity convertToEntity( User dto ) {
        return modelMapper.map(dto, UserEntity.class);
    }

}
