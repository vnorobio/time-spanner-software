package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.IdentificationTypeEntity;
import com.neytor.timespannersoftware.model.dto.IdentificationType;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class IdentificationTypeFactory {

    private EasyRandom generator;

    public IdentificationTypeFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public IdentificationType generateIdentificationTypeDto(){
        return generator.nextObject( IdentificationType.class );
    }

    public List<IdentificationType> generateIdentificationTypeDtoList(int streamSize){
        return generator.objects( IdentificationType.class, streamSize ).collect( Collectors.toList());
    }

    public IdentificationTypeEntity generateIdentificationTypeEntity(){
        return generator.nextObject( IdentificationTypeEntity.class );
    }

    public List<IdentificationTypeEntity> generateIdentificationTypeEntityList(int streamSize){
        return generator.objects( IdentificationTypeEntity.class, streamSize ).collect( Collectors.toList());
    }
}
