package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.model.dto.Location;
import org.modelmapper.ModelMapper;

public class LocationMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Location convertToDto( LocationEntity entity ) {
        return modelMapper.map(entity, Location.class);
    }

    public static LocationEntity convertToEntity( Location dto ) {
        return modelMapper.map(dto, LocationEntity.class);
    }

}
