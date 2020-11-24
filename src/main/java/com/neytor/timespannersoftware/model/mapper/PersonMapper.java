package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.IdentificationTypeEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.dto.IdentificationType;
import com.neytor.timespannersoftware.model.dto.Person;
import org.modelmapper.ModelMapper;

public class PersonMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Person convertToDto( PersonEntity entity ) {
        IdentificationTypeEntity entityType = entity.getIdentificationType();
        IdentificationType dtoType = IdentificationType.builder()
                .id(entityType.getId())
                .code(entityType.getCode())
                .shortenedForm(entityType.getShortenedForm())
                .description(entityType.getDescription())
                .build();
        return Person.builder()
                .id(entity.getId())
                .identificationType(dtoType)
                .identificationNumber(entity.getIdentificationNumber())
                .firstName(entity.getFirstName())
                .secondName(entity.getSecondName())
                .firstSurname(entity.getFirstSurname())
                .secondSurname(entity.getSecondSurname())
                .fullName(entity.getFullName())
                .gender(entity.getGender())
                .maritalStatus(entity.getMaritalStatus())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmail())
                .build();
    }

    public static PersonEntity convertToEntity( Person dto ) {
        return modelMapper.map(dto, PersonEntity.class);
    }

}
