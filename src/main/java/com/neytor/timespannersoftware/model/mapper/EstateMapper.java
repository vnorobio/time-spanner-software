package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.Estate;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EstateMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Estate convertToDto( EstateEntity entity ) {
        return Estate.builder( )
                .id( entity.getId( ) )
                .code( entity.getCode( ) )
                .description( entity.getDescription( ) )
                .country( CountryMapper.convertToDto( entity.getCountry( ) ) )
                .build( );
    }

    public static EstateEntity convertToEntity( Estate dto ) {
        return modelMapper.map( dto, EstateEntity.class );
    }

    public static List< Estate > convertToDtoList( List< EstateEntity > estates ) {

        return estates.stream( ).map( entity -> convertToDto( entity ) ).collect( Collectors.toList( ) );
    }

}
