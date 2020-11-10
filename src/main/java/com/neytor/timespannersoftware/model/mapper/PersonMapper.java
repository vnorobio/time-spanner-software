package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.dto.Person;
import org.modelmapper.ModelMapper;

public class PersonMapper {

    private static ModelMapper modelMapper;

    public static Person convertToDto( PersonEntity entity ) {
        return modelMapper.map(entity, Person.class);
    }

    public static PersonEntity convertToEntity( Person dto ) {
        return modelMapper.map(dto, PersonEntity.class);
    }

}
