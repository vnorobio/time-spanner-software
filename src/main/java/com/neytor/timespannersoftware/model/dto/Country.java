package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class Country {

    private Long id;

    private String name;

    private Integer numericCode;

    private String alpha2Code;

    private String alpha3Code;




}
