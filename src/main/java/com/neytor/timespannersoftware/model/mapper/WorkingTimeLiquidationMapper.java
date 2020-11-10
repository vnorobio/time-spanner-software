package com.neytor.timespannersoftware.model.mapper;

import com.neytor.timespannersoftware.model.WorkingTimeLiquidationEntity;
import com.neytor.timespannersoftware.model.dto.WorkingTimeLiquidation;
import org.modelmapper.ModelMapper;

public class WorkingTimeLiquidationMapper {

    private static ModelMapper modelMapper;

    public static WorkingTimeLiquidation convertToDto( WorkingTimeLiquidationEntity entity ) {
        return modelMapper.map(entity, WorkingTimeLiquidation.class);
    }

    public static WorkingTimeLiquidationEntity convertToEntity( WorkingTimeLiquidation dto ) {
        return modelMapper.map(dto, WorkingTimeLiquidationEntity.class);
    }

}
