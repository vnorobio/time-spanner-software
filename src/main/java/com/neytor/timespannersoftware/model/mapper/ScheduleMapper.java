package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.ScheduleEntity;
import com.neytor.timespannersoftware.model.dto.Schedule;
import org.modelmapper.ModelMapper;

public class ScheduleMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Schedule convertToDto( ScheduleEntity entity ) {
        return modelMapper.map(entity, Schedule.class);
    }

    public static ScheduleEntity convertToEntity( Schedule dto ) {
        return modelMapper.map(dto, ScheduleEntity.class);
    }

}
