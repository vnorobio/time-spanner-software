package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.dto.Spot;
import org.modelmapper.ModelMapper;

public class SpotMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Spot convertToDto( SpotEntity entity ) {
        return Spot.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .description(entity.getDescription())
                .location(LocationMapper.convertToDto(entity.getLocation()))
                .city(CityMapper.convertToDto(entity.getCity()))
                .build();
    }

    public static SpotEntity convertToEntity( Spot dto ) {
        return modelMapper.map(dto, SpotEntity.class);
    }

}
