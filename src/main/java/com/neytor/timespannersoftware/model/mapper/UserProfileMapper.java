package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.UserProfileEntity;
import com.neytor.timespannersoftware.model.dto.UserProfile;
import org.modelmapper.ModelMapper;

public class UserProfileMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static UserProfile convertToDto( UserProfileEntity entity ) {
        return modelMapper.map(entity, UserProfile.class);
    }

    public static UserProfileEntity convertToEntity( UserProfile dto ) {
        return modelMapper.map(dto, UserProfileEntity.class);
    }

}
