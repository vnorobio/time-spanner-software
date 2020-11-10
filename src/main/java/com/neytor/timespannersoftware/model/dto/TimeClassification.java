package com.neytor.timespannersoftware.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TimeClassification {

    private Long id;

    private int startDay;

    private Long startTime;

    private Long duration;

    private int endingDay;

    private Long endingTime;

    private Boolean isOvertime;

    private Boolean isNigth;

    private Boolean isCompensatory;

}
