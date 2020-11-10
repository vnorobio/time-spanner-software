package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.ScheduleDetailEntity;
import com.neytor.timespannersoftware.model.dto.ScheduleDetail;
import org.modelmapper.ModelMapper;

public class ScheduleDetailMapper {

    private static ModelMapper modelMapper;

    public static ScheduleDetail convertToDto( ScheduleDetailEntity entity ) {
        return modelMapper.map(entity, ScheduleDetail.class);
    }

    public static ScheduleDetailEntity convertToEntity( ScheduleDetail dto ) {
        return modelMapper.map(dto, ScheduleDetailEntity.class);
    }

}
