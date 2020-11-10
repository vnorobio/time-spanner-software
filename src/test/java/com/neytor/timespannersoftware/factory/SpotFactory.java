package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.SpotEntity;
import com.neytor.timespannersoftware.model.dto.Spot;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class SpotFactory {

    private EasyRandom generator;

    public SpotFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Spot generateSpotDto(){
        return generator.nextObject( Spot.class );
    }

    public List<Spot> generateSpotDtoList(int streamSize){
        return generator.objects( Spot.class, streamSize ).collect( Collectors.toList());
    }

    public SpotEntity generateSpotEntity(){
        return generator.nextObject( SpotEntity.class );
    }

    public List<SpotEntity> generateSpotEntityList(int streamSize){
        return generator.objects( SpotEntity.class, streamSize ).collect( Collectors.toList());
    }
}
