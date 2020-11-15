package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.CountryEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Estate {

    private Long id;

    private String code;

    private String description;

    private Country country;


}
