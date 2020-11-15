package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.dto.Spot;
import org.modelmapper.ModelMapper;

public class SpotMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Spot convertToDto( SpotEntity entity ) {
        return modelMapper.map(entity, Spot.class);
    }

    public static SpotEntity convertToEntity( Spot dto ) {
        return modelMapper.map(dto, SpotEntity.class);
    }

}
