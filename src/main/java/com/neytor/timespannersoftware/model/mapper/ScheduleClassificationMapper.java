package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.ScheduleClassificationEntity;
import com.neytor.timespannersoftware.model.dto.ScheduleClassification;
import org.modelmapper.ModelMapper;

public class ScheduleClassificationMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ScheduleClassification convertToDto( ScheduleClassificationEntity entity ) {
        return modelMapper.map(entity, ScheduleClassification.class);
    }

    public static ScheduleClassificationEntity convertToEntity( ScheduleClassification dto ) {
        return modelMapper.map(dto, ScheduleClassificationEntity.class);
    }

}
