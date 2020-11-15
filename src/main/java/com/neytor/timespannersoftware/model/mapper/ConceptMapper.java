package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.ConceptEntity;
import com.neytor.timespannersoftware.model.dto.Concept;
import org.modelmapper.ModelMapper;

public class ConceptMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Concept convertToDto( ConceptEntity entity ) {
        return Concept.builder()
                .id(entity.getId())
                .code( entity.getCode( ) )
                .description( entity.getDescription( ) )
                .ratio( entity.getRatio() )
                .build();
    }

    public static ConceptEntity convertToEntity( Concept dto ) {
        return modelMapper.map(dto, ConceptEntity.class);
    }

}
