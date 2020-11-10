package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.dto.Country;
import org.modelmapper.ModelMapper;

public class CountryMapper {

    private static ModelMapper modelMapper = new ModelMapper( );


    public static Country convertToDto( CountryEntity entity ) {
        return Country.builder( )
                .id( entity.getId( ) )
                .name( entity.getName( ) )
                .numericCode( entity.getNumericCode( ) )
                .alpha2Code( entity.getAlpha2Code( ) )
                .alpha3Code( entity.getAlpha3Code( ) ).build( );

    }

    public static CountryEntity convertToEntity( Country dto ) {

        return modelMapper.map( dto, CountryEntity.class );
    }

}
