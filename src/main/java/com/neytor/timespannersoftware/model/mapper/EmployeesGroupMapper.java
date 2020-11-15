package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.EmployeesGroupEntity;
import com.neytor.timespannersoftware.model.dto.EmployeesGroup;
import org.modelmapper.ModelMapper;

public class EmployeesGroupMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static EmployeesGroup convertToDto( EmployeesGroupEntity entity ) {
        return modelMapper.map(entity, EmployeesGroup.class);
    }

    public static EmployeesGroupEntity convertToEntity( EmployeesGroup dto ) {
        return modelMapper.map(dto, EmployeesGroupEntity.class);
    }

}
