package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.dto.Contract;
import org.modelmapper.ModelMapper;

public class ContractMapper {

    private static ModelMapper modelMapper;

    public static Contract convertToDto( ContractEntity entity ) {
        return modelMapper.map(entity, Contract.class);
    }

    public static ContractEntity convertToEntity( Contract dto ) {
        return modelMapper.map(dto, ContractEntity.class);
    }

}
