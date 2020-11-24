package com.neytor.timespannersoftware.model.dto;

import lombok.*;

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
