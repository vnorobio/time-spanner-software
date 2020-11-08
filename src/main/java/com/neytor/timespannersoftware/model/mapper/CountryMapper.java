package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.dto.Country;
import org.modelmapper.ModelMapper;

public class CountryMapper {

    private static ModelMapper modelMapper;

    public static Country convertToDto( CountryEntity entity ) {
        return modelMapper.map(entity, Country.class);
    }

    public static CountryEntity convertToEntity( Country dto ) {
        return modelMapper.map(dto, CountryEntity.class);
    }

}
