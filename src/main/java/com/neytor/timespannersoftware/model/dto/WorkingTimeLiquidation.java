package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.*;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@Builder
public class WorkingTimeLiquidation {

    private Long id;

    private LocalDate date;

    private ScheduleEntity schedule;

    private ScheduleDetailEntity detail;

    private SpotEntity spot;

    private PersonEntity person;

    private ContractEntity contract;

    private ConceptEntity concept;

    private BigDecimal appliedRatio;

    private BigDecimal baseSalary;

    private Long amountOfTime;

    private BigDecimal liquidationValue;

}
