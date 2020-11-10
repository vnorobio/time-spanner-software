package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.LocationEntity;
import com.neytor.timespannersoftware.model.dto.Location;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class LocationFactory {

    private EasyRandom generator;

    public LocationFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Location generateLocationDto(){
        return generator.nextObject( Location.class );
    }

    public List<Location> generateLocationDtoList(int streamSize){
        return generator.objects( Location.class, streamSize ).collect( Collectors.toList());
    }

    public LocationEntity generateLocationEntity(){
        return generator.nextObject( LocationEntity.class );
    }

    public List<LocationEntity> generateLocationEntityList(int streamSize){
        return generator.objects( LocationEntity.class, streamSize ).collect( Collectors.toList());
    }
}
