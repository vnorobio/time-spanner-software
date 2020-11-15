package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.IdentificationTypeEntity;
import com.neytor.timespannersoftware.model.dto.IdentificationType;
import org.modelmapper.ModelMapper;

public class IdentificationTypeMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static IdentificationType convertToDto( IdentificationTypeEntity entity ) {
        return modelMapper.map(entity, IdentificationType.class);
    }

    public static IdentificationTypeEntity convertToEntity( IdentificationType dto ) {
        return modelMapper.map(dto, IdentificationTypeEntity.class);
    }

}
