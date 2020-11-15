package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.TimeSpanEntity;
import com.neytor.timespannersoftware.model.dto.TimeSpan;
import org.modelmapper.ModelMapper;

public class TimeSpanMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static TimeSpan convertToDto( TimeSpanEntity entity ) {
        return modelMapper.map(entity, TimeSpan.class);
    }

    public static TimeSpanEntity convertToEntity( TimeSpan dto ) {
        return modelMapper.map(dto, TimeSpanEntity.class);
    }

}
