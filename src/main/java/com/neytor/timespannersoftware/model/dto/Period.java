package com.neytor.timespannersoftware.model.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class Period {

    private Long id;

    private String code;

    private Long previousPeriod;

    private Integer year;

    private int periodicity;

    private LocalDate startDate;

    private int duration;

    private LocalDate endingDate;

}
