package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.ScheduleDetailEntity;
import com.neytor.timespannersoftware.model.dto.ScheduleDetail;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class ScheduleDetailFactory {

    private EasyRandom generator;

    public ScheduleDetailFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public ScheduleDetail generateScheduleDetailDto(){
        return generator.nextObject( ScheduleDetail.class );
    }

    public List<ScheduleDetail> generateScheduleDetailDtoList(int streamSize){
        return generator.objects( ScheduleDetail.class, streamSize ).collect( Collectors.toList());
    }

    public ScheduleDetailEntity generateScheduleDetailEntity(){
        return generator.nextObject( ScheduleDetailEntity.class );
    }

    public List<ScheduleDetailEntity> generateScheduleDetailEntityList(int streamSize){
        return generator.objects( ScheduleDetailEntity.class, streamSize ).collect( Collectors.toList());
    }
}
