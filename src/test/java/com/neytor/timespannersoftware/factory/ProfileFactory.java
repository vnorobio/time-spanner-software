package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.model.dto.Profile;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileFactory {

    private EasyRandom generator;

    public ProfileFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public Profile generateProfileDto(){
        return generator.nextObject( Profile.class );
    }

    public List<Profile> generateProfileDtoList(int streamSize){
        return generator.objects( Profile.class, streamSize ).collect( Collectors.toList());
    }

    public ProfileEntity generateProfileEntity(){
        return generator.nextObject( ProfileEntity.class );
    }

    public List<ProfileEntity> generateProfileEntityList(int streamSize){
        return generator.objects( ProfileEntity.class, streamSize ).collect( Collectors.toList());
    }
}
