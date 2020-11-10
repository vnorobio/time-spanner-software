package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.CountryEntity;
import com.neytor.timespannersoftware.model.dto.Country;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class CountryFactory {

    private EasyRandom generator;

    public CountryFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Country generateCountryDto(){
        return generator.nextObject( Country.class );
    }

    public List<Country> generateCountryDtoList(int streamSize){
        return generator.objects( Country.class, streamSize ).collect( Collectors.toList());
    }

    public CountryEntity generateCountryEntity(){
        return generator.nextObject( CountryEntity.class );
    }

    public List<CountryEntity> generateCountryEntityList(int streamSize){
        return generator.objects( CountryEntity.class, streamSize ).collect( Collectors.toList());
    }
}
