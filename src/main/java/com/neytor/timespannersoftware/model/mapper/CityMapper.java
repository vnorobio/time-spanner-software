package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.dto.City;
import org.modelmapper.ModelMapper;

public class CityMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static City convertToDto( CityEntity entity ) {
        return City.builder()
                .id( entity.getId( ) )
                .code( entity.getCode( ) )
                .description( entity.getDescription( ) )
                .estate( EstateMapper.convertToDto( entity.getEstate() ) )
                .country( CountryMapper.convertToDto( entity.getCountry() ) )
                .build();
    }

    public static CityEntity convertToEntity( City dto ) {
        return modelMapper.map(dto, CityEntity.class);
    }

}
