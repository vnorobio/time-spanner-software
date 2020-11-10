package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.EstateEntity;
import com.neytor.timespannersoftware.model.dto.Estate;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class EstateFactory {

    private EasyRandom generator;

    public EstateFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Estate generateEstateDto(){
        return generator.nextObject( Estate.class );
    }

    public List<Estate> generateEstateDtoList(int streamSize){
        return generator.objects( Estate.class, streamSize ).collect( Collectors.toList());
    }

    public EstateEntity generateEstateEntity(){
        return generator.nextObject( EstateEntity.class );
    }

    public List<EstateEntity> generateEstateEntityList(int streamSize){
        return generator.objects( EstateEntity.class, streamSize ).collect( Collectors.toList());
    }
}
