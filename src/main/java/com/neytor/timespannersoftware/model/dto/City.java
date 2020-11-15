package com.neytor.timespannersoftware.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class City {

    private Long id;

    private String code;

    private String description;

    private Estate estate;

    private Country country;

}
