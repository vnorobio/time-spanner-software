package com.neytor.timespannersoftware.model.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;


@Value
@Builder
public class Concept {

    private Long id;

    private String code;

    private String description;

    private BigDecimal ratio;

}
