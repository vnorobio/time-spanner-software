package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.EmployeesGroupEntity;
import com.neytor.timespannersoftware.model.dto.EmployeesGroup;
import org.modelmapper.ModelMapper;

public class EmployeesGroupMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static EmployeesGroup convertToDto( EmployeesGroupEntity entity ) {
        return EmployeesGroup.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .description(entity.getDescription())
                .build();
    }

    public static EmployeesGroupEntity convertToEntity( EmployeesGroup dto ) {
        return modelMapper.map(dto, EmployeesGroupEntity.class);
    }

}
