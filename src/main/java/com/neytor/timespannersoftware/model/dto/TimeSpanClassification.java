package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class TimeSpanClassification {

    private Long id;

    private ProgrammationTemplate   programmationTemplate;

    private TimeSpan   timeSpan;

    private int startDay;

    private Long startTime;

    private Long duration;

    private int endingDay;

    private Long endingTime;

    private Boolean isOvertime;

    private Boolean isNigth;

    private Boolean isCompensatory;

}
