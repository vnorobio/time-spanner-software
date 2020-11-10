package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.PeriodEntity;
import com.neytor.timespannersoftware.model.dto.Period;
import org.modelmapper.ModelMapper;

public class PeriodMapper {

    private static ModelMapper modelMapper;

    public static Period convertToDto( PeriodEntity entity ) {
        return modelMapper.map(entity, Period.class);
    }

    public static PeriodEntity convertToEntity( Period dto ) {
        return modelMapper.map(dto, PeriodEntity.class);
    }

}
