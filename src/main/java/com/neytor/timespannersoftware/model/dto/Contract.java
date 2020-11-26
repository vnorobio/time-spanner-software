package com.neytor.timespannersoftware.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@AllArgsConstructor
@Builder
public class Contract {

    private Long id;

    private String reference;

    private Person person;

    private int contractType;

    private LocalDate startDate;

    private LocalDate endingDate;

    private BigDecimal salary;

    private int payrollPeriodicity;

    private EmployeesGroup employeesGroup;

    private City city;

}
