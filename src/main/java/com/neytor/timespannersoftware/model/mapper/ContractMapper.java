package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.dto.Contract;
import org.modelmapper.ModelMapper;

public class ContractMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Contract convertToDto( ContractEntity entity ) {
        return Contract.builder()
                .id(entity.getId())
                .reference(entity.getReference())
                .person(PersonMapper.convertToDto(entity.getPerson()))
                .contractType(entity.getContractType())
                .startDate(entity.getStartDate())
                .endingDate(entity.getEndingDate())
                .salary(entity.getSalary())
                .payrollPeriodicity(entity.getPayrollPeriodicity())
                .employeesGroup(EmployeesGroupMapper.convertToDto(entity.getEmployeesGroup()))
                .city(CityMapper.convertToDto(entity.getCity()))
                .build();
    }

    public static ContractEntity convertToEntity( Contract dto ) {
        return modelMapper.map(dto, ContractEntity.class);
    }

}
