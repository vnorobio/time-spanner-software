package com.neytor.timespannersoftware.factory;

import com.neytor.timespannersoftware.model.UserProfileEntity;
import com.neytor.timespannersoftware.model.dto.UserProfile;
import org.jeasy.random.EasyRandom;

import java.util.List;
import java.util.stream.Collectors;

public class UserProfileFactory {

    private EasyRandom generator;

    public UserProfileFactory( ) {
        this.generator = new EasyRandom(  );
    }

    public UserProfile generateUserProfileDto(){
        return generator.nextObject( UserProfile.class );
    }

    public List<UserProfile> generateUserProfileDtoList(int streamSize){
        return generator.objects( UserProfile.class, streamSize ).collect( Collectors.toList());
    }

    public UserProfileEntity generateUserProfileEntity(){
        return generator.nextObject( UserProfileEntity.class );
    }

    public List<UserProfileEntity> generateUserProfileEntityList(int streamSize){
        return generator.objects( UserProfileEntity.class, streamSize ).collect( Collectors.toList());
    }
}
