package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;


@Value
@AllArgsConstructor
@Builder
public class Concept {

    private Long id;

    private String code;

    private String description;

    private BigDecimal ratio;

}
