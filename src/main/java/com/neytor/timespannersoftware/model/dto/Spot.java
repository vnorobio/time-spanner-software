package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.CityEntity;
import com.neytor.timespannersoftware.model.LocationEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Spot {

    private Long id;

    private String code;

    private String description;

    private LocationEntity location;

    private CityEntity city;

}