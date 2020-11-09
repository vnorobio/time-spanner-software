package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.dto.City;
import org.modelmapper.ModelMapper;

public class CityMapper {

    private static ModelMapper modelMapper;

    public static City convertToDto( CityEntity entity ) {
        return modelMapper.map(entity, City.class);
    }

    public static CityEntity convertToEntity( City dto ) {
        return modelMapper.map(dto, CityEntity.class);
    }

}
