package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.TimeClassificationEntity;
import com.neytor.timespannersoftware.model.dto.TimeClassification;
import org.modelmapper.ModelMapper;

public class TimeClassificationMapper {

    private static ModelMapper modelMapper;

    public static TimeClassification convertToDto( TimeClassificationEntity entity ) {
        return modelMapper.map(entity, TimeClassification.class);
    }

    public static TimeClassificationEntity convertToEntity( TimeClassification dto ) {
        return modelMapper.map(dto, TimeClassificationEntity.class);
    }

}
