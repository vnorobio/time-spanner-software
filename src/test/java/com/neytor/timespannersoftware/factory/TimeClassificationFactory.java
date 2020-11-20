package com.neytor.timespannersoftware.factory;

import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class TimeClassificationFactory {

    private EasyRandom generator;

    public TimeClassificationFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public TimeClassification generateTimeClassificationDto(){
        return generator.nextObject( TimeClassification.class );
    }

    public List<TimeClassification> generateTimeClassificationDtoList(int streamSize){
        return generator.objects( TimeClassification.class, streamSize ).collect( Collectors.toList());
    }

    public TimeClassificationEntity generateTimeClassificationEntity(){
        return generator.nextObject( TimeClassificationEntity.class );
    }

    public List<TimeClassificationEntity> generateTimeClassificationEntityList(int streamSize){
        return generator.objects( TimeClassificationEntity.class, streamSize ).collect( Collectors.toList());
    }
}
