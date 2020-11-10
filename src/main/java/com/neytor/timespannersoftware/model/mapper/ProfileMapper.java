package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.model.dto.Profile;
import org.modelmapper.ModelMapper;

public class ProfileMapper {

    private static ModelMapper modelMapper;

    public static Profile convertToDto( ProfileEntity entity ) {
        return modelMapper.map(entity, Profile.class);
    }

    public static ProfileEntity convertToEntity( Profile dto ) {
        return modelMapper.map(dto, ProfileEntity.class);
    }

}
