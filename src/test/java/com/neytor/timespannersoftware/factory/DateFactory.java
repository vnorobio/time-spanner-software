package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.DateEntity;
import com.neytor.timespannersoftware.model.dto.Date;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class DateFactory {

    private EasyRandom generator;

    public DateFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Date generateDateDto(){
        return generator.nextObject( Date.class );
    }

    public List<Date> generateDateDtoList(int streamSize){
        return generator.objects( Date.class, streamSize ).collect( Collectors.toList());
    }

    public DateEntity generateDateEntity(){
        return generator.nextObject( DateEntity.class );
    }

    public List<DateEntity> generateDateEntityList(int streamSize){
        return generator.objects( DateEntity.class, streamSize ).collect( Collectors.toList());
    }
}
