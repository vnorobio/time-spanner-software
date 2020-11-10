package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.ScheduleEntity;
import com.neytor.timespannersoftware.model.dto.Schedule;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class ScheduleFactory {

    private EasyRandom generator;

    public ScheduleFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Schedule generateScheduleDto(){
        return generator.nextObject( Schedule.class );
    }

    public List<Schedule> generateScheduleDtoList(int streamSize){
        return generator.objects( Schedule.class, streamSize ).collect( Collectors.toList());
    }

    public ScheduleEntity generateScheduleEntity(){
        return generator.nextObject( ScheduleEntity.class );
    }

    public List<ScheduleEntity> generateScheduleEntityList(int streamSize){
        return generator.objects( ScheduleEntity.class, streamSize ).collect( Collectors.toList());
    }
}
