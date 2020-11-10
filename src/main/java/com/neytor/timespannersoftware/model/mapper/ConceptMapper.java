package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.ConceptEntity;
import com.neytor.timespannersoftware.model.dto.Concept;
import org.modelmapper.ModelMapper;

public class ConceptMapper {

    private static ModelMapper modelMapper;

    public static Concept convertToDto( ConceptEntity entity ) {
        return modelMapper.map(entity, Concept.class);
    }

    public static ConceptEntity convertToEntity( Concept dto ) {
        return modelMapper.map(dto, ConceptEntity.class);
    }

}
