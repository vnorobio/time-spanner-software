package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.ProfileEntity;
import com.neytor.timespannersoftware.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class UserProfile {

    private Long id;

    private UserEntity user;

    private ProfileEntity profile;

}
