package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.Estate;
import org.modelmapper.ModelMapper;

public class EstateMapper {

    private static ModelMapper modelMapper;

    public static Estate convertToDto( EstateEntity entity ) {
        return modelMapper.map(entity, Estate.class);
    }

    public static EstateEntity convertToEntity( Estate dto ) {
        return modelMapper.map(dto, EstateEntity.class);
    }

}
