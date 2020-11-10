package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.dto.City;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class CityFactory {

    private EasyRandom generator;

    public CityFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public City generateCityDto(){
        return generator.nextObject( City.class );
    }

    public List<City> generateCityDtoList(int streamSize){
        return generator.objects( City.class, streamSize ).collect( Collectors.toList());
    }

    public CityEntity generateCityEntity(){
        return generator.nextObject( CityEntity.class );
    }

    public List<CityEntity> generateCityEntityList(int streamSize){
        return generator.objects( CityEntity.class, streamSize ).collect( Collectors.toList());
    }
}
