package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.ScheduleEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@AllArgsConstructor
@Builder
public class ScheduleDetail {

    private Long id;

    private ScheduleEntity schedule;

    private SpotEntity spot;

    private PersonEntity person;

    private ContractEntity contract;

    private int spanType;

    private LocalDate startDate;

    private Long startTime;

    private Long duration;

    private LocalDate endingDate;

    private Long endingTime;

}
