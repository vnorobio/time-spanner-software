package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.ScheduleClassificationEntity;
import com.neytor.timespannersoftware.model.dto.ScheduleClassification;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class ScheduleClassificationFactory {

    private EasyRandom generator;

    public ScheduleClassificationFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public ScheduleClassification generateScheduleClassificationDto(){
        return generator.nextObject( ScheduleClassification.class );
    }

    public List<ScheduleClassification> generateScheduleClassificationDtoList(int streamSize){
        return generator.objects( ScheduleClassification.class, streamSize ).collect( Collectors.toList());
    }

    public ScheduleClassificationEntity generateScheduleClassificationEntity(){
        return generator.nextObject( ScheduleClassificationEntity.class );
    }

    public List<ScheduleClassificationEntity> generateScheduleClassificationEntityList(int streamSize){
        return generator.objects( ScheduleClassificationEntity.class, streamSize ).collect( Collectors.toList());
    }
}
