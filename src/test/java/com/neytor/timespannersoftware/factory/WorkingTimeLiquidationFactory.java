package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.WorkingTimeLiquidationEntity;
import com.neytor.timespannersoftware.model.dto.WorkingTimeLiquidation;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class WorkingTimeLiquidationFactory {

    private EasyRandom generator;

    public WorkingTimeLiquidationFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public WorkingTimeLiquidation generateWorkingTimeLiquidationDto(){
        return generator.nextObject( WorkingTimeLiquidation.class );
    }

    public List<WorkingTimeLiquidation> generateWorkingTimeLiquidationDtoList(int streamSize){
        return generator.objects( WorkingTimeLiquidation.class, streamSize ).collect( Collectors.toList());
    }

    public WorkingTimeLiquidationEntity generateWorkingTimeLiquidationEntity(){
        return generator.nextObject( WorkingTimeLiquidationEntity.class );
    }

    public List<WorkingTimeLiquidationEntity> generateWorkingTimeLiquidationEntityList(int streamSize){
        return generator.objects( WorkingTimeLiquidationEntity.class, streamSize ).collect( Collectors.toList());
    }
}
