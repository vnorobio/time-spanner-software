package com.neytor.timespannersoftware.model.dto;

import com.neytor.timespannersoftware.model.ContractEntity;
import com.neytor.timespannersoftware.model.PersonEntity;
import com.neytor.timespannersoftware.model.SpotEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDate;

@Value
@Builder
public class Schedule {

    private Long id;

    private LocalDate date;

    private SpotEntity spot;

    private PersonEntity person;

    private ContractEntity contract;

    private int timeOffType;

    private Long ordinaryTimeLapse;

    private Long restTime;

    private String templateCode;

}
