package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@AllArgsConstructor
@Builder
public class ScheduleClassification {

    private Long id;

    private Schedule schedule;

    private ScheduleDetail scheduleDetail;

    private LocalDate startDate;

    private Long startTime;

    private Long duration;

    private LocalDate endingDate;

    private Long endingTime;

    private Boolean isOvertime;

    private Boolean isNigth;

    private Boolean isCompensatory;
}
