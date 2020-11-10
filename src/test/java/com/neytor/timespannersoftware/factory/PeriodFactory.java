package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.PeriodEntity;
import com.neytor.timespannersoftware.model.dto.Period;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class PeriodFactory {

    private EasyRandom generator;

    public PeriodFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Period generatePeriodDto(){
        return generator.nextObject( Period.class );
    }

    public List<Period> generatePeriodDtoList(int streamSize){
        return generator.objects( Period.class, streamSize ).collect( Collectors.toList());
    }

    public PeriodEntity generatePeriodEntity(){
        return generator.nextObject( PeriodEntity.class );
    }

    public List<PeriodEntity> generatePeriodEntityList(int streamSize){
        return generator.objects( PeriodEntity.class, streamSize ).collect( Collectors.toList());
    }
}
