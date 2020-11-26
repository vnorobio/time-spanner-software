package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class Location {

    private Long id;

    private String code;

    private String description;

    private String address;

    private String phoneNumber;

}
