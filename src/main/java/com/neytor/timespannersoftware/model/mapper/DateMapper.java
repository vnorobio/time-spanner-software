package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.DateEntity;
import com.neytor.timespannersoftware.model.dto.Date;
import org.modelmapper.ModelMapper;

public class DateMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Date convertToDto( DateEntity entity ) {
        return modelMapper.map(entity, Date.class);
    }

    public static DateEntity convertToEntity( Date dto ) {
        return modelMapper.map(dto, DateEntity.class);
    }

}
