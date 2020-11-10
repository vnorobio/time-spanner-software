package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.model.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;

@Value
@Builder
public class UserProfile {

    private Long id;

    private UserEntity user;

    private ProfileEntity profile;

}
