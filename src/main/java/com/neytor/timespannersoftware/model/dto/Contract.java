package com.neytor.timespannersoftware.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Contract {

    private Long id;

    @NonNull
    private String reference;

    @NonNull
    private Person person;

    private int contractType;

    @NonNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endingDate;

    @NonNull
    private BigDecimal salary;

    private int payrollPeriodicity;

    @NonNull
    private EmployeesGroup employeesGroup;

    @NonNull
    private City city;

    public Contract(@JsonProperty("id") Long id,
                    @JsonProperty("reference") @NonNull String reference,
                    @JsonProperty("person") @NonNull Person person,
                    @JsonProperty("contractType") int contractType,
                    @JsonProperty("startDate") @NonNull LocalDate startDate,
                    @JsonProperty("endingDate") LocalDate endingDate,
                    @JsonProperty("salary") @NonNull BigDecimal salary,
                    @JsonProperty("payrollPeriodicity") int payrollPeriodicity,
                    @JsonProperty("employeesGroup") @NonNull EmployeesGroup employeesGroup,
                    @JsonProperty("city") @NonNull City city) {
        this.id = id;
        this.reference = reference;
        this.person = person;
        this.contractType = contractType;
        this.startDate = startDate;
        this.endingDate = endingDate;
        this.salary = salary;
        this.payrollPeriodicity = payrollPeriodicity;
        this.employeesGroup = employeesGroup;
        this.city = city;
    }
}
